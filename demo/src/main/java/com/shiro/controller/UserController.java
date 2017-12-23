package com.shiro.controller;

import com.shiro.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by liuenxi on 2017/12/19.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    //服务端登录
    @RequestMapping("/login")
    public HttpEntity login(@Valid User user, HttpServletRequest request, HttpServletResponse response){

        if("get".equalsIgnoreCase(request.getMethod())) {
            return null;
        }
        String username = request.getParameter("fUserName");
        String password = request.getParameter("fPassWord");

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (Exception e) {
            request.setAttribute("error", "登录失败:" + e.getClass().getName());
        }
        return new ResponseEntity("success", HttpStatus.OK);
    }
}
