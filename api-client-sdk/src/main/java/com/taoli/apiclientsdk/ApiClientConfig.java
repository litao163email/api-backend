package com.taoli.apiclientsdk;

import com.taoli.apiclientsdk.client.ApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author taoli
 */
@Configuration
@ConfigurationProperties("api.client")
@Data
@ComponentScan
public class ApiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public ApiClient getApiClient() {
        return new ApiClient(accessKey, secretKey);
    }

}
