package com.liumapp.schedule;

import com.liumapp.schedule.config.QuartzManager;
import com.liumapp.schedule.jobs.HelloJob;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liumapp on 12/27/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class})
public class MainTest {

    public static String JOB_NAME = "myJob";
    public static String JOB_GROUP_NAME = "group_myJob";
    public static String TRIGGER_NAME = "myJob";
    public static String TRIGGER_GROUP_NAME = "group_myJob";

    @Autowired
    QuartzManager quartzManager;

    @Test
//    @Ignore
    public void formatDate(){
        SimpleDateFormat cron=new SimpleDateFormat("ss mm HH dd MM ? yyyy");
        System.out.println(cron.format(new Date()));
    }

    @Test
//    @Ignore
    public void testQuartz() {
        try {
            System.out.println("【系统启动】开始(每1秒输出一次)...");
            Map<String, Object> parameterData = new HashMap<>();
            parameterData.put("parameter1", "111");
            parameterData.put("parameter2", "定时发送");
            quartzManager.addJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, HelloJob.class, "0 58 13 17 7 ? 2017", parameterData);

            while (quartzManager.countJobs() > 0) {

                Thread.sleep(1000);
            }
            /*Thread.sleep(5000);
            System.out.println("【修改时间】开始(每5秒输出一次)...");
            quartzManager.modifyJobTime(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, "0/5 * * * * ?");*/


            //Thread.sleep(600000);
            // System.out.println("【移除定时】开始...");
            //quartzManager.removeJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME);
            //System.out.println("【移除定时】成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
