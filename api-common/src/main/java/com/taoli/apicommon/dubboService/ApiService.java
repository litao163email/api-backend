package com.taoli.apicommon.dubboService;

import com.taoli.apicommon.model.entity.ClientParam;

/**
 *  博天api服务
 * @author litao163email@163.com
 *  (dubboService这个文件夹是所有dubbo都可以使用的方法,注意一定要引入dubbo依赖,否则会报错)
 */
public interface ApiService {

    /**
     * 获取图片url
     * @return String
     */
     String getImageUrl(ClientParam clientParam);

    /**
     * 获取随机文本
     * @return String
     */
     String getText(ClientParam clientParam);
}
