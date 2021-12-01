package com.spring.aop.service;

import org.springframework.stereotype.Service;

@Service
public class FrontendServiceImpl implements DevelopService{
    @Override
    public void develop() {
        System.out.println("call frontend develop");
    }

    public void error() throws Exception{
        System.out.println("call frontend error");
        if(1==1){
            throw new Exception();
        }
    }
}
