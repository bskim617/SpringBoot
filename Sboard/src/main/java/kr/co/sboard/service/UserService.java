package kr.co.sboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.sboard.dao.UserDAO;
import kr.co.sboard.repository.UserRepo;
import kr.co.sboard.vo.TermsVO;
import kr.co.sboard.vo.UserVO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;
	
	@Autowired
	private UserRepo repo;
	
	//약관
	public TermsVO selectTerms() {
		return dao.selectTerms();
	}
	
	//회원가입
	public int insertUser(UserVO vo) {
		// 비밀번호 암호화 설정
		String pass = vo.getPass2();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		vo.setPass(encoder.encode(pass));
		
		int result = dao.insertUser(vo);
		return result;
	}
	
	// ID 중복확인
	public int countUser(String uid) {
		return repo.countByUid(uid);
	}
}
