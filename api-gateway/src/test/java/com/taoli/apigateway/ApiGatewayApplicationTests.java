package com.taoli.apigateway;
import com.taoli.project.provider.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiGatewayApplicationTests {

    @DubboReference
    private DemoService demoService;

    @Test
    void contextLoads() {
        String result = demoService.sayHello("world");
        String result2 = demoService.sayHello2("world");
        System.out.println("result11: " + result);
        System.out.println("result22: " + result2);
    }

}
