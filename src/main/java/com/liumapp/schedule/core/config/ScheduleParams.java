package com.liumapp.schedule.core.config;

import org.springframework.stereotype.Component;

/**
 * Created by liumapp on 12/19/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class ScheduleParams {

    private Integer port = 9999;

    private Integer startDelay = 3000;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getStartDelay() {
        return startDelay;
    }

    public void setStartDelay(Integer startDelay) {
        this.startDelay = startDelay;
    }
}
