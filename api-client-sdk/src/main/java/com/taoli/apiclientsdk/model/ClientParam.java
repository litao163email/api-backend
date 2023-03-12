package com.taoli.apiclientsdk.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 用户
 * @author taoli
 */
@Data
public class ClientParam {

    /**
     * 普通api(博天)
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

    private List<String> listParam1= new ArrayList<>();

    private List<String> listParam2= new ArrayList<>();

}
