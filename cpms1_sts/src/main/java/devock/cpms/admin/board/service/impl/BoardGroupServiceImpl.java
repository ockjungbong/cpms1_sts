package devock.cpms.admin.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devock.cpms.admin.board.service.BoardGroupService;

@Service("boardGroupService")
public class BoardGroupServiceImpl implements BoardGroupService{
	
	@Autowired
	private BoardGroupMapper boardGroupMapper;

	@Override
	public List<?> selectBoardGroupList() throws Exception {
		return boardGroupMapper.selectBoardGroupList();
	}
	
	

}
