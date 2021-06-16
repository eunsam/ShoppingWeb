package com.eunsam.service;

import java.util.List;

import com.eunsam.domain.GoodsViewVO;
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
}
