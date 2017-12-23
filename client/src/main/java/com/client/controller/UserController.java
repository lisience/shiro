package com.client.controller;

import com.client.entity.User;
import com.client.service.UserService;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by liuenxi on 2017/12/15.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/getUser")
    public ResponseEntity<User> findByUserName(String userName, HttpServletRequest request) throws OAuthProblemException, OAuthSystemException {

/*        stringRedisTemplate.opsForValue().set("zhangsan", "张三");*/

        /*OAuthTokenRequest oauthRequest = new OAuthTokenRequest(request);

        oauthRequest.getClientId();*/
        //OAuthTokenRequest oauthRequest = new OAuthTokenRequest(request);
        User user = userService.findUserByUserName(userName);
        return new ResponseEntity(user, HttpStatus.OK);
    }


    @RequestMapping("/login")
    public String login(@Valid User user){
        String username = user.getfUserName();
        return username;
     }
}
