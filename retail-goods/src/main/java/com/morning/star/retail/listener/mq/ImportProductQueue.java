package com.morning.star.retail.listener.mq;

import com.morning.star.retail.facade.dto.ProductImportDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImportProductQueue extends AbstractQueue<List<ProductImportDTO>> {

    public ImportProductQueue() {

        super(ImportProductQueue.class.getSimpleName());
    }

}
