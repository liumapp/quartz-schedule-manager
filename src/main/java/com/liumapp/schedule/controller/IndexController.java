package com.liumapp.schedule.controller;

import com.alibaba.fastjson.JSON;
import com.liumapp.schedule.response.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liumapp on 12/19/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RestController
@RequestMapping(path = "/")
public class IndexController {


    @RequestMapping(value = {"/", "/index"})
    @ResponseBody
    public String index() {

        ResponseMessage responseMessage = new ResponseMessage();
        //todo do job here,see unit test

        responseMessage.setResponseCode("SUCCESS");
        return JSON.toJSONString(responseMessage);
    }
}
