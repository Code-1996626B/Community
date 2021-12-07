package com.newcoder.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CommunityApplication {

    @PostConstruct
    public void init() {
        // 解决netty启动冲突的问题
        // see Netty4Utils.setAvailableProcessors
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }

    // 启动的时候会生成IOC容器，IOC容器会自动扫描这个类所在包和子包下面注解了Controller(处理请求),Service(业务),Repository(数据库访问)等的类
    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
    }

}
