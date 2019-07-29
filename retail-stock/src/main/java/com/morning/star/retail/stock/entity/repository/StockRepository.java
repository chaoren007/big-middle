package com.morning.star.retail.stock.entity.repository;

import com.morning.star.retail.stock.entity.StockEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface StockRepository extends Repository<StockEntity, Long> {

    StockEntity getByProductCodeAndWarehouseCode(String productCode, String warehouseCode);

    StockEntity getByUpcCodeAndWarehouseCode(String upcCode, String warehouseCode);

    StockEntity getByGoodsCodeAndWarehouseCode(String goodsCode, String warehouseCode);

    void save(StockEntity entity);

    @Modifying
    @Query(value = "update StockEntity set doneInStockNum = doneInStockNum + :num where goodsCode = :goodsCode and warehouseCode = :warehouseCode")
    void directInStock(@Param("num") BigDecimal num, @Param("goodsCode") String goodsCode, @Param("warehouseCode") String warehouseCode);

    @Modifying
    @Query(value = "update StockEntity set waitInStockNum = waitInStockNum + :num where goodsCode = :goodsCode and warehouseCode = :warehouseCode")
    void waitInStock(@Param("num") BigDecimal num, @Param("goodsCode") String goodsCode, @Param("warehouseCode") String warehouseCode);

    @Modifying
    @Query(value = "update StockEntity set doneInStockNum = doneInStockNum + :doneInStockNum, waitInStockNum = waitInStockNum - :waitInStockNum where goodsCode = :goodsCode and warehouseCode = :warehouseCode")
    void doneInStock(@Param("doneInStockNum") BigDecimal doneInStockNum, @Param("waitInStockNum") BigDecimal waitInStockNum, @Param("goodsCode") String goodsCode, @Param("warehouseCode") String warehouseCode);

    @Modifying
    @Query(value = "update StockEntity set doneInStockNum = doneInStockNum - :num, doneOutStockNum = doneOutStockNum + :num where goodsCode = :goodsCode and warehouseCode = :warehouseCode")
    void directOutStock(@Param("num") BigDecimal num, @Param("goodsCode") String goodsCode, @Param("warehouseCode") String warehouseCode);

    @Modifying
    @Query(value = "update StockEntity set preStockNum = preStockNum + :num where goodsCode = :goodsCode and warehouseCode = :warehouseCode")
    void preStock(@Param("num") BigDecimal num, @Param("goodsCode") String goodsCode, @Param("warehouseCode") String warehouseCode);

    @Modifying
    @Query(value = "update StockEntity set preStockNum = preStockNum - :num where goodsCode = :goodsCode and warehouseCode = :warehouseCode")
    void freePreStock(@Param("num") BigDecimal num, @Param("goodsCode") String goodsCode, @Param("warehouseCode") String warehouseCode);

    @Modifying
    @Query(value = "update StockEntity set preStockNum = preStockNum - :num, waitOutStockNum = waitOutStockNum + :num where goodsCode = :goodsCode and warehouseCode = :warehouseCode")
    void waitOutStock(@Param("num") BigDecimal num, @Param("goodsCode") String goodsCode, @Param("warehouseCode") String warehouseCode);

    @Modifying
    @Query(value = "update StockEntity set preStockNum = preStockNum + :num, waitOutStockNum = waitOutStockNum - :num where goodsCode = :goodsCode and warehouseCode = :warehouseCode")
    void freeWaitOutStock(@Param("num") BigDecimal num, @Param("goodsCode") String goodsCode, @Param("warehouseCode") String warehouseCode);

    @Modifying
    @Query(value = "update StockEntity set doneInStockNum = doneInStockNum - :num, waitOutStockNum = waitOutStockNum - :num, doneOutStockNum = doneOutStockNum + :num  where goodsCode = :goodsCode and warehouseCode = :warehouseCode")
    void doneOutStock(BigDecimal num, String goodsCode, String warehouseCode);
}
