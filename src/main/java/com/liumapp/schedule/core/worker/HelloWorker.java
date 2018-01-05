package com.liumapp.schedule.core.worker;

import com.liumapp.DNSQueen.worker.ready.StandReadyWorker;
import com.liumapp.pattern.Pattern;
import com.liumapp.pattern.schedule.HelloPattern;
import com.liumapp.schedule.core.worker.rule.SetSchedule;
import com.liumapp.schedule.core.worker.tool.WorkerTool;
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
public class HelloWorker extends StandReadyWorker implements SetSchedule {

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private WorkerTool workerTool;

    @Override
    public String doWhatYouShouldDo(String whatQueenSays) {
        try {
            HelloPattern helloPattern = HelloPattern.parse(whatQueenSays);
            WorkerTool workerTool = new WorkerTool();

            if (!scheduler.isStarted()) return " plz start scheduler first . ";

            helloPattern.setGroup(workerTool.generateGroup());
            helloPattern.setName(workerTool.generateName());
            makeParams(helloPattern);


            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public <T extends Pattern> void makeParams(T pattern) {
        HelloPattern helloPattern = (HelloPattern) pattern;
        helloPattern.setGroup(workerTool.generateGroup());
        helloPattern.setName(workerTool.generateName());
    }

    @Override
    public <T extends Pattern> void makeJob(T pattern) {
        
    }

    @Override
    public <T extends Pattern> void makeTrigger(T pattern) {

    }

    @Override
    public <T extends Pattern> void putSchedule(T pattern) {

    }
}
