package com.eunsam.service;

import java.util.List;

import com.eunsam.domain.GoodsViewVO;

public interface ShopService {
	
	//ī�װ����� ��ǰ ����Ʈ
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception;
	
	//��ǰ ��ȸ
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
}