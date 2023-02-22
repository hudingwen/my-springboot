package com.hudingwen.springboot.config;

import com.hudingwen.springboot.Interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName:SpringMvcConfig
 * Package:com.hudingwen.springboot.config
 * Description:描述
 * Date:2022-10-22 11:34:32
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Autowired
    ProjectInterceptor projectInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:swagger-ui/index.html");
        registry.addViewController("/index.css").setViewName("forward:swagger-ui/index.css");
        registry.addViewController("/swagger-ui-standalone-preset.js").setViewName("forward:swagger-ui/swagger-ui-standalone-preset.js");
        registry.addViewController("/swagger-initializer.js").setViewName("forward:swagger-ui/swagger-initializer.js");
        registry.addViewController("/swagger-ui.css").setViewName("forward:swagger-ui/swagger-ui.css");
        registry.addViewController("/swagger-ui-bundle.js").setViewName("forward:swagger-ui/swagger-ui-bundle.js");
    }
}
