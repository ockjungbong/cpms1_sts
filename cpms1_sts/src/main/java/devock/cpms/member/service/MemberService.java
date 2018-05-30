package devock.cpms.member.service;



public interface MemberService {


	UserVO selectMember4Login (LoginVO loginInfo) throws Exception;

	void insertLogIn (String userno) throws Exception;

	void insertLogOut (String userno) throws Exception;



}
