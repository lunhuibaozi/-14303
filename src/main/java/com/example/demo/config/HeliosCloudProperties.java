/*
 * Copyright (c) 2017. Shanghai Zhenhui Information Technology Co,. ltd.
 * All rights are reserved.
 */

package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * Created by markfredchen on 20/04/2017.
 */
@Validated
@ConfigurationProperties(prefix = "helios", ignoreUnknownFields = false, exceptionIfInvalid = false)
public class HeliosCloudProperties {
    private final HeliosCloudProperties.Datasource datasource = new HeliosCloudProperties.Datasource();
    private final HeliosCloudProperties.Mail mail = new HeliosCloudProperties.Mail();
    private final HeliosCloudProperties.Cache cache = new HeliosCloudProperties.Cache();

    public Datasource getDatasource() {
        return datasource;
    }

    public Mail getMail() {
        return mail;
    }

    public Cache getCache() {
        return this.cache;
    }


    public static class Datasource {
        private String dbType = "mysql";
        /**
         * 最大并发连接数, 默认值8
         */
        private int maxActive = 8;
        /**
         * 初始化连接数, 默认值0
         */
        private int initialSize = 0;
        /**
         * 获取连接等待超时时间, 默认值无限制
         */
        private int maxWait = -1;
        /**
         * 最小空闲连接数, 默认值0
         */
        private int minIdle = 0;

        /**
         * 检测关闭空闲连接时间间隔, 单位毫秒, 默认值60秒
         */
        private long timeBetweenEvictionRunsMills = 60 * 1000L;

        public String getDbType() {
            return dbType;
        }

        public void setDbType(String dbType) {
            this.dbType = dbType;
        }

        public int getMaxActive() {
            return maxActive;
        }

        public void setMaxActive(int maxActive) {
            this.maxActive = maxActive;
        }

        public int getInitialSize() {
            return initialSize;
        }

        public void setInitialSize(int initialSize) {
            this.initialSize = initialSize;
        }

        public int getMaxWait() {
            return maxWait;
        }

        public void setMaxWait(int maxWait) {
            this.maxWait = maxWait;
        }

        public int getMinIdle() {
            return minIdle;
        }

        public void setMinIdle(int minIdle) {
            this.minIdle = minIdle;
        }

        public long getTimeBetweenEvictionRunsMills() {
            return timeBetweenEvictionRunsMills;
        }

        public void setTimeBetweenEvictionRunsMills(long timeBetweenEvictionRunsMills) {
            this.timeBetweenEvictionRunsMills = timeBetweenEvictionRunsMills;
        }
    }

    public static class Mail {

        private String mock;

        public String getMock() {
            return mock;
        }

        public void setMock(String mock) {
            this.mock = mock;
        }

    }

    public static class Cache {
        private long expireTime = 1800;

        public long getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(long expireTime) {
            this.expireTime = expireTime;
        }
    }
}
