package devock.cpms.admin.organ.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devock.cpms.admin.organ.service.UserService;
import devock.cpms.member.service.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserVO selectUserOne(String userno) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectUserOne(userno);
	}

}
