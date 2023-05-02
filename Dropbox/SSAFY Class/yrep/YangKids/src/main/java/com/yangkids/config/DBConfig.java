package com.yangkids.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.yangkids.model.dao")
public class DBConfig {

}
