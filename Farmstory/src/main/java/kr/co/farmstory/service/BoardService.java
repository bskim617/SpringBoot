package kr.co.farmstory.service;

import kr.co.farmstory.dao.BoardDAO;
import kr.co.farmstory.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardDAO dao;

    // 글 목록
    public List<BoardVO> selectBoards(){
        return dao.selectBoards();
    }

}
