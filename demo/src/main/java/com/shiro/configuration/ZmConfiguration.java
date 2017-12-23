package com.shiro.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liuenxi on 2017/12/12.
 */
@Configuration
@MapperScan("com.shiro.dao")
public class ZmConfiguration {


}
