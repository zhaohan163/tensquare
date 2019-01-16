package com.tensqare.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @ClassName BaseApplication
 * @Author 123456
 * @Description TODO
 * @Version 1.0
 * @Date 2019/1/15 16:08
 **/
@SpringBootApplication
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new util.IdWorker(1,1);
    }
}
