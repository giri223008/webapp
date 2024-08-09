package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "what are u learning today?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHTML() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<title>");
		sb.append("<head>");
		sb.append("My First HTML Page");
		sb.append("</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My First HTML with Body");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
		
		}
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJSP() {
		return "sayHello" ;
		
	}
}
