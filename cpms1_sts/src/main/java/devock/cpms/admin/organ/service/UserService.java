package devock.cpms.admin.organ.service;

import java.util.List;

import devock.cpms.common.vo.SearchVO;
import devock.cpms.member.service.UserVO;

public interface UserService {

	UserVO selectUserOne(String userno) throws Exception;

	void updateUserPassword(UserVO userInfo) throws Exception;

	void updateUserByMe(UserVO userInfo) throws Exception;

	List<?> selectUserListWithDept(SearchVO searchVO) throws Exception;

}
