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

    public Pattern makeParams (T pattern) ;

    public JobDetail makeJob (T pattern) ;

    public SimpleTrigger makeTrigger (T pattern) ;

    public void putSchedule ( J job , G trigger ) throws SchedulerException;

}
