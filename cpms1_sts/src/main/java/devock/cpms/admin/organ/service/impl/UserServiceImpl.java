package devock.cpms.admin.organ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devock.cpms.admin.organ.service.UserService;
import devock.cpms.common.vo.SearchVO;
import devock.cpms.member.service.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserVO selectUserOne(String userno) throws Exception {		
		return userMapper.selectUserOne(userno);
	}

	@Override
	public void updateUserPassword(UserVO userInfo) throws Exception {
		userMapper.updateUserPassword(userInfo);
		
	}

	@Override
	public void updateUserByMe(UserVO userInfo) throws Exception {
		userMapper.updateUserByMe(userInfo);
		
	}

	@Override
	public List<?> selectUserListWithDept(SearchVO searchVO) throws Exception {
		return userMapper.selectUserListWithDept(searchVO);
	}

}
