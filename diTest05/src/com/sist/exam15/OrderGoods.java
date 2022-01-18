package com.sist.exam15;


public class OrderGoods {
	private String customer;
	private GoodsVO goodsVO;
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public void setGoodsVO(GoodsVO goodsVO) {
		this.goodsVO = goodsVO;
	}
	
	public void order() {
		System.out.println(customer+"고객이 주문한 상품은 다음과 같습니다.");
		goodsVO.info();
	}
}
