package com.taoli.project.service.impl.inner;

import com.taoli.project.service.InterfaceInfoService;
import com.taoli.project.service.UserInterfaceInfoService;
import com.taoli.apicommon.dubboService.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Resource
    private InterfaceInfoService interfaceInfoService;

    /**
     * 统计次数+1
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
//        boolean Success = userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
        boolean isSuccess = interfaceInfoService.invokeCount(interfaceInfoId, userId);
        return isSuccess;
    }
}
