package com.spring.aop.controller;

import com.spring.aop.service.BackendServiceImpl;
import com.spring.aop.service.FrontendServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AopController {

    private final BackendServiceImpl backendService;
    private final FrontendServiceImpl frontendService;

    @GetMapping("/around/class")
    public void aroundClass(){
        backendService.develop();
        frontendService.develop();
    }

    @GetMapping("/throw/bean")
    public void throwBean() throws Exception{
        frontendService.error();
    }

    @GetMapping("/return/bean")
    public void returnBean() throws Exception{
        backendService.rest();
    }

    @GetMapping("/before/annotation")
    public void beforeAnnotation(){
        backendService.study();
    }
}
