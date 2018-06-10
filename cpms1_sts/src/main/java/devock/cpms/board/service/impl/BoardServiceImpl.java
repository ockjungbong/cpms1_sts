package devock.cpms.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devock.cpms.admin.board.BoardGroupVO;
import devock.cpms.board.service.BoardSearchVO;
import devock.cpms.board.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public Integer selectBoardCount(BoardSearchVO searchVO) throws Exception {
		return boardMapper.selectBoardCount(searchVO);
	}

	@Override
	public List<?> selectBoardList(BoardSearchVO searchVO) throws Exception {
		return boardMapper.selectBoardList(searchVO);
	}

	@Override
	public BoardGroupVO selectBoardGroupOne4Used(String bgno) throws Exception {
		return boardMapper.selectBoardGroupOne4Used(bgno);
	}

	@Override
	public List<?> selectNoticeList(BoardSearchVO searchVO) throws Exception {
		return boardMapper.selectNoticeList(searchVO);
	}

}
