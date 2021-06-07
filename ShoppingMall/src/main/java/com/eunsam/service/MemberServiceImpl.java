package com.eunsam.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.eunsam.dao.MemberDAO;
import com.eunsam.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDAO dao;

	//ȸ������
	@Override
	public void signup(MemberVO vo) throws Exception {
		dao.signup(vo);
	}
	
	//�α���
	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return dao.signin(vo);
	}
	
	//�α׾ƿ�
	@Override
	public void signout(HttpSession session) throws Exception {
		session.invalidate();
	}
	

}
