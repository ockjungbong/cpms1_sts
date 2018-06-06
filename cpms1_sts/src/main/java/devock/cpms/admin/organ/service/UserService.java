package devock.cpms.admin.organ.service;

import devock.cpms.member.service.UserVO;

public interface UserService {

	UserVO selectUserOne(String userno) throws Exception;

	void updateUserPassword(UserVO userInfo) throws Exception;

	void updateUserByMe(UserVO userInfo) throws Exception;

}
