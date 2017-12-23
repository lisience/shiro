package com.shiro.controller;

import com.shiro.service.ZmSitePageLogService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuenxi on 2017/12/12.
 */
@RestController
@RequestMapping("/shiro")
public class FirstShiroController {

    @Autowired
    private ZmSitePageLogService pageLogService;

    @RequestMapping("/shiroInfo")
    public String getShiroInfo(){
        System.out.println("shiroInfo");
        RandomStringUtils.random(20, true, true);
        return "success";
    }

}
