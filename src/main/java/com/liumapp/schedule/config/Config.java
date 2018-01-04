package com.liumapp.schedule.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by liumapp on 9/28/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Configuration
@EnableScheduling
public class Config {

//    @Autowired
//    private QuartzJobFactory quartzJobFactory;

    @Bean
    @ConfigurationProperties(prefix = "liumapp.schedule")
    public ScheduleParams coreParams(){
        ScheduleParams scheduleParams = new ScheduleParams();
        return scheduleParams;
    }

    @Bean
    public QuartzJobFactory quartzJobFactory() {
        QuartzJobFactory quartzJobFactory = new QuartzJobFactory();
        return quartzJobFactory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(QuartzJobFactory quartzJobFactory) throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();

        factory.setOverwriteExistingJobs(true);

        // 延时启动
        factory.setStartupDelay(20);

        // 加载quartz数据源配置
        factory.setQuartzProperties(quartzProperties());

        // 自定义Job Factory，用于Spring注入
        factory.setJobFactory(quartzJobFactory);

        return factory;
    }

    /**
     * 加载quartz数据源配置
     */
    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

}
