package edu.yangao.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.SpecVersion;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YangAo
 * @Description 配置swagger
 * @create 2022-08-22 15:36
 */
@Configuration
public class SwaggerConfig {
    /**
     * 采用配置文件进行配置 swagger
     * @return swagger 配置类
     */
    @Bean
    @ConfigurationProperties("open-api")
    public OpenAPI openApi() {
        return new OpenAPI(SpecVersion.V31);
    }
}
