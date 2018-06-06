package devock.cpms.member.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import devock.cpms.common.vo.SearchVO;
import devock.cpms.member.service.LoginVO;
import devock.cpms.member.service.UserVO;

@Mapper
public interface MemberMapper {

	UserVO selectMember4Login(LoginVO loginInfo) throws Exception;

	void insertLogIn(String userno) throws Exception;

	void insertLogOut(String userno) throws Exception;

	Integer selectSearchMemberCount(SearchVO searchVO) throws Exception;

	List<?> selectSearchMemberList(SearchVO searchVO) throws Exception;

}
