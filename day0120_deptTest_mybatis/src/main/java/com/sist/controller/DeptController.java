package com.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.DeptDao;
import com.sist.vo.DeptVO;

@Controller
public class DeptController {
	
	@Autowired
	private DeptDao dao;

	public void setDao(DeptDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listDept.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll());
		return mav;
	}
	
	@RequestMapping("/detailDept.do")
	public ModelAndView detail(int dno) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("d", dao.getDept(dno));
		return mav;
	}
	
	
	@RequestMapping(value = "/insertDept.do", method = RequestMethod.GET)
	public void insertForm() {		
	}
	
	@RequestMapping(value = "/insertDept.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(DeptVO d) {
		int re = dao.insertDept(d);
		ModelAndView mav = new ModelAndView("redirect:/listDept.do");
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "부서 등록에 실패하였습니다.");
		}
		return mav;
	}
	
	
	@RequestMapping(value = "/updateDept.do", method = RequestMethod.GET)
	public ModelAndView updateForm(int dno) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("d", dao.getDept(dno));
		return mav;
	}
	
	@RequestMapping(value = "/updateDept.do", method = RequestMethod.POST)
	public ModelAndView updateSubmit(DeptVO d) {
		ModelAndView mav = new ModelAndView("redirect:/detailDept.do?dno="+d.getDno());
		int re = dao.updateDept(d);
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "부서 수정에 실패하였습니다.");
		}
		return mav;
	}
	
	
	@RequestMapping("/deleteDept.do")
	public ModelAndView delete(int dno) {
		ModelAndView mav = new ModelAndView("redirect:/listDept.do");
		int re = dao.deleteDept(dno);
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "부서 삭제에 실패하였습니다.");
		}
		return mav;
	}
	
}











