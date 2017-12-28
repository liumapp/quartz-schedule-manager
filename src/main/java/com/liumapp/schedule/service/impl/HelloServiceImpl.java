package com.liumapp.schedule.service.impl;

import com.liumapp.schedule.service.HelloService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by liumapp on 12/28/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(Map<String, Object> parameter) {
        parameter.forEach((k, v) -> {
            System.out.println("k = " + k + ",v = " + v);
        });
        return "SUCCESS ";
    }

}
