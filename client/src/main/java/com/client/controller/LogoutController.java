package com.client.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.mgt.WebSessionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liuenxi on 2017/12/20.
 */
@RestController
@RequestMapping("/client")
public class LogoutController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/logout")
    public HttpEntity logout(String testToken, HttpServletRequest request, HttpServletResponse response) throws IOException {

        Session session = (Session) redisTemplate.opsForValue().get("qqqqq");
        Session session1 = (Session) redisTemplate.opsForValue().get(session.getId());
        redisTemplate.delete("qqqqq");
        redisTemplate.delete(session1.getId());

        response.sendRedirect("http://b.zuma.com:8083/login.html");
        return new ResponseEntity("logout success", HttpStatus.OK);
    }

}
