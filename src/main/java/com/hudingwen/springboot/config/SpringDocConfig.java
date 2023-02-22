package com.hudingwen.springboot.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:SpringDocConfig
 * Package:com.hudingwen.springboot.config
 * Description:描述
 * Date:2022-10-21 15:15:04
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/
@Configuration
public class SpringDocConfig {

    private String title = "接口文档";
    private String description = "描述";
    private String version = "v1.0";
    private String websiteName = "爱玩云";
    private String websiteUrl = "https://www.aiwanyun.cn";

    @Bean
    public OpenAPI heroOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(title)
                        .description(description)
                        .version(version))
                .externalDocs(new ExternalDocumentation().description(websiteName)
                        .url(websiteUrl));
        //访问地址/swagger-ui/index.html
    }
}
