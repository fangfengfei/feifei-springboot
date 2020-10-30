package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feifei")
public class FirstController {
    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private String age;

    @Value("${user.username}")
    private String username;


    @RequestMapping("/nb")
    public String saySomething(){
        return "name:"+name + ",age:"+age +",username:" + username;
    }

    @RequestMapping("/nba")
    public String sayHello(){
        return "hello mother fuck";
    }

}
