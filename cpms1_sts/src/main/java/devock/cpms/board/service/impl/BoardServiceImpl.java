package devock.cpms.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devock.cpms.admin.board.service.BoardGroupVO;
import devock.cpms.board.service.BoardSearchVO;
import devock.cpms.board.service.BoardService;
import devock.cpms.board.service.BoardVO;
import devock.cpms.common.vo.Field3VO;
import devock.cpms.common.vo.FileVO;

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

	@Override
	public BoardVO selectBoardOne(Field3VO field3vo) throws Exception {
		return boardMapper.selectBoardOne(field3vo);
	}

	@Override
	public List<?> selectBoardFileList(String brdno) throws Exception {
		return boardMapper.selectBoardFileList(brdno);
	}

	@Override
	public String selectBoardAuthChk(BoardVO boardInfo) throws Exception {
		return boardMapper.selectBoardAuthChk(boardInfo);
	}

	@Override
	public void insertBoard(BoardVO boardInfo, List<FileVO> filelist, String[] fileno) throws Exception {
		boardMapper.insertBoard(boardInfo, filelist, fileno);
		
	}

	@Override
	public void updateBoardRead(Field3VO f3) throws Exception {
		boardMapper.updateBoardRead(f3);
		
	}

	@Override
	public void deleteBoardOne(String brdno) throws Exception {
		boardMapper.deleteBoardOne(brdno);		
	}

}
