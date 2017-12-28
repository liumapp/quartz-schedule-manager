package com.liumapp.schedule.controller;

import com.liumapp.schedule.config.QuartzManager;
import com.liumapp.schedule.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liumapp on 12/19/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Controller
@RequestMapping(path = "/")
public class IndexController {

    @Autowired
    QuartzManager quartzManager;

    @RequestMapping(value = {"/", "/index"})
    @ResponseBody
    public ResponseMessage index() {

        ResponseMessage responseMessage = new ResponseMessage();
        //todo do job here,see unit test

        responseMessage.setResponseCode("SUCCESS");
        return responseMessage;
    }
}
