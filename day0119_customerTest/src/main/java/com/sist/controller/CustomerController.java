package com.sist.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.CustomerDAO;
import com.sist.vo.CustomerVO;

@Controller
public class CustomerController {
	
	private CustomerDAO dao;
	
	
	public void setDao(CustomerDAO dao) {
		this.dao = dao;
	}


	@RequestMapping("/listCustomer.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		ArrayList<CustomerVO> list = dao.listAll();
		mav.addObject("list", list);
		mav.setViewName("listCustomer");
		return mav;
	}
	
	
	@RequestMapping("/detailCustomer.do")
	public ModelAndView detail(int custid) {
		ModelAndView mav = new ModelAndView();	
		mav.addObject("c", dao.getCustomer(custid));	
		//��û�� �����̸��� ���� view�� �����Ҷ����� 
		//setViewName�� ������ �� �ֽ��ϴ�.
		return mav;
	}
	
}


















