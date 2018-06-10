package devock.cpms.board.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import devock.cpms.admin.board.BoardGroupVO;
import devock.cpms.board.service.BoardSearchVO;

@Mapper
public interface BoardMapper {

	Integer selectBoardCount(BoardSearchVO searchVO) throws Exception;

	List<?> selectBoardList(BoardSearchVO searchVO) throws Exception;

	BoardGroupVO selectBoardGroupOne4Used(String bgno) throws Exception;

	List<?> selectNoticeList(BoardSearchVO searchVO) throws Exception;
}
