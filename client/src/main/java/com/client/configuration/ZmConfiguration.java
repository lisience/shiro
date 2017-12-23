package com.client.configuration;

import com.client.dao.RedisSessionDao;
import com.client.filter.OAuth2AuthenticationFilter;
import com.client.realm.OAuth2Realm;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.ExecutorServiceSessionValidationScheduler;
import org.apache.shiro.session.mgt.SessionValidationScheduler;
import org.apache.shiro.session.mgt.ValidatingSessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by liuenxi on 2017/12/12.
 */
@Configuration
@MapperScan("com.client.dao")
public class ZmConfiguration {

    @Bean(name="shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager, @Qualifier("oAuth2AuthenticationFilter") OAuth2AuthenticationFilter oAuth2AuthenticationFilter) {
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);
        //配置登录的url和登录成功的url
        bean.setLoginUrl("http://b.zuma.com:8083/user/authorize?client_id=c1ebe466-1cdc-4bd3-ab69-77c3561b9dee&response_type=code&redirect_uri=http://a.zuma.com:8088/oauth2-login");
        bean.setSuccessUrl("/");
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("oauth2Authc", oAuth2AuthenticationFilter);
        bean.setFilters(filterMap);
        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/index.html", "anon");
        filterChainDefinitionMap.put("/client/logout", "oauth2Authc");
        filterChainDefinitionMap.put("/oauth2Failure.html", "anon");
        //filterChainDefinitionMap.put("/user/*", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/client/*", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/oauth2-login", "oauth2Authc");
        filterChainDefinitionMap.put("/*", "user");//表示需要认证才可以访问
        filterChainDefinitionMap.put("/**", "user");//表示需要认证才可以访问
        filterChainDefinitionMap.put("/*.*", "user");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }


    @Bean(name = "oAuth2AuthenticationFilter")
    public OAuth2AuthenticationFilter oAuth2AuthenticationFilter(){
        OAuth2AuthenticationFilter filter = new OAuth2AuthenticationFilter();
        filter.setAuthcCodeParam("code");
        filter.setFailureUrl("/oauth2Failure.html");
        return filter;
    }

    @Bean(name = "sessionIdGenerator")
    public SessionIdGenerator sessionIdGenerator(){
        return new JavaUuidSessionIdGenerator();
    }

    /*@Bean(name = "sessionDao")
    public SessionDAO sessionDAO(@Qualifier("sessionIdGenerator") SessionIdGenerator sessionIdGenerator){
        EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
        sessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
        sessionDAO.setSessionIdGenerator(sessionIdGenerator);
        return sessionDAO;
    }*/

    @Bean(name = "sessionIdCookie")
    public Cookie cookie(){
        SimpleCookie cookie = new SimpleCookie("sid");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(-1);
        return cookie;
    }

    @Bean(name = "sessionValidationScheduler")
    public SessionValidationScheduler sessionValidationScheduler(){
        //QuartzSessionValidationScheduler validationScheduler = new QuartzSessionValidationScheduler();
        //validationScheduler.setSessionValidationInterval(3600000L);
        ExecutorServiceSessionValidationScheduler validationScheduler = new ExecutorServiceSessionValidationScheduler();
        validationScheduler.setInterval(3600000L);
        //validationScheduler.setSessionManager(sessionManager);
        return validationScheduler;
    }
    @Bean(name = "redisSessionDao")
    public SessionDAO sessionDAO(){
        return new RedisSessionDao();
    }

    @Bean(name = "sessionManager")
    public DefaultWebSessionManager sessionManager(@Qualifier("sessionValidationScheduler") SessionValidationScheduler validationScheduler, @Qualifier("redisSessionDao") SessionDAO sessionDAO, @Qualifier("sessionIdCookie") Cookie sessionIdCookie){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(3600000L);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationScheduler(validationScheduler);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionDAO(sessionDAO);
        sessionManager.setSessionIdCookie(sessionIdCookie);
        sessionManager.setSessionIdCookieEnabled(true);

        return  sessionManager;
    }

    @Bean(name = "cacheManager")
    public CacheManager cacheManager(){
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache/ehcache.xml");
        return cacheManager;
    }

    @Bean(name="securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") OAuth2Realm authRealm, @Qualifier("sessionManager") ValidatingSessionManager sessionManager, @Qualifier("cacheManager") CacheManager cacheManager) {
        System.err.println("--------------shiro已经加载----------------");
        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(authRealm);
        manager.setSessionManager(sessionManager);
        manager.setCacheManager(cacheManager);
        return manager;
    }

    //配置自定义的权限登录器
    @Bean(name="authRealm")
    public OAuth2Realm authRealm() {
        OAuth2Realm authRealm = new OAuth2Realm();
        authRealm.setClientId("c1ebe466-1cdc-4bd3-ab69-77c3561b9dee");
        authRealm.setClientSecret("d8346ea2-6017-43ed-ad68-19c0f971738b");
        authRealm.setAccessTokenUrl("http://b.zuma.com:8083/user/accessToken");
        authRealm.setRedirectUrl("http://a.zuma.com:8088/oauth2-login");
        authRealm.setUserInfoUrl("http://b.zuma.com:8083/user/userInfo");

        authRealm.setCachingEnabled(true);
        authRealm.setAuthenticationCachingEnabled(true);
        authRealm.setAuthenticationCacheName("authenticationCache");
        authRealm.setAuthorizationCachingEnabled(true);
        authRealm.setAuthorizationCacheName("authorizationCache");

        return authRealm;
    }


    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }


}
