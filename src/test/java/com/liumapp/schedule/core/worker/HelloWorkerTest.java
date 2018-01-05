package com.liumapp.schedule.core.worker;

import com.liumapp.DNSQueen.queen.Queen;
import com.liumapp.pattern.schedule.HelloPattern;
import com.liumapp.pattern.schedule.core.SwitchPattern;
import com.liumapp.schedule.core.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * Created by liumapp on 1/5/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class HelloWorkerTest {

    @Test
    public void start () throws IOException {
        Queen queen = new Queen();
        queen.setPort(40218);
        queen.connect();
        SwitchPattern switchPattern = new SwitchPattern();
        switchPattern.setImportant(SwitchPattern.OrderType.START);
        if (switchPattern.chk()) {
            queen.say(switchPattern.getEncoding());
            System.out.println(queen.hear());
        }
    }

    @Test
    public void sayHello () throws IOException {
        Queen queen = new Queen();
        queen.setPort(40218);
        queen.connect();
        HelloPattern helloPattern = new HelloPattern();
        helloPattern.setImportant("hello liumapp" , 30 , HelloPattern.IntervalUnit.SECOND);
        if (helloPattern.chk()) {
            queen.say(helloPattern.getEncoding());
            System.out.println(queen.hear());
        }
    }

}
