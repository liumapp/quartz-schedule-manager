package com.liumapp.schedule.core.worker;

import com.liumapp.DNSQueen.worker.ready.StandReadyWorker;
import com.liumapp.pattern.schedule.HelloPattern;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * say hello at specified time
 * Created by liumapp on 1/4/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class HelloWorker extends StandReadyWorker {

    @Autowired
    private Scheduler scheduler;

    @Override
    public String doWhatYouShouldDo(String whatQueenSays) {
        try {
            HelloPattern helloPattern = HelloPattern.parse(whatQueenSays);

            if (!scheduler.isStarted()) return "plz start scheduler first . ";

            

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
