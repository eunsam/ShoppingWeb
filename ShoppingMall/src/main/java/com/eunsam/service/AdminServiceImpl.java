package com.eunsam.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.eunsam.dao.AdminDAO;
import com.eunsam.domain.CategoryVO;
import com.eunsam.domain.GoodsVO;
import com.eunsam.domain.GoodsViewVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	private AdminDAO dao;
	
	//ī�װ�
	@Override
	public List<CategoryVO> category() throws Exception {
		return dao.category();
	}
	
	//��ǰ���
	@Override
	public void register(GoodsVO vo) throws Exception{
		dao.register(vo);
	}
	
	//��ǰ���
	@Override
	public List<GoodsVO> goodslist() throws Exception{
		return dao.goodslist();
	}
	
	//��ǰ��ȸ
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return dao.goodsView(gdsNum);
	}
	
	//��ǰ����
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		dao.goodsModify(vo);
	}
	
	//��ǰ����
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		dao.goodsDelete(gdsNum);
	}
}
