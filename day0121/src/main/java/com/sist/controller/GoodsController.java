package com.sist.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO dao;

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listGoods.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.findAll());
		return mav;
	}
	
	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.GET)
	public void insertForm() {		
	}
	
	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(
			HttpServletRequest request, //���ε��� ������ �ǰ�θ� �˾ƿ��� ���Ͽ� requst������ �Ű������� �����մϴ�. 
			GoodsVO g) {
		
		
		String path = request.getRealPath("images");
		System.out.println("path:"+path);
		//request��ü�� ���Ͽ� ���ε��� ������ ��������� �о���ϴ�.
		
		
		MultipartFile uploadFile = g.getUploadFile();
		//vo�� ���ε��� ������ ������ �޾� �ɴϴ�.
		
		String fname = uploadFile.getOriginalFilename();
		//���ε��� �����̸��� �˾ƺ��ϴ�.
		
		byte[] data ;
		try {
			data = uploadFile.getBytes();
			//���ε��� ������ ������ �޾ƿɴϴ�.
			
			FileOutputStream fos = new FileOutputStream(path + "/"+ fname);
			//������ ������ ����ϱ� ���� ��Ʈ���� �����մϴ�.
			
			fos.write(data);
			//������ ������ ����մϴ�.
			
			fos.close();
		}catch (Exception e) {
		}
		
		g.setFname(fname);
		int re = dao.insert(g);
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "��ǰ��Ͽ� �����Ͽ����ϴ�.");
		}
		return mav;
	}
	
	@RequestMapping("/detailGoods.do")	
	public ModelAndView detail(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("g", dao.findByNo(no));
		return mav;
	}
	
	@RequestMapping(value = "/updateGoods.do", method = RequestMethod.GET)
	public ModelAndView updateForm(int no) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("g", dao.findByNo(no));
		return mav;
	}
	
	@RequestMapping(value = "/updateGoods.do", method = RequestMethod.POST)
	public ModelAndView updateSubmit(HttpServletRequest request,   GoodsVO g) {
		String path = request.getRealPath("images");
		
		//���� �����̸��� �̸� ������ ��� �Ӵϴ�.
		String oldFname = g.getFname();
		
		//���ε��� ������ ������ �޾� �ɴϴ�.
		MultipartFile uploadFile = g.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		byte []data;
		try {
			data = uploadFile.getBytes();
			
			//���࿡ ������ �����ߴٸ�
			//���ε��� ������ �ִٸ� ������ �����մϴ�.
			if(fname != null && !fname.equals("")) {
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
				g.setFname(fname);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		
		int re = dao.update(g);
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "��ǰ������ �����Ͽ����ϴ�.");
		}else { //������ �����߰�
			if(fname != null && !fname.equals("")) { //������ �����ߴٸ�
				File file = new File(path + "/" + oldFname);
				file.delete();//���� ������ �����մϴ�.
			}
		}
		return mav;
	}
	
	@RequestMapping("/deleteGoods.do")
	public ModelAndView delete(HttpServletRequest request,  int no) {
		String path = request.getRealPath("images");
		
		//������� �ϴ� ��ǰ�� ���������̸��� �̸� ������ �Ӵϴ�.
		String oldFname = dao.findByNo(no).getFname();
		
		
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		int re = dao.delete(no);
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "��ǰ������ �����Ͽ����ϴ�.");
		}else {
			File file = new File(path +"/" +oldFname);
			file.delete();
		}
		return mav;
	}		
}














