package com.eunsam.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.eunsam.dao.ShopDAO;
import com.eunsam.domain.CartListVO;
import com.eunsam.domain.CartVO;
import com.eunsam.domain.GoodsViewVO;
import com.eunsam.domain.OrderDetailVO;
import com.eunsam.domain.OrderListVO;
import com.eunsam.domain.OrderVO;
import com.eunsam.domain.ReplyListVO;
import com.eunsam.domain.ReplyVO;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Inject
	private ShopDAO dao;

	//ī�װ��� ��ǰ ����Ʈ
	@Override
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception {
		
		int cateCodeRef = 0;
		
		if(level == 1) {
			
			cateCodeRef = cateCode;
			return dao.list(cateCode, cateCodeRef);
		} else {
			
		return dao.list(cateCode);
	} }
	
	//��ǰ ��ȸ
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return dao.goodsView(gdsNum);
	}
	
	//���� �ۼ�
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		dao.registReply(reply);
	}
	
	//���� ���
	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		return dao.replyList(gdsNum);
	}
	
	//���� ����
	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		dao.deleteReply(reply);
	}
	
	//���̵� üũ
	@Override
	public String idCheck(int repNum) throws Exception {
		return dao.idCheck(repNum);
	}
	
	//���� ����
	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		dao.modifyReply(reply);
	}
	
	//īƮ ���
	@Override
	public void addCart(CartVO cart) throws Exception {
		dao.addCart(cart);
	}
	
	//īƮ ���
	@Override
	public List<CartListVO> cartList(String userId) throws Exception {
		return dao.cartList(userId);
	}
	
	//īƮ ����
	@Override
	public void deleteCart(CartVO cart) throws Exception {
		dao.deleteCart(cart);
	}
	
	//�ֹ� ����
	@Override
	public void orderInfo(OrderVO order) throws Exception {
		dao.orderInfo(order);
	}
	
	//�ֹ� �� ����
	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		dao.orderInfo_Details(orderDetail);
	}
	
	//�ֹ� �� īƮ ����
	@Override
	public void cartAllDelete(String userId) throws Exception {
		dao.cartAllDelete(userId);
	}
	
	//Ư�� ���� �ֹ� ���
	@Override
	public List<OrderVO> orderList(OrderVO order) throws Exception {
		return dao.orderList(order);
	}
	
	//Ư�� �ֹ� ����
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		return dao.orderView(order);
	}

}
