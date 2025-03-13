package com.uae.dubai.ekconent.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHello {
    @RequestMapping("say-Hello")
    @ResponseBody
    public String sayHello() {
        return "Hello What are you learning Today";
    }

    @RequestMapping("say-Hello-Html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>");
        sb.append("Hello This is Html");
        sb.append("</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My First Html page wit BOdy"); 
        sb.append("</body>");
        sb.append("</html>");
        System.out.println("sss--" +sb.toString());
        return sb.toString();
    }

    
    //"say-Hello-jsp"  => sayHello.jsp
    @RequestMapping("say-Hello-jsp")
    public String sayHelloJsp() {
        return "SayHellotwo";
    }
}
