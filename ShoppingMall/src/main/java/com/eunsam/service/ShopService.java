package com.eunsam.service;

import java.util.List;

import com.eunsam.domain.CartListVO;
import com.eunsam.domain.CartVO;
import com.eunsam.domain.GoodsViewVO;
import com.eunsam.domain.OrderDetailVO;
import com.eunsam.domain.OrderListVO;
import com.eunsam.domain.OrderVO;
import com.eunsam.domain.ReplyListVO;
import com.eunsam.domain.ReplyVO;

public interface ShopService {
	
	//카테고리별 상품 리스트
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception;
	
	//상품 조회
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	//리뷰 작성
	public void registReply(ReplyVO reply) throws Exception;
	
	//리뷰 목록
	public List<ReplyListVO> replyList(int gdsNum) throws Exception;
	
	//리뷰 삭제
	public void deleteReply(ReplyVO reply) throws Exception;
	
	//아이디 체크
	public String idCheck(int repNum) throws Exception;
	
	//리뷰 수정
	public void modifyReply(ReplyVO reply) throws Exception;
	
	//카트 담기
	public void addCart(CartVO cart) throws Exception;
	
	//카트 목록
	public List<CartListVO> cartList(String userId) throws Exception;
	
	//카트 삭제
	public void deleteCart(CartVO cart) throws Exception;
	
	//주문 정보
	public void orderInfo(OrderVO order) throws Exception;
		
	//주문 상세 정보
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception;
	
	//주문 후 카트 비우기
	public void cartAllDelete(String userId) throws Exception;
	
	//특정 유저 주문 목록
	public List<OrderVO> orderList(OrderVO order) throws Exception;
	
	//특정 주문 정보
	public List<OrderListVO> orderView(OrderVO order) throws Exception;
}
