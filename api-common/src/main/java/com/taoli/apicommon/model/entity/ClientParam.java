package com.taoli.apicommon.model.entity;

import lombok.Data;

import java.util.List;

/**
 * 用户
 * @author taoli
 */
@Data
public class ClientParam {

    /**
     * 普通api
     */

    private String name;

    private String type;

    private String format;

    private String method;

    /**
     * 编辑距离算法
     */

    private String stringParam1;

    private String stringParam2;

    private List<String> listParam1;

    private List<String> listParam2;

}
