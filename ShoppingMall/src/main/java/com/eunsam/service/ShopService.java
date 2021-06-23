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
	
	//ī�װ��� ��ǰ ����Ʈ
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception;
	
	//��ǰ ��ȸ
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	//���� �ۼ�
	public void registReply(ReplyVO reply) throws Exception;
	
	//���� ���
	public List<ReplyListVO> replyList(int gdsNum) throws Exception;
	
	//���� ����
	public void deleteReply(ReplyVO reply) throws Exception;
	
	//���̵� üũ
	public String idCheck(int repNum) throws Exception;
	
	//���� ����
	public void modifyReply(ReplyVO reply) throws Exception;
	
	//īƮ ���
	public void addCart(CartVO cart) throws Exception;
	
	//īƮ ���
	public List<CartListVO> cartList(String userId) throws Exception;
	
	//īƮ ����
	public void deleteCart(CartVO cart) throws Exception;
	
	//�ֹ� ����
	public void orderInfo(OrderVO order) throws Exception;
		
	//�ֹ� �� ����
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception;
	
	//�ֹ� �� īƮ ����
	public void cartAllDelete(String userId) throws Exception;
	
	//Ư�� ���� �ֹ� ���
	public List<OrderVO> orderList(OrderVO order) throws Exception;
	
	//Ư�� �ֹ� ����
	public List<OrderListVO> orderView(OrderVO order) throws Exception;
}
