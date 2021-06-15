package com.eunsam.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.eunsam.dao.ShopDAO;
import com.eunsam.domain.GoodsViewVO;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Inject
	private ShopDAO dao;

	//카테고리별 상품 리스트
	@Override
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception {
		
		int cateCodeRef = 0;
		
		if(level == 1) {
			
			cateCodeRef = cateCode;
			return dao.list(cateCode, cateCodeRef);
		} else {
			
		return dao.list(cateCode);
	} }
	
	//상품 조회
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return dao.goodsView(gdsNum);
	}

}
