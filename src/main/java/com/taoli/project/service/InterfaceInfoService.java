package com.taoli.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taoli.apicommon.model.entity.InterfaceInfo;
import com.taoli.project.model.vo.InterfaceInfoVO;

import java.util.List;

/**
 *
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    boolean invokeCount(long interfaceInfoId, long userId);

    List<InterfaceInfo> getUseCount();
}
