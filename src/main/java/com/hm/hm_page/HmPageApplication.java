package com.hm.hm_page;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.hm.hm_page.mapper")
@ComponentScan("com.hm")
@ServletComponentScan
@SpringBootApplication
public class HmPageApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
//        try{
            SpringApplication.run(HmPageApplication.class, args);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

    }

    @Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

}
