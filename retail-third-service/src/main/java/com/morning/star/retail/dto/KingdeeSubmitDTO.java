package com.morning.star.retail.dto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 外部服务分类dto
 *
 * @author kimhuhg
 */
@ApiModel
public class KingdeeSubmitDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;


    public KingdeeSubmitDTO(){}

    public KingdeeSubmitDTO(String number){
        List<String> list = new ArrayList<>(1);
        list.add(number);
        this.numbers = list;
    }
    @JSONField(name="Numbers")
    private List<String> numbers;


    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }
}
