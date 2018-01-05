package com.liumapp.schedule.core.worker.rule;

import com.liumapp.pattern.Pattern;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;

/**
 * Created by liumapp on 1/5/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public interface SetSimpleSchedule<T extends Pattern , J extends JobDetail , G extends SimpleTrigger> {

    /**
     * make name and group name for job and trigger
     * @param pattern your socket pattern
     * @return Pattern
     */
    public Pattern makeParams (T pattern) ;

    /**
     * make your job
     * @param pattern your socket pattern
     * @return JobDetail
     */
    public JobDetail makeJob (T pattern) ;

    /**
     * make your trigger
     * @param pattern your socket pattern
     * @return SimpleTrigger
     */
    public SimpleTrigger makeTrigger (T pattern) ;

    /**
     * make your job and trigger together
     * @param job your job
     * @param trigger your trigger
     * @throws SchedulerException something error?
     */
    public void putSchedule ( J job , G trigger ) throws SchedulerException;

}
