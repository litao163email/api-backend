package com.taoli.apiinterface.controller;

import com.taoli.apicommon.model.entity.ClientParam;
import com.taoli.apiinterface.service.ApiServiceImpl;
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
    ApiServiceImpl apiServiceImpl;

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

}
