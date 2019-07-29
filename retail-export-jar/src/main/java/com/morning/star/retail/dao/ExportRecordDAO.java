package com.morning.star.retail.dao;

import com.morning.star.retail.export.dto.ExportRecordDTO;

public interface ExportRecordDAO {

    void update(ExportRecordDTO param);

    void add(ExportRecordDTO param);

}
