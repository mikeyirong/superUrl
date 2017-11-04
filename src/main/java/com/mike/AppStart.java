package com.mike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动入口
 * @author mike_yi
 * @since 2017-11-2
 * @version 1.0
 */
@EnableAutoConfiguration
@SpringBootApplication
public class AppStart {
    public static void main( String[] args ){
       SpringApplication.run(AppStart.class, args);
    }
}
