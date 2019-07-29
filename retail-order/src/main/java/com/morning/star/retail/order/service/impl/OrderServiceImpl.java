package com.morning.star.retail.order.service.impl;

import com.morning.star.retail.facade.GoodsAdminFacade;
import com.morning.star.retail.facade.dto.GoodsDTO;
import com.morning.star.retail.order.dao.BusAfterSalesOrderDAO;
import com.morning.star.retail.order.dao.BusOrderStatisticsDAO;
import com.morning.star.retail.order.domain.entity.*;
import com.morning.star.retail.order.domain.entity.repository.BusOrderStatisticsRepository;
import com.morning.star.retail.order.enums.BusAfterSalesStatusEnum;
import com.morning.star.retail.order.enums.PaymentStatus;
import com.morning.star.retail.order.enums.SalesOrderStatus;
import com.morning.star.retail.order.enums.SalesOrderType;
import com.morning.star.retail.order.event.SalesOrderCreateEvent;
import com.morning.star.retail.order.exception.OrderException;
import com.morning.star.retail.order.facade.dto.*;
import com.morning.star.retail.order.facade.order.dto.OrderGoodsItemDTO;
import com.morning.star.retail.order.facade.order.dto.PaymentDTO;
import com.morning.star.retail.order.facade.order.req.LoginParams;
import com.morning.star.retail.order.facade.order.req.OrderListReqParams;
import com.morning.star.retail.order.facade.order.req.OrderReqParams;
import com.morning.star.retail.order.facade.order.resp.SalesOrderVO;
import com.morning.star.retail.order.helper.OrderVoHelper;
import com.morning.star.retail.order.service.OrderService;
import com.morning.star.retail.repository.OrderGoodsRepository;
import com.morning.star.retail.repository.OrderPaymentRepository;
import com.morning.star.retail.repository.OrderRepository;
import com.morning.star.retail.user.UserPermission;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.util.Context;
import com.morning.star.retail.util.DateUtil;
import com.morning.star.retail.util.Json;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.Validate;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderGoodsRepository orderGoodsRepository;

    @Autowired
    private GoodsAdminFacade goodsFacade;

    @Autowired
    private OrderVoHelper orderVoHelper;

    @Autowired
    private OrderPaymentRepository paymentRepository;
    @Autowired
    private BusAfterSalesOrderDAO busAfterSalesOrderDAO;
    @Autowired
    private BusOrderStatisticsRepository busOrderStatisticsRepository;
    @Autowired
    private BusOrderStatisticsDAO busOrderStatisticsDAO;

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public String posOrder(OrderReqParams params) {
        Validate.notNull(params.getOrderCode(), "订单号不能为空!");
        SalesOrderEntity byOrderCode = orderRepository.getByOrderCode(params.getOrderCode());
        Validate.isTrue(byOrderCode == null, "该订单号已经存在!");
        if (params.getOrderTime() == null) {
            //使用系统时间
            params.setOrderTime(new Date());
        }
        Validate.notNull(params.getTotalAmount(), "订单总额不能为空!");
        Validate.notNull(params.getDiscountAmount(), "订单优惠金额不能空!");
        Validate.noNullElements(params.getGoodsItems(), "订单商品不能空!");


        SalesOrderEntity salesOrderEntity = new SalesOrderEntity();
        BeanUtils.copyProperties(params, salesOrderEntity);

        //商品明细
        List<SalesOrderItemEntity> goods = buildItems(params);
        salesOrderEntity.setItems(goods);

        //购买人
        if (params.getBuyer() != null) {
            BuyerEntity buyerEntity = new BuyerEntity();
            BeanUtils.copyProperties(params.getBuyer(), buyerEntity);
        }

        //组织结构
        DepartmentEntity departmentEntity = buildDepartment(params);
        salesOrderEntity.setDepartment(departmentEntity);

        //订单流水
        List<SalesOrderOperationEntity> operations = buildOperations();
        salesOrderEntity.setOperation(operations);

        //线下订单
        salesOrderEntity.setOrderType(SalesOrderType.OFFLINE_ORDER);
        //订单状态
        salesOrderEntity.setOrderStatus(SalesOrderStatus.WAIT_PAY);

//        //TODO 支付需求未定，先默认走下单就走现金支付
//        List<PaymentEntity> payments = needDelete(params);
//        salesOrderEntity.setPayment(payments);

        orderRepository.save(salesOrderEntity);
        Context.publish(new SalesOrderCreateEvent(salesOrderEntity));
        return salesOrderEntity.getOrderCode();
    }


    @Override
    public PageBean<SalesOrderVO> querySalesOrderPage(OrderListReqParams reqParams) {

        logger.info("querySalesOrderPage==========================" + Json.toJson(reqParams));

        Specification specification = buildQueryParams(reqParams);
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = new PageRequest(reqParams.getPageNo() - 1, reqParams.getPageSize(), sort);
        Page<SalesOrderEntity> page = orderRepository.findAll(specification, pageable);
        List<SalesOrderVO> list = buildSalesOrderVoList(page.getContent());

        logger.info("result==================================" + Json.toJson(list));

        return new PageBean<>(page.getTotalElements(), list, page.getNumber(), page.getSize(), page.getTotalPages());
    }

    private List<SalesOrderVO> buildSalesOrderVoList(List<SalesOrderEntity> content) {
        if (CollectionUtils.isEmpty(content)) {
            return new ArrayList<>();
        }
        List<SalesOrderVO> list = new ArrayList<>();
        content.stream().forEach(salesOrderEntity -> {
            SalesOrderVO salesOrderVO = new SalesOrderVO();
            BeanUtils.copyProperties(salesOrderEntity, salesOrderVO);
            DepartmentEntity department = salesOrderEntity.getDepartment();
            BeanUtils.copyProperties(department, salesOrderVO);

            salesOrderVO.setTotalBuyNum(this.getTotalBuyNum(salesOrderEntity.getItems()));
            salesOrderVO.setOrderStatus(salesOrderEntity.getOrderStatus().getCode());
            salesOrderVO.setCanceling(salesOrderEntity.getOrderStatus() == SalesOrderStatus.CLOSE ? true : false);
            salesOrderVO.setOrderType(salesOrderEntity.getOrderType().getCode());
            salesOrderVO.setOrderTime(DateUtil.toString(salesOrderEntity.getCreateTime()));
            // salesOrderVO.setPayment(buildPayment(salesOrderEntity.getPayment()));
            list.add(salesOrderVO);
        });
        return list;
    }

    private List<PaymentDTO> buildPayment(List<PaymentEntity> payment) {
        List<PaymentDTO> list = new ArrayList<>();
        if (!CollectionUtils.isEmpty(payment)) {
            payment.stream().forEach(paymentEntity -> {
                PaymentDTO paymentDTO = new PaymentDTO();
                BeanUtils.copyProperties(paymentEntity, paymentDTO);
                list.add(paymentDTO);
            });
        }
        return list;
    }

    private BigDecimal getTotalBuyNum(List<SalesOrderItemEntity> items) {
        BigDecimal totalBuyNum = BigDecimal.ZERO;
        for (SalesOrderItemEntity salesOrderItemEntity : items) {
            totalBuyNum = totalBuyNum.add(salesOrderItemEntity.getBuyNum());
        }
        return totalBuyNum;
    }

    private Specification buildQueryParams(OrderListReqParams reqParams) {
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (!StringUtils.isEmpty(reqParams.getOrderType())) {
                    predicates.add(cb.equal(root.get("orderType"), reqParams.getOrderType()));
                }
                if (!StringUtils.isEmpty(reqParams.getStartTime()) && !StringUtils.isEmpty(reqParams.getEndTime())) {
                    predicates.add(cb.between(root.get("createTime"), reqParams.getStartTime(), reqParams.getEndTime()));
                }
                if (!StringUtils.isEmpty(reqParams.getOrderStatus())) {
                    predicates.add(cb.equal(root.get("orderStatus"), SalesOrderStatus.getStatusByCode(reqParams.getOrderStatus())));
                }
                if (!StringUtils.isEmpty(reqParams.getStoreName())) {
                    predicates.add(cb.like(root.get("department").get("storeName"), "%" + reqParams.getStoreName() + "%"));
                }
                if (!StringUtils.isEmpty(reqParams.getOrderCode())) {
                    predicates.add(cb.like(root.get("orderCode"), "%" + reqParams.getOrderCode() + "%"));
                }
                if (!StringUtils.isEmpty(reqParams.getBuyerName())) {
                    predicates.add(cb.like(root.get("buyer").get("buyerName"), "%" + reqParams.getBuyerName() + "%"));
                }
                if (!StringUtils.isEmpty(reqParams.getBuyerPhone())) {
                    predicates.add(cb.like(root.get("buyer").get("buyerPhone"), "%" + reqParams.getBuyerPhone() + "%"));
                }
                //数据权限
                if (!StringUtils.isEmpty(reqParams.getStoreCode())) {
                    predicates.add(cb.equal(root.get("department").get("storeCode"), reqParams.getStoreCode()));
                }
                if (!StringUtils.isEmpty(reqParams.getGroupCode())) {
                    predicates.add(cb.equal(root.get("department").get("groupCode"), reqParams.getGroupCode()));
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return specification;
    }

    @Override
    public SalesOrderVO getSalesOrder(String orderCode) {
        SalesOrderEntity entity = orderRepository.findOne(orderCode);

        return orderVoHelper
                .buildBase(entity)
                .buildBuyer(entity.getBuyer())
                .buildGoods(entity.getItems())
                .buildOperation(entity.getOperation())
                .done();
    }

    @Override
    public List<OrderGoodsItemDTO> getOrderGoodsItem(String orderCode) {
        //List<SalesOrderItemEntity> entities = orderGoodsRepository.findAllByOrderCode(orderCode);

        List<OrderGoodsItemDTO> list = new ArrayList<>();
        /*if (!CollectionUtils.isEmpty(entities)) {
            entities.stream().forEach(entity -> {
                OrderGoodsItemDTO orderGoodsItemDTO = new OrderGoodsItemDTO();
                BeanUtils.copyProperties(entity, orderGoodsItemDTO);
                list.add(orderGoodsItemDTO);
            });
        }*/
        return list;
    }

    @Override
    public void test() {
        List<SalesOrderEntity> all = orderRepository.findAll();
        all.stream().forEach(a -> {
            PaymentEntity paymentEntity = new PaymentEntity();
            paymentEntity.setPayAmount(a.getTotalAmount());
            // paymentEntity.setPayChannel(PayChannel.CASH);
            paymentEntity.setPayStatus(PaymentStatus.PAY_SUCC);
            paymentEntity.setPayTime(new Date());
            paymentEntity.setPayTradeNo("ZF" + System.currentTimeMillis());
            paymentEntity.setOrderCode(a.getOrderCode());
            paymentRepository.save(paymentEntity);
        });
    }

    @Override
    public PageBean<BusAfterSalesDTO> getBusAfterSales(BusAfterSalesQueryDTO busAfterSalesQueryDTO) {
        Validate.notNull(busAfterSalesQueryDTO.getPageNo(), "分页参数不能为空");
        Validate.notNull(busAfterSalesQueryDTO.getPageSize(), "分页参数不能为空");
        RowBounds build = RowBoundsBuilder.build(busAfterSalesQueryDTO.getPageNo(), busAfterSalesQueryDTO.getPageSize());
        com.github.pagehelper.Page<BusAfterSalesDTO> result = busAfterSalesOrderDAO.getBusAfterSales(busAfterSalesQueryDTO, build);
        return new PageBeanAssembler().toBean(result);
    }

    @Override
    public void statisticOrder(Date date) {
        BusOrderStatisticsEntity entity = busOrderStatisticsDAO.statisticsOrder(date);
        BusOrderStatisticsEntity byDate = busOrderStatisticsRepository.getByDate(date);
        if (byDate != null) {
            byDate.setCount(entity.getCount());
            byDate.setAmount(entity.getAmount());
            busOrderStatisticsRepository.save(byDate);
        } else {
            busOrderStatisticsRepository.save(entity);
        }
    }

    @Override
    public List<BusOrderStatisticsDTO> getOrderStatistics(BusOrderStatisticsQueryDTO query) {
        List<BusOrderStatisticsEntity> byDateBetween = busOrderStatisticsRepository.getByDateBetween(query.getStartTime(), query.getEndTime());
        List<BusOrderStatisticsDTO> list = new ArrayList<>();
        for (BusOrderStatisticsEntity entity : byDateBetween) {
            BusOrderStatisticsDTO dto = new BusOrderStatisticsDTO();
            com.morning.star.retail.utils.entity.BeanUtils.copy(entity, dto);
            list.add(dto);
        }
        return list;
    }

    @Override
    public BusOrderStatusStatisticsDTO statisticOrderStatus() {
        BusOrderStatusStatisticsDTO dto = new BusOrderStatusStatisticsDTO();
        Integer no_deal = busOrderStatisticsDAO.statisticOrderStatus(0);
        Integer dealed = busOrderStatisticsDAO.statisticOrderStatus(1);
        Integer settlement = busOrderStatisticsDAO.statisticOrderStatus(2);
        Integer after_sales_num = busOrderStatisticsDAO.getNoDealAfterSalesNum();
        dto.setNo_deal_num(no_deal == null ? 0 : no_deal);
        dto.setDealed_num(dealed == null ? 0 : dealed);
        dto.setSettlement_num(settlement == null ? 0 : settlement);
        dto.setAfter_sales_num(after_sales_num == null ? 0 : after_sales_num);
        return dto;
    }

    @Override
    public List<BusTopItemsDTO> getBusTopItems() {
        return busOrderStatisticsDAO.getBusTopItems();
    }

    private List<SalesOrderOperationEntity> buildOperations() {
        List<SalesOrderOperationEntity> list = new ArrayList<>();
        SalesOrderOperationEntity salesOrderOperationEntity = new SalesOrderOperationEntity();
        salesOrderOperationEntity.setOrderStatus(SalesOrderStatus.DONE);
        list.add(salesOrderOperationEntity);
        return list;
    }

    private DepartmentEntity buildDepartment(OrderReqParams params) {
        LoginParams loginParams = params.getLoginParams();
        if (loginParams == null) {
            throw new OrderException("组织结构为空，无登陆人信息！");
        }
        DepartmentEntity departmentEntity = new DepartmentEntity();
        BeanUtils.copyProperties(loginParams, departmentEntity);
        return departmentEntity;
    }


    /**
     * 构建订单下的商品
     *
     * @param params
     * @return
     */
    private List<SalesOrderItemEntity> buildItems(OrderReqParams params) {
        if (CollectionUtils.isEmpty(params.getGoodsItems())) {
            throw new OrderException("订单明细为空！");
        }
        List<SalesOrderItemEntity> items = new ArrayList<>();
        params.getGoodsItems().stream().forEach(dto -> {
            SalesOrderItemEntity entity = new SalesOrderItemEntity();
            BeanUtils.copyProperties(dto, entity);
            entity.setBuyTime(params.getOrderTime());

            GoodsDTO goods = goodsFacade.getGoods(dto.getGoodsCode());

            //数据权限校验
            new UserPermission(UserUtils.currentUser())
                    .tag("storeCode", params.getLoginParams().getStoreCode())
                    .pass();

            if (goods == null) {
                throw new OrderException("商品服务数据为空:" + dto.getGoodsCode());
            }
            BeanUtils.copyProperties(goods, entity);
            entity.setGoodsName(goods.getProductName());
            entity.setOriginalPrice(goods.getSalePrice());

            if (StringUtils.isEmpty(goods.getSpuInfo())) {
                entity.setSpecInfo("无规格");
            } else {
                entity.setSpecInfo(goods.getSpuInfo());
            }
            entity.setUnit(goods.getUnitsName());
            //存在优惠金额时
            if (dto.getDiscountAmount().compareTo(BigDecimal.ZERO) != 0) {
                entity.setAvgPrice(algorithmAvg(dto));
            }
            //5级类目
            CategoryEntity categoryEntity = new CategoryEntity();
            BeanUtils.copyProperties(goods, categoryEntity);

            //5级组织结构(为了统计小柜组销量所以冗余)
            DepartmentEntity departmentEntity = new DepartmentEntity();
            BeanUtils.copyProperties(goods, departmentEntity);

            entity.setCategoryEntity(categoryEntity);
            entity.setDepartment(departmentEntity);
            items.add(entity);
        });
        return items;
    }

    /**
     * 如果有优惠金额，计算每件的均摊金额
     *
     * @param dto
     * @return
     */
    private BigDecimal algorithmAvg(OrderGoodsItemDTO dto) {
        BigDecimal discountAmount = dto.getDiscountAmount();
        BigDecimal buyNum = dto.getBuyNum();
        return discountAmount.divide(buyNum);
    }


}
