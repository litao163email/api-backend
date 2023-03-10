package com.taoli.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taoli.apicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
 * @Entity com.taoli.project.model.entity.UserInterfaceInfo
 */
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




