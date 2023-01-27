package kr.co.farmstory.service;

import kr.co.farmstory.dao.UserDAO;
import kr.co.farmstory.repository.UserRepo;
import kr.co.farmstory.vo.TermsVO;
import kr.co.farmstory.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo repo;

    //약관
    public TermsVO selectTerms() {
        return dao.selectTerms();
    }

    //회원가입
    public int insertUser(UserVO vo) {
        // 비밀번호 암호화 설정
        vo.setPass(passwordEncoder.encode(vo.getPass2()));

        int result = dao.insertUser(vo);
        return result;
    }

    public int countUser(String uid){
        return repo.countByUid(uid);
    }

    public int countNick(String nick){
        return repo.countByNick(nick);
    }
}
