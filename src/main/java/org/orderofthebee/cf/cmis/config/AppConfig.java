package org.orderofthebee.cf.cmis.config;

import org.apache.chemistry.opencmis.client.api.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ServiceScan
@ComponentScan("org.orderofthebee.cf.cmis")
public class AppConfig extends AbstractCloudConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }
    
    @Bean
    public Session session() {
        return connectionFactory().service(Session.class);
    }

}
