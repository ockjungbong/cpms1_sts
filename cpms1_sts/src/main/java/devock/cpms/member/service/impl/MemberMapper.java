package devock.cpms.member.service.impl;

import org.apache.ibatis.annotations.Mapper;

import devock.cpms.member.service.LoginVO;
import devock.cpms.member.service.UserVO;

@Mapper
public interface MemberMapper {

	UserVO selectMember4Login(LoginVO loginInfo) throws Exception;

	void insertLogIn(String userno) throws Exception;

	void insertLogOut(String userno) throws Exception;

}
