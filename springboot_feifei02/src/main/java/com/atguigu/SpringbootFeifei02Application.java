package com.atguigu;

import com.atguigu.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootFeifei02Application {

    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(SpringbootFeifei02Application.class, args);
        User user = (User) run.getBean("user");
        System.out.println(user);

    }

}
