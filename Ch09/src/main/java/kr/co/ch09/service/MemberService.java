package kr.co.ch09.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch09.dao.MemberDAO;
import kr.co.ch09.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	public void insertMember(MemberVO vo) {
		dao.save(vo);
	};
	
	public MemberVO selectMember(String uid) {
		return dao.findById(uid).get();
	};
	
	public List<MemberVO> selectMembers() {
		return dao.findAll();
	};
	
	public void updateMember(MemberVO vo) {
		dao.save(vo);
	};
	
	public void deleteMember(String uid) {
		dao.deleteById(uid);
	};
}
