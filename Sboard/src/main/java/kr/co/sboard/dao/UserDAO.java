package kr.co.sboard.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.TermsVO;
import kr.co.sboard.vo.UserVO;

@Mapper
@Repository
public interface UserDAO {
	
	// register
	public int insertUser(UserVO vo);
	
	public void selectUser();
	public void selectUsers();
	public void updateUser();
	public void deleteUser();
	
	// 약관
	public TermsVO selectTerms();
}
