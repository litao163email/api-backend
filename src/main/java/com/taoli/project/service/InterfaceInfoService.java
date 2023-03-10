package com.taoli.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taoli.apicommon.model.entity.InterfaceInfo;

/**
 *
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
