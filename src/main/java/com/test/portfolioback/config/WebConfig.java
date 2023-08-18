package com.test.portfolioback.config;

import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.VersionResourceResolver;

/**
 *
 * @author Robson J Silva <vantrox@yahoo.com.br>
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**","/plugins/**", "/css/**", "/image/**")
                    .addResourceLocations("classpath:/static/js/", "classpath:/static/plugins/", "classpath:/static/css/", "classpath:/static/image/")
                    .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS))
                    .resourceChain(true)
                    .addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
        WebMvcConfigurer.super.addResourceHandlers(registry); 
    }
    
}
