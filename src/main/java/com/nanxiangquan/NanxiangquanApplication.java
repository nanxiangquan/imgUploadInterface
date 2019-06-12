package com.nanxiangquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication   //- springboot项目,并配置扫描路径
@EnableAutoConfiguration //- springboot自动配置，这个注解可以根据你依赖的包自动生成相关配置
public class NanxiangquanApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(NanxiangquanApplication.class, args);
	}

	/**
	 * 需要把web项目打成war包部署到外部tomcat运行时需要改变启动方式
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(NanxiangquanApplication.class);
	}
}
