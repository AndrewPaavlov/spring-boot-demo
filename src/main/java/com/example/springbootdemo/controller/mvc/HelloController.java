package com.example.springbootdemo.controller.mvc;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.Date;

@Controller
public class HelloController {

    @GetMapping("/hello-index")
    public String hello(Model model){
        String serverTime = new Date().toString();
        model.addAttribute("msg" , serverTime);

        return "index";
    }

    @GetMapping("/test-me")
    public void testOld(HttpServletResponse response) throws IOException {
        response.getWriter().println("Hi from Old stuff");
    }
}
