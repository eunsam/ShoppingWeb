package com.eunsam.service;

import java.util.List;

import com.eunsam.domain.CategoryVO;
import com.eunsam.domain.GoodsVO;
import com.eunsam.domain.GoodsViewVO;
import com.eunsam.domain.OrderListVO;
import com.eunsam.domain.OrderVO;

public interface AdminService {

	//ī�װ�
	public List<CategoryVO> category() throws Exception;
	
	//��ǰ���
	public void register(GoodsVO vo) throws Exception;
	
	//��ǰ���
	public List<GoodsViewVO> goodslist() throws Exception;
	
	//��ǰ��ȸ+ī�װ� ����
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	//��ǰ����
	public void goodsModify(GoodsVO vo) throws Exception;
	
	//��ǰ����
	public void goodsDelete(int gdsNum) throws Exception;
	
	//�ֹ����
	public List<OrderVO> orderList() throws Exception;
		
	//Ư�� �ֹ� ���
	public List<OrderListVO> orderView(OrderVO order) throws Exception;
}
