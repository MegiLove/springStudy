package com.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.CustomerDAO;
import com.sist.vo.CustomerVO;

@Controller
@RequestMapping("/insertCustomer.do")
public class InsertCustomerController {
	
	private CustomerDAO dao;
	
	
	public void setDao(CustomerDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void form() {		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(CustomerVO c) {	
		ModelAndView mav = new ModelAndView();
		int re = dao.insertCustomer(c);
		if(re == 1) {
			mav.setViewName("insertCustomerOK");
		}else {
			mav.addObject("msg", "고객등록에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
}







