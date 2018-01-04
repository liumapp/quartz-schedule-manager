package com.liumapp.schedule.core.worker;

import com.liumapp.DNSQueen.worker.ready.StandReadyWorker;
import org.springframework.stereotype.Component;

/**
 * say hello at specified time
 * Created by liumapp on 1/4/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class HelloWorker extends StandReadyWorker {
    @Override
    public String doWhatYouShouldDo(String s) {
        
        return null;
    }
}
