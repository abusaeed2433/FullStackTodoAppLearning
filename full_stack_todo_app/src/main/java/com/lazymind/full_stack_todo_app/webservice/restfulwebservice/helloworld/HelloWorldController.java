package com.lazymind.full_stack_todo_app.webservice.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/basic-auth")
    public String basicAuthCheck(){
        return "Success";
    }

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello world";
    }

    @GetMapping(path = "/hello-world/{username}")
    public HelloWorldBean helloWorldBean(@PathVariable(value = "username") String name){
        return new HelloWorldBean(name);
    }

}
