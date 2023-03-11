package com.taoli.project.model.vo;

import com.taoli.apicommon.model.entity.InterfaceInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 接口信息封装视图
 *
 * @author taoli
 * @TableName product
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InterfaceInfoVO extends InterfaceInfo {

    public InterfaceInfoVO(Integer totalNum,String name){
        this.totalNum=totalNum;
        this.name=name;
    }

    /**
     * 调用次数
     */
    private Integer totalNum;
    /**
     * 接口名称
     */
    private String name;

    private static final long serialVersionUID = 1L;
}