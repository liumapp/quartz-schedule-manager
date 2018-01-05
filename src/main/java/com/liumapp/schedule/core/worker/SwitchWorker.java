package com.liumapp.schedule.core.worker;

import com.liumapp.DNSQueen.worker.ready.StandReadyWorker;
import com.liumapp.pattern.exception.PatternPropertiesNumberNotEnough;
import com.liumapp.pattern.exception.WrongType;
import com.liumapp.pattern.schedule.HelloPattern;
import com.liumapp.pattern.schedule.core.SwitchPattern;
import org.springframework.stereotype.Component;

/**
 * Created by liumapp on 1/5/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class SwitchWorker extends StandReadyWorker{

    @Override
    public String doWhatYouShouldDo(String s) {
        try {
            SwitchPattern switchPattern = SwitchPattern.parse(s);
            switch (switchPattern.getOrder()) {
                case CLOSED:
                    break;
                case RESTART:
                    break;
                case START:

                    break;
                default:
            }
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private void start () {
        
    }

}
