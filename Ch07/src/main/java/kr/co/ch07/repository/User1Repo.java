package kr.co.ch07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.co.ch07.vo.User1VO;

public interface User1Repo extends JpaRepository<User1VO, String> {
	
	// JPA 쿼리메서드
	public User1VO findUser1VOByUid(String uid);
	public List<User1VO> findUser1VOByName(String name);
	public List<User1VO> findUser1VOByNameNot(String name);
	
	public List<User1VO> findUser1VOByUidAndName(String uid, String name);
	public List<User1VO> findUser1VOByUidOrName(String uid, String name);
	
	public List<User1VO> findUser1VOByAgeGreaterThan(int age); //크다
	public List<User1VO> findUser1VOByAgeGreaterThanEqual(int age); //크거나 같다
	public List<User1VO> findUser1VOByAgeLessThan(int age); //작다
	public List<User1VO> findUser1VOByAgeLessThanEqual(int age); //작거나 같다
	
	public List<User1VO> findUser1VOByNameLike(String name); // name 앞뒤로 % 명시
	public List<User1VO> findUser1VOByNameContains(String name); // 포함하다.
	public List<User1VO> findUser1VOByNameStartsWith(String name);
	public List<User1VO> findUser1VOByNameEndsWith(String name);
	
	public List<User1VO> findUser1VOByOrderByName();
	public List<User1VO> findUser1VOByOrderByAgeAsc();
	public List<User1VO> findUser1VOByOrderByAgeDesc();
	public List<User1VO> findUser1VOByAgeGreaterThanOrderByAgeDesc(int age);
	
	public int countUser1VOByUid(String uid);
	public int countUser1VOByName(String name);
	
	// JPQL
	@Query("SELECT u1 FROM User1VO AS u1 WHERE u1.age < 40")
	public List<User1VO> selectUserUnderAge30();
	
	@Query("SELECT u1 FROM User1VO AS u1 WHERE u1.name =?1")
	public List<User1VO> selectUserByName(String name);
	
	@Query("SELECT u1 FROM User1VO AS u1 WHERE u1.name = :name")
	public List<User1VO> selectUserByWithParam(@Param("name") String name);
	
}
