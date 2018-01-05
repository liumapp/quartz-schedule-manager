package com.liumapp.schedule.core.worker.rule;

import com.liumapp.pattern.Pattern;
import com.liumapp.pattern.schedule.HelloPattern;

/**
 * Created by liumapp on 1/5/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public interface SetSchedule {

    public <T extends Pattern> void makeParams (T pattern) ;

    public <T extends Pattern> void makeJob (T pattern) ;

    public <T extends Pattern> void makeTrigger (T pattern) ;

    public <T extends Pattern> void putSchedule (T pattern) ;


}
