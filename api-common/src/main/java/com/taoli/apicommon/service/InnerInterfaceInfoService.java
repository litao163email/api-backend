package com.taoli.apicommon.service;

import com.taoli.apicommon.model.entity.InterfaceInfo;

/**
 *  公共接口,用于统计
 * @author taoli
 */
public interface InnerInterfaceInfoService {

    /**
     * 从数据库中查询模拟接口是否存在（请求路径、请求方法、请求参数）
     */
    InterfaceInfo getInterfaceInfo(String path, String method);
}
