package com.eunsam.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.eunsam.domain.CategoryVO;
import com.eunsam.domain.GoodsVO;
import com.eunsam.domain.GoodsViewVO;
import com.eunsam.domain.OrderListVO;
import com.eunsam.domain.OrderVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession sql;
	
	//매퍼
	private static String namespace = "com.eunsam.mappers.adminMapper";
	
	//카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		return sql.selectList(namespace + ".category");
	}
	
	//상품등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
	}
	
	//상품목록
	@Override
	public List<GoodsViewVO> goodslist() throws Exception {
		return sql.selectList(namespace + ".goodslist");
	}
	
	//상품조회+카테고리 조인
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return sql.selectOne(namespace + ".goodsView", gdsNum);
	}
	
	//상품수정
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		sql.update(namespace + ".goodsModify", vo);
	}
	
	//상품삭제
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		sql.delete(namespace + ".goodsDelete", gdsNum);
	}
	
	//주문목록
	@Override
	public List<OrderVO> orderList() throws Exception {
		return sql.selectList(namespace + ".orderList");
	}
		
	//특정 주문 목록
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		return sql.selectList(namespace + ".orderView", order);
	}

}
