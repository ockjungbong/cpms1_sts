package devock.cpms.admin.organ.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import devock.cpms.common.vo.SearchVO;
import devock.cpms.member.service.UserVO;

@Mapper
public interface UserMapper {

	UserVO selectUserOne(String userno) throws Exception;

	void updateUserPassword(UserVO userInfo) throws Exception;

	void updateUserByMe(UserVO userInfo) throws Exception;

	List<?> selectUserListWithDept(SearchVO searchVO) throws Exception;

}
