package com.taoli.apiinterface;

import com.taoli.apiclientsdk.client.ApiClient;
import com.taoli.apiclientsdk.model.ClientParam;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class ApiInterfaceApplicationTests {

    @Resource
    private ApiClient apiClient;

    /**
     * 测试API
     * sdk(数据库user要有两个key)-网关(数据库interface_info要有数据)-interface项目(要有对应api实现类)
     */
    @Test
    void testApi() {
        ClientParam clientParam = new ClientParam();
        clientParam.setType("lx");
        String text = apiClient.getText(clientParam);
        String imageUrl = apiClient.getImageUrl(clientParam);
        //注意如果测试的时候出现有时有有时无,请把所有断点去掉
        System.out.println(text);
        System.out.println(imageUrl);
    }

    /**
     * 测试API
     * 编辑距离算法
     * sdk(数据库user要有两个key)-网关(数据库interface_info要有数据)-interface项目(要有对应api实现类)
     */
    @Test
    void testAlgorithm() {
        ClientParam clientParam = new ClientParam();
        clientParam.setStringParam1("taoli");
        clientParam.setStringParam2("aolit");
        String distance = apiClient.minDistance(clientParam);
        //注意如果测试的时候出现有时有有时无,请把所有断点去掉
        System.out.println(distance);
    }
}
