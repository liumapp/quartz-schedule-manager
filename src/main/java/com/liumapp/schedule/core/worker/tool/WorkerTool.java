package com.liumapp.schedule.core.worker.tool;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by liumapp on 1/5/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class WorkerTool {

    @Autowired
    private Scheduler scheduler;

}
