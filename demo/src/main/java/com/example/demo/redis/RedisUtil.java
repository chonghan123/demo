package com.example.demo.redis;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author hc
 * @classname RedisUtil
 * @description TODO
 * @date 2020/7/1
 */
@Component
public class RedisUtil {

    @Autowired
    public RedisTemplate<String, String> redisTemplate;

    private Logger log = LoggerFactory.getLogger(RedisUtil.class);

    /**
     * 设置redis缓存
     *
     * @param key   redis存储的key值
     * @param value redis存储的value
     */
    public void set(String key, String value) {
        if (StringUtils.isBlank(key)) {
            log.info("the key must not be empty!");
            return;
        }
        if (Objects.isNull(value)) {
            log.info("the value must not be null!");
            return;
        }
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 获取redis存储的value
     *
     * @param key redis存储的key值
     * @return value
     */
    public String get(String key) {
        if (StringUtils.isBlank(key)) {
            log.info("the key must not be empty!");
            return StringUtils.EMPTY;
        }
        return redisTemplate.opsForValue().get(key);
    }
}
