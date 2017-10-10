package com.zzm.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class HelloController {
    /**
     * 测试hello
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", "Zzm");
        model.addAttribute("age", "25");
        model.addAttribute("nickName", "Zzm8421");
        return "hello";
    }
    
    @RequestMapping(value = "/test")
    public String error() throws Exception{	
    	throw new Exception("发生错误");
    }
}
