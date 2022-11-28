package com.mobigen.sample;

import com.mobigen.framework.security.CustomHttpSessionListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@EnableCaching
@EnableAsync
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com"})
@ServletComponentScan
@SpringBootApplication
//public class SampleApplication {
public class SampleApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

    // Springboot를 war로 띄워야 하는 경우 필요함
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SampleApplication.class);
    }

    @Bean
    public CustomHttpSessionListener customHttpSessionListener() {
        return new CustomHttpSessionListener();
    }

    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new HttpSessionSecurityContextRepository();
    }
}
