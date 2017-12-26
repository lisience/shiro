package com.shiro.controller;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by liuenxi on 2017/12/20.
 */
@Controller
public class LogoutController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/logout")
    public Object logout(HttpServletRequest request) throws OAuthProblemException, OAuthSystemException, URISyntaxException {

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(false);
        String authKey = "authCode:" + session.getId();
        Long size = redisTemplate.opsForList().size(authKey);
        List<String> authCodeList = redisTemplate.opsForList().range(authKey, 0 , size -1);

        for(String authCode : authCodeList){
            String sid = (String) redisTemplate.opsForHash().get(authCode, "sid");
            String clientUrl = (String) redisTemplate.opsForHash().get(authCode, "clientUrl");
            this.post(clientUrl, null, sid);
        }
        session.removeAttribute("user");
        subject.logout();
        return "login";
    }

    public static boolean post(String url, Map<String, String> params, String sid) {

        CookieStore cookieStore = new BasicCookieStore();
        BasicClientCookie cookie = new BasicClientCookie("sid", sid);
        cookie.setDomain(url);
        cookieStore.addCookie(cookie);
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpPost httpPost = new HttpPost(url + "/client/logout");

        httpPost.addHeader("cookie", "sid=" + sid);

        // 参数处理
        if (params != null && !params.isEmpty()) {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator<Map.Entry<String, String>> it = params.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> entry = it.next();
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(list, Consts.UTF_8));
        }
        // 执行请求
        try {
            CloseableHttpResponse response = httpclient.execute(httpPost);
            response.getStatusLine().getStatusCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


}
