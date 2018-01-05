package com.liumapp.schedule.core.config;

import com.liumapp.DNSQueen.worker.process.WokerEar;
import com.liumapp.DNSQueen.worker.tcp.TCPSocketMonitor;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
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
    @ConfigurationProperties(prefix = "liumapp.schedule.core")
    public ScheduleParams scheduleParams () {
        return new ScheduleParams();
    }

    @Bean
    public TCPSocketMonitor tcpSocketMonitor (ScheduleParams scheduleParams) {
        Integer port = scheduleParams.getPort();
        TCPSocketMonitor tcpSocketMonitor = new TCPSocketMonitor(port);
        return tcpSocketMonitor;
    }

    @Bean
    public WokerEar wokerEar (ScheduleParams scheduleParams) {
        Integer startDelay = scheduleParams.getStartDelay();
        WokerEar wokerEar = new WokerEar();
        wokerEar.setStartDelay(startDelay);
        return wokerEar;
    }

    @Bean
    public Scheduler scheduler () throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        return scheduler;
    }

}
