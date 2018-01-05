package com.liumapp.schedule.core.worker.tool;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by liumapp on 1/5/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class WorkerTool {

    @Autowired
    private Scheduler scheduler;

    public String generateName () {

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Integer randomNum = new Random().nextInt(8999) + 1000;
        String name = randomNum + "_" + simpleDateFormat.format(date) ;
        return name;

    }

    public String generateGroup () {

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String group = simpleDateFormat.format(date);
        return group;
    }

}
