package com.spring.aop.service;

import com.spring.aop.config.CustomLog;
import org.springframework.stereotype.Service;

@Service
public class BackendServiceImpl implements DevelopService{
    @Override
    public void develop() {
        System.out.println("call backend develop");
    }

    @CustomLog
    public void study(){
        System.out.println("call backend study");
    }

    public String rest(){
        System.out.println("call backend rest");

        return "good";
    }
}
