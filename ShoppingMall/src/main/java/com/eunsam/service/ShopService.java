package com.eunsam.service;

import java.util.List;

import com.eunsam.domain.GoodsViewVO;
import com.eunsam.domain.ReplyListVO;
import com.eunsam.domain.ReplyVO;

public interface ShopService {
	
	//ī�װ��� ��ǰ ����Ʈ
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception;
	
	//��ǰ ��ȸ
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	//���� �ۼ�
	public void registReply(ReplyVO reply) throws Exception;
	
	//���� ���
	public List<ReplyListVO> replyList(int gdsNum) throws Exception;
	
	//���� ����
	public void deleteReply(ReplyVO reply) throws Exception;
	
	//���̵� üũ
	public String idCheck(int repNum) throws Exception;
	
	//���� ����
	public void modifyReply(ReplyVO reply) throws Exception;
}
