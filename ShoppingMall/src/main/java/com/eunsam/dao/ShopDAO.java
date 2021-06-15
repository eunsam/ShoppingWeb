package com.eunsam.dao;

import java.util.List;

import com.eunsam.domain.GoodsViewVO;

public interface ShopDAO {

	//ī�װ��� ��ǰ ����Ʈ : 1�� �з�
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception;
	
	//ī�װ��� ��ǰ ����Ʈ : 2�� �з�
	public List<GoodsViewVO> list(int cateCode) throws Exception;
	
	//��ǰ ��ȸ
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
}
