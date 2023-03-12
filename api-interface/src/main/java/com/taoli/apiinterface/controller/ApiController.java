package com.taoli.apiinterface.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.taoli.apicommon.dubboService.AlgorithmService;
import com.taoli.apicommon.dubboService.ApiService;
import com.taoli.apicommon.model.entity.ClientParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.apache.commons.lang3.StringUtils;

/**
 * API服务
 *
 * @author taoli
 */
@RestController
@RequestMapping("/apiService")
@Slf4j
public class ApiController {

    @Autowired
    ApiService apiServiceImpl;

    @Autowired
    AlgorithmService algorithmService;

    @PostMapping("/getImageUrl")
    public String getImageUrl(@RequestBody ClientParam clientParam) {
        String imageUrl = apiServiceImpl.getImageUrl(clientParam);
        if (StringUtils.isBlank(imageUrl)){
            throw  new RuntimeException("获取图片接口异常");
        }
        return imageUrl;
    }

    @PostMapping("/getText")
    public String getText(@RequestBody ClientParam clientParam) {
        String text = apiServiceImpl.getText(clientParam);
        if (StringUtils.isBlank(text)){
            throw new RuntimeException("获取文本接口异常");
        }
        return text;
    }


    @PostMapping("/minDistance")
    public String minDistance(@RequestBody ClientParam clientParam) {
        int distance=0;
        if (!StringUtils.isAnyBlank(clientParam.getStringParam1(),clientParam.getStringParam2())){
            distance = algorithmService.minDistance(clientParam.getStringParam1(),clientParam.getStringParam2());
            return String.valueOf(distance);
        }else if(CollectionUtils.isNotEmpty(clientParam.getListParam1()) && CollectionUtils.isNotEmpty(clientParam.getListParam2())){
            distance = algorithmService.minDistance(clientParam.getListParam1(),clientParam.getListParam2());
            return String.valueOf(distance);
        }else {
            throw new RuntimeException("参数错误");
        }
    }

}
