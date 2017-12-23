package com.shiro.controller;

import com.shiro.constant.TempSid;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthAccessTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URI;
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
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/logout")
    public Object logout(HttpServletRequest request) throws OAuthProblemException, OAuthSystemException, URISyntaxException {


        /*OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());

        OAuthClientRequest logoutRequest = new OAuthBearerClientRequest("http://a.zuma.com:8088/client/logout").buildQueryMessage();

        OAuthResourceResponse resourceResponse = oAuthClient.resource(logoutRequest, OAuth.HttpMethod.GET, OAuthResourceResponse.class);

        //TODO 返回值 可以为用户信息 角色信息  权限信息
        String result = resourceResponse.getBody();
        System.out.println(result);*/

    this.post("http://a.zuma.com:8088/client/logout", null);

        /*OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());

        OAuthClientRequest userInfoRequest = new OAuthBearerClientRequest("http://a.zuma.com:8088/client/logout").buildQueryMessage();

        OAuthResourceResponse resourceResponse = oAuthClient.resource(userInfoRequest, OAuth.HttpMethod.GET, OAuthResourceResponse.class);

        //TODO 返回值
        String result = resourceResponse.getBody();

        System.out.println(result);*/
        /*OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());



        Subject subject = SecurityUtils.getSubject();*/
        //进行OAuth响应构建
        /*OAuthASResponse.OAuthAuthorizationResponseBuilder builder =
                OAuthASResponse.authorizationResponse(request, HttpServletResponse.SC_FOUND);
        //设置授权码
        //builder.setCode(authorizationCode);

        //构建响应
        final OAuthResponse response = builder.location("http://a.zuma.com:8088/client/logout").buildQueryMessage();

        //根据OAuthResponse返回ResponseEntity响应
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(new URI(response.getLocationUri()));
        subject.logout();

        return new ResponseEntity(headers, HttpStatus.valueOf(response.getResponseStatus()));*/


        return null;
        /*subject.logout();
//        session.removeAttribute("user");
        return "login";*/
    }

    public static boolean post(String url, Map<String, String> params) {


        CookieStore cookieStore = new BasicCookieStore();
        String tempSid = TempSid.sid;
        BasicClientCookie cookie = new BasicClientCookie("sid", tempSid);
        cookie.setDomain("a.zuma.com:8088");
        cookieStore.addCookie(cookie);
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpPost httpPost = new HttpPost(url);



        httpPost.addHeader("cookie", "sid=" + tempSid);


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
