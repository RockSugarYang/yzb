package com.yzb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.yzb", "com.alibaba.cola" })
@MapperScan("com.yzb.gatewayimpl.database")
public class YzbApplication {

    public static void main(String[] args) {
        SpringApplication.run(YzbApplication.class, args);
    }

}
