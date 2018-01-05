package com.liumapp.schedule.core.jobs;

import com.liumapp.schedule.core.service.HelloService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * Created by liumapp on 12/28/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class HelloJob implements Job {

    @Autowired
    HelloService helloService;

    private String Msg;

    public HelloJob() {
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey key = jobExecutionContext.getJobDetail().getKey();

        JobDataMap dataMap = jobExecutionContext.getMergedJobDataMap();

        System.out.println(" Msg is : " + this.Msg);
    }

    public void setMsg(String msg) {
        Msg = msg;
    }
}
