package com.liumapp.schedule.core.service.impl;

import com.liumapp.schedule.core.service.HelloService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by liumapp on 1/4/18.
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
