package com.eunsam.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.eunsam.domain.GoodsViewVO;
import com.eunsam.domain.ReplyListVO;
import com.eunsam.domain.ReplyVO;

@Repository
public class ShopDAOImpl implements ShopDAO {
	
	@Inject
	private SqlSession sql;
	
	//매퍼
	private static String namespace = "com.eunsam.mappers.shopMapper";

	//카테고리별 상품 리스트 : 1차 분류
	@Override
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("cateCode", cateCode);
		map.put("cateCodeRef", cateCodeRef);
		
		return sql.selectList(namespace + ".list_1", map);
	}
	
	//카테고리별 상품 리스트 : 2차 분류
	@Override
	public List<GoodsViewVO> list(int cateCode) throws Exception {
		
		return sql.selectList(namespace + ".list_2", cateCode);
	}
	
	//상품 조회
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		
		return sql.selectOne("com.eunsam.mappers.shopMapper" + ".goodsView", gdsNum);
	}
	
	//리뷰 작성
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		sql.insert(namespace + ".registReply", reply);
	}
	
	//리뷰 목록
	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		return sql.selectList(namespace + ".replyList", gdsNum);
	}

}
