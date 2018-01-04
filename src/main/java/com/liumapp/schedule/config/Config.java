package com.liumapp.schedule.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by liumapp on 9/28/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Configuration
@EnableScheduling
public class Config {


    @Bean
    @ConfigurationProperties(prefix = "liumapp.schedule")
    public ScheduleParams coreParams(){
        ScheduleParams scheduleParams = new ScheduleParams();
        return scheduleParams;
    }

}
