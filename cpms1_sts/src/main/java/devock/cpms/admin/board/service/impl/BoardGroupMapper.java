package devock.cpms.admin.board.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardGroupMapper {

	List<?> selectBoardGroupList() throws Exception;

}
