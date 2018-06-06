package devock.cpms.admin.organ.service.impl;

import org.apache.ibatis.annotations.Mapper;

import devock.cpms.member.service.UserVO;

@Mapper
public interface UserMapper {

	UserVO selectUserOne(String userno) throws Exception;

	void updateUserPassword(UserVO userInfo) throws Exception;

	void updateUserByMe(UserVO userInfo) throws Exception;

}
