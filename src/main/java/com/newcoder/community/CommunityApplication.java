package com.newcoder.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommunityApplication {

	// 启动的时候会生成IOC容器，IOC容器会自动扫描这个类所在包和子包下面注解了Controller(处理请求),Service(业务),Repository(数据库访问)等的类
	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
	}

}
