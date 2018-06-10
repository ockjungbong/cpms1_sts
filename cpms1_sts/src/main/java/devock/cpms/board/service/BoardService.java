package devock.cpms.board.service;

import java.util.List;

import devock.cpms.admin.board.service.BoardGroupVO;
import devock.cpms.common.vo.Field3VO;
import devock.cpms.common.vo.FileVO;

public interface BoardService {

	Integer selectBoardCount(BoardSearchVO searchVO) throws Exception;

	List<?> selectBoardList(BoardSearchVO searchVO) throws Exception;

	BoardGroupVO selectBoardGroupOne4Used(String bgno) throws Exception;

	List<?> selectNoticeList(BoardSearchVO searchVO) throws Exception;

	BoardVO selectBoardOne(Field3VO field3vo) throws Exception;

	List<?> selectBoardFileList(String brdno) throws Exception;

	String selectBoardAuthChk(BoardVO boardInfo) throws Exception;

	void insertBoard(BoardVO boardInfo, List<FileVO> filelist, String[] fileno) throws Exception;

	void updateBoardRead(Field3VO f3) throws Exception;
	
	

}
