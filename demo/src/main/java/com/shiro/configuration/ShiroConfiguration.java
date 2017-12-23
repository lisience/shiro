package com.shiro.configuration;

import com.shiro.dao.RedisSessionDao;
import com.shiro.realm.AuthRealm;
import com.shiro.credentials.CredentialsMatcher;
import com.shiro.filter.TestFilter;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.session.mgt.ExecutorServiceSessionValidationScheduler;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.SessionValidationScheduler;
import org.apache.shiro.session.mgt.ValidatingSessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.session.mgt.quartz.QuartzSessionValidationScheduler;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by liuenxi on 2017/12/12.
 */
@Configuration
@EnableCaching
public class ShiroConfiguration {
    @Bean(name="shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);


        /*Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("logout", logoutFilter);
        bean.setFilters(filterMap);*/

        //配置登录的url和登录成功的url
        bean.setLoginUrl("/login.html");
        bean.setSuccessUrl("/");
        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
        filterChainDefinitionMap.put("/*.html", "anon");
        filterChainDefinitionMap.put("/jsp/login.jsp*", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/user/test", "authc"); //表示可以匿名访问
        filterChainDefinitionMap.put("/user/*", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/user/login", "authc");
        filterChainDefinitionMap.put("/test/login", "anon");
        filterChainDefinitionMap.put("/logout","anon");
        filterChainDefinitionMap.put("/jsp/error.jsp*","anon");
        filterChainDefinitionMap.put("/jsp/index.jsp*","authc");
        filterChainDefinitionMap.put("/*", "authc");//表示需要认证才可以访问
        filterChainDefinitionMap.put("/**", "authc");//表示需要认证才可以访问
        filterChainDefinitionMap.put("/*.*", "authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

    /*@Bean("logoutFilter")
    public LogoutFilter logoutFilter(){
        LogoutFilter logoutFilter = new LogoutFilter();
        logoutFilter.setRedirectUrl("/login.html");
        return logoutFilter;
    }*/



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
        SimpleCookie cookie = new SimpleCookie("mldn-session-id");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(-1);
        return cookie;
    }

    @Bean(name = "sessionValidationScheduler")
    public SessionValidationScheduler sessionValidationScheduler(){
        ExecutorServiceSessionValidationScheduler validationScheduler = new ExecutorServiceSessionValidationScheduler();
        //validationScheduler.setSessionValidationInterval(3600000L);
        validationScheduler.setInterval(3600000L);
        //validationScheduler.setSessionManager(sessionManager);

        return validationScheduler;
    }

    @Bean(name = "redisSessionDao")
    public SessionDAO sessionDAO(){
        return new RedisSessionDao();
    }


    @Bean(name = "sessionManager")
    public ValidatingSessionManager sessionManager(@Qualifier("sessionValidationScheduler") SessionValidationScheduler validationScheduler, @Qualifier("redisSessionDao") SessionDAO sessionDAO, @Qualifier("sessionIdCookie") Cookie sessionIdCookie){
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

    //配置核心安全事务管理器
    @Bean(name="securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm, @Qualifier("sessionManager") ValidatingSessionManager sessionManager) {
        System.err.println("--------------shiro已经加载----------------");
        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(authRealm);
        manager.setSessionManager(sessionManager);
        return manager;
    }
    //配置自定义的权限登录器
    @Bean(name="authRealm")
    public AuthRealm authRealm(@Qualifier("credentialsMatcher") CredentialsMatcher matcher) {
        AuthRealm authRealm=new AuthRealm();
        authRealm.setCredentialsMatcher(matcher);
        return authRealm;
    }


    @Bean(name="rememberMeCookie")
    public Cookie rememberMeCookie(){
        Cookie cookie = new SimpleCookie();
        return cookie;
    }

    @Bean
    public RememberMeManager rememberMeManager(@Qualifier("rememberMeCookie") Cookie cookie){
        CookieRememberMeManager manager = new CookieRememberMeManager();
        manager.setCookie(cookie);
        return manager;
    }


    //配置自定义的密码比较器
    @Bean(name="credentialsMatcher")
    public CredentialsMatcher credentialsMatcher() {
        CredentialsMatcher credentialsMatcher = new CredentialsMatcher();
        return credentialsMatcher;
    }
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator=new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public PasswordService passwordService(){
        return new DefaultPasswordService();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }

}