package com.dinobotica.portafolio.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dinobotica.portafolio.model.DataBaseConnection;

@Configuration
@ComponentScan(basePackages = {"com.dinobotica.portafolio","com.dinobotica.portafolio.configuration","com.dinobotica.portafolio.model"})
public class ConfigurationBean {
 
    @Bean
    public DataBaseConnection dataBaseConnection()
    {
        return new DataBaseConnection();
    }
}
