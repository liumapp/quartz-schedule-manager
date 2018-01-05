package com.liumapp.schedule.core.worker;

import com.liumapp.DNSQueen.worker.ready.StandReadyWorker;
import com.liumapp.pattern.schedule.core.SwitchPattern;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by liumapp on 1/5/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class SwitchWorker extends StandReadyWorker {

    @Autowired
    private Scheduler scheduler;

    @Override
    public String doWhatYouShouldDo(String s) {
        try {
            SwitchPattern switchPattern = SwitchPattern.parse(s);
            switch (switchPattern.getOrder()) {
                case CLOSED:
                    return closed();
                case RESTART:
                    return restart();
                case START:
                    return start();
                default:
                    return "wrong order type";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String start () throws SchedulerException {
        if (!scheduler.isStarted()) {
            scheduler.start();
            return "start success";
        } else {
            return "already started ...";
        }

    }

    private String closed () throws SchedulerException {
        if(!scheduler.isShutdown()) {
            scheduler.shutdown();
            return "shutdown success";
        } else {
            return "already closed ...";
        }
    }

    private String restart () throws SchedulerException {
        if (!scheduler.isStarted()) {
            scheduler.start();
        } else {
            scheduler.shutdown();
            scheduler.start();
        }
        return "restart success";
    }

}
