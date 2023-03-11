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
     */
    @Test
    void contextLoads() {
        ClientParam clientParam = new ClientParam();
        clientParam.setType("lx");
        String text = apiClient.getText(clientParam);
        String imageUrl = apiClient.getImageUrl(clientParam);
        //注意如果测试的时候出现有时有有时无,请把所有断点去掉
        System.out.println(text);
        System.out.println(imageUrl);
    }

}
