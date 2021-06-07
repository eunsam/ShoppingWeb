package com.eunsam.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.eunsam.domain.CategoryVO;
import com.eunsam.domain.GoodsVO;
import com.eunsam.domain.GoodsViewVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession sql;
	
	//����
	private static String namespace = "com.eunsam.mappers.adminMapper";
	
	//ī�װ���
	@Override
	public List<CategoryVO> category() throws Exception {
		return sql.selectList(namespace + ".category");
	}
	
	//��ǰ���
	@Override
	public void register(GoodsVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
	}
	
	//��ǰ���
	@Override
	public List<GoodsVO> goodslist() throws Exception {
		return sql.selectList(namespace + ".goodslist");
	}
	
	//��ǰ��ȸ+ī�װ��� ����
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return sql.selectOne(namespace + ".goodsView", gdsNum);
	}
	
	//��ǰ����
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		sql.update(namespace + ".goodsModify", vo);
	}
	
	//��ǰ����
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		sql.delete(namespace + ".goodsDelete", gdsNum);
	}

}