package devock.cpms.member.service;

import java.util.List;

import devock.cpms.common.vo.SearchVO;

public interface MemberService {


	UserVO selectMember4Login (LoginVO loginInfo) throws Exception;

	void insertLogIn (String userno) throws Exception;

	void insertLogOut (String userno) throws Exception;

	Integer selectSearchMemberCount(SearchVO searchVO) throws Exception;

	List<?> selectSearchMemberList(SearchVO searchVO) throws Exception;



}
