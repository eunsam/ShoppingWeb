package com.eunsam.service;

import java.util.List;

import com.eunsam.domain.CategoryVO;
import com.eunsam.domain.GoodsVO;
import com.eunsam.domain.GoodsViewVO;

public interface AdminService {

	//ī�װ���
	public List<CategoryVO> category() throws Exception;
	
	//��ǰ���
	public void register(GoodsVO vo) throws Exception;
	
	//��ǰ���
	public List<GoodsVO> goodslist() throws Exception;
	
	//��ǰ��ȸ+ī�װ��� ����
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	//��ǰ����
	public void goodsModify(GoodsVO vo) throws Exception;
	
	//��ǰ����
	public void goodsDelete(int gdsNum) throws Exception;
}