package com.liumapp.schedule.core.jobs;

import com.liumapp.schedule.core.service.HelloService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
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

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String jobName = jobExecutionContext.getJobDetail().getKey().getName();
        System.out.println("jobName =" + jobName);
        Map<String, Object> parameter = jobExecutionContext.getMergedJobDataMap();
        System.out.println("Job execute result :" + helloService.sayHello(parameter));
        System.out.println(new Date() + ": doing other things..." + Thread.currentThread().getId());
    }
}
