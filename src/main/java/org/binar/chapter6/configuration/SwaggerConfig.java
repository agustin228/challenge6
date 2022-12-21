package org.binar.chapter5.configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI demoAPI(@Value("This document lists paths (endpoints) of the Cinema API \n " +
            "and operations that you can perform by sending HTTP requests to the paths ") String appDescription,
                           @Value("v1.0.0") String appVersion){
        Server serverLocal = new Server();
        serverLocal.setUrl("http://localhost:8080/");
        List<Server> listOfServer = new ArrayList<>();
        listOfServer.add(serverLocal);


        return new OpenAPI()
                .info(new Info()
                        .title("Cinema API")
                        .description(appDescription)
                        .version(appVersion)
                        .termsOfService("http://swagger.io/terms")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .servers(listOfServer);
    }

}
