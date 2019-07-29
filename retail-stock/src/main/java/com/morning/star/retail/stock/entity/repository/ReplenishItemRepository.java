package com.morning.star.retail.stock.entity.repository;


import com.morning.star.retail.stock.entity.ReplenishItemEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ReplenishItemRepository extends Repository<ReplenishItemEntity, Long> {

    void save(ReplenishItemEntity replenishItemEntity);

    void delete(ReplenishItemEntity replenishItemEntity);

    void deleteByReplenishCode(String replenishCode);

    List<ReplenishItemEntity> queryByReplenishCode(String code);

    ReplenishItemEntity getByReplenishCodeAndGoodsCode(String replenishCode, String goodsCode);

    ReplenishItemEntity getByReplenishCodeAndProductCode(String replenishCode, String productCode);


}
