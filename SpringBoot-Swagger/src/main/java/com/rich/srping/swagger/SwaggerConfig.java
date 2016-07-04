package com.rich.srping.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.rich.srping.swagger.resources.SubscriberController;

@Configuration
@EnableSwagger
public class SwaggerConfig {
    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .includePatterns("/subscriber/.*");      //Map the specific URL patterns into Swagger
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("RICH API", "API for Demo Swagger", "",
                "rich04230@gmail.com", "API Licence Type", "API License URL");
        return apiInfo;
    }
}