package devock.cpms.board.service;

import java.util.List;

import devock.cpms.admin.board.BoardGroupVO;

public interface BoardService {

	Integer selectBoardCount(BoardSearchVO searchVO) throws Exception;

	List<?> selectBoardList(BoardSearchVO searchVO) throws Exception;

	BoardGroupVO selectBoardGroupOne4Used(String bgno) throws Exception;

	List<?> selectNoticeList(BoardSearchVO searchVO) throws Exception;
	
	

}
