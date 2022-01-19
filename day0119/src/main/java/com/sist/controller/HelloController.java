package com.sist.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		System.out.println("컨트롤러 동작함.");
		ModelAndView mav= new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("msg", "hello spring!!");
		ArrayList<String> list= new ArrayList<String>();
		list.add("사과");
		list.add("포도");
		list.add("수박");
		mav.addObject("list",list);
		return mav;
	}
}
