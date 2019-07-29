package com.morning.star.retail.mq.consumer;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.morning.star.retail.facade.StockFacade;
import com.morning.star.retail.stock.dto.StockFormDTO;
import com.morning.star.retail.stock.enums.StockRecordTypeEnum;
import com.morning.star.retail.user.UserInfo;
import com.morning.star.retail.user.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;

@Component
public class ImportStockConsumer {
    private static final Gson GSON = new Gson();
    private static final Logger LOGGER = LoggerFactory.getLogger(ImportStockConsumer.class);
    private static ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private StockFacade stockFacade;

    static {
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    @RabbitListener(queues = "ImportStockQueue")
    public void onMessage(Message msg) {
        try {
            JsonNode list = mapper.readTree(msg.getBody());

            if (list.size() == 0) {
                return;
            }
            UserInfo userInfo = UserUtils.currentUser();
            LOGGER.info(" start ------------------------ importStockConsumer ------------------------ params:{}", GSON.toJson(list));
            StringBuilder content = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                boolean succ = false;
                JsonNode o = list.get(i);
                String goodsCode = o.get("goodsCode").asText();
                String storeCode = o.get("storeCode").asText();
                String doneInStockNum = o.get("doneInStockNum").asText();
                String errorMsg = null;

                try {
                    StockFormDTO formDTO = new StockFormDTO();
                    formDTO.setStoreCode(storeCode);
                    formDTO.setGoodsCode(goodsCode);
                    formDTO.setDoneInStockNum(new BigDecimal(doneInStockNum));
                    formDTO.setGroupCode(userInfo.getTag("groupCode"));
                    formDTO.setStockRecordType(StockRecordTypeEnum.ADMIN_IMPORT);
                    formDTO.setOrderCode("0");
                    formDTO.setOrderStatus("0");
                    stockFacade.save(formDTO);
                    succ = true;
                } catch (Exception e) {
                    LOGGER.error("import stock", e);
                    errorMsg = e.getMessage();
                }
                if (!succ) {
                    content
                            .append(i + 1).append(" ")
                            .append(goodsCode).append(" ")
                            .append(storeCode).append(" ")
                            .append(doneInStockNum).append(" ")
                            .append(errorMsg)
                            .append("<br>");
                }
            }

//            StringBuilder title = new StringBuilder("导入库存数据")
//                    .append(list.get(0).get("_no").asText())
//                    .append("~").append(list.get(list.size() - 1).get("_no").asText()).append("行");

            //TODO 暂时删除
            //RetailNoticeUtils.noticeForEmail(title.toString(), content.length() == 0 ? "导入成功" :
            //       "失败列表:<br>行数 商品编码 门店 数量 错误<br>" + content.toString(), Arrays.asList(login.getEmail()));

            LOGGER.info(" end ------------------------ importStockConsumer ------------------------ ");
        } catch (IOException e) {
            LOGGER.error("import stock consumer", e);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }

}
