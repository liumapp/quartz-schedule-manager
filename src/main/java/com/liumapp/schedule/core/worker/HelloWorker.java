package com.liumapp.schedule.core.worker;

import com.liumapp.DNSQueen.worker.ready.StandReadyWorker;
import com.liumapp.pattern.Pattern;
import com.liumapp.pattern.schedule.HelloPattern;
import com.liumapp.schedule.core.worker.rule.SetSimpleSchedule;
import com.liumapp.schedule.core.worker.tool.WorkerTool;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * say hello at specified time
 * Created by liumapp on 1/4/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class HelloWorker extends StandReadyWorker implements SetSimpleSchedule {

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

            helloPattern = (HelloPattern) makeParams(helloPattern);
            JobDetail job = makeJob(helloPattern);
            SimpleTrigger trigger = makeTrigger(helloPattern);
            putSchedule(helloPattern , job , trigger);

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public Pattern makeParams(Pattern pattern) {
        HelloPattern helloPattern = (HelloPattern) pattern;
        helloPattern.setGroup(workerTool.generateGroup());
        helloPattern.setName(workerTool.generateName());
        return helloPattern;
    }

    @Override
    public JobDetail makeJob(Pattern pattern) {
        return null;
    }

    @Override
    public SimpleTrigger makeTrigger(Pattern pattern) {
        return null;
    }

    @Override
    public void putSchedule(Pattern pattern, JobDetail job, SimpleTrigger trigger) {

    }

}
