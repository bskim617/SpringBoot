package kr.co.farmstory.dao;

import kr.co.farmstory.vo.BoardVO;
import kr.co.farmstory.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardDAO {
    public int insertBoard(BoardVO vo);
    public int insertFile(FileVO vo);
    public BoardVO selectBoard(int no);
    public List<BoardVO> selectBoards();
    public int updateBoard(BoardVO vo);
    public int deleteBoard(int no);
}
