package com.taoli.apigateway;
import com.taoli.apicommon.dubboService.InnerUserService;
import com.taoli.apicommon.model.entity.User;
import com.taoli.project.provider.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableDubbo
class ApiGatewayApplicationTests {

    @DubboReference
    private DemoService demoService;

    @DubboReference
    private InnerUserService innerUserService;

    @Test
    void contextLoads() {
        User result = innerUserService.getInvokeUser("12345678");
        System.out.println("User: " + result);
    }

}
