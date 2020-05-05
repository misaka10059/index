package com.mn.index.configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger
public class SwaggerConfiguration {
    @Autowired
    private SpringSwaggerConfig springSwaggerConfig;


    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo()).includePatterns("/*/.*").build();
    }


    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("index", "Test Page",
                "", "", "", "");
        return apiInfo;
    }
}
