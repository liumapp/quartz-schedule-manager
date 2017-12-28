package com.liumapp.schedule.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by liumapp on 12/28/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
public class ResponseMessage implements Serializable{

    protected String responseCode;
    //@JsonIgnore
    protected Object responseMessage;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public Object getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(Object responseMessage) {
        this.responseMessage = responseMessage;
    }
}