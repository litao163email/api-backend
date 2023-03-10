package com.taoli.apiinterface;

import com.taoli.apiclientsdk.client.ApiClient;
import com.taoli.apiclientsdk.model.User;
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
        String result = apiClient.getNameByGet("taoli");
        User user = new User();
        user.setUsername("taoli");
        String usernameByPost = apiClient.getUsernameByPost(user);
        String taoli = apiClient.getNameByPost("taoli");

        System.out.println(result);
        System.out.println(usernameByPost);
        System.out.println(taoli);
    }

}
