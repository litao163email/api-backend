package com.taoli.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taoli.apicommon.model.entity.UserInterfaceInfo;
import com.taoli.project.common.ErrorCode;
import com.taoli.project.exception.BusinessException;
import com.taoli.project.mapper.InterfaceInfoMapper;
import com.taoli.project.model.vo.InterfaceInfoVO;
import com.taoli.project.service.InterfaceInfoService;
import com.taoli.apicommon.model.entity.InterfaceInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();
        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        // 判断
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        UpdateWrapper<InterfaceInfo> updateInterfaceWrapper = new UpdateWrapper<>();
        updateInterfaceWrapper.eq("id",interfaceInfoId);
        updateInterfaceWrapper.setSql("useCount = useCount + 1");
        boolean update = this.update(updateInterfaceWrapper);

        return update;
    }

    @Override
    public List<InterfaceInfo> getUseCount() {
        QueryWrapper<InterfaceInfo> interfaceInfoQueryWrapper = new QueryWrapper<>();
        interfaceInfoQueryWrapper.orderByDesc("useCount");
        interfaceInfoQueryWrapper.last("limit 5");
        List<InterfaceInfo> list = this.list(interfaceInfoQueryWrapper);
        return list;
    }
}




