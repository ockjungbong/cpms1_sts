package devock.cpms.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devock.cpms.member.service.LoginVO;
import devock.cpms.member.service.MemberService;
import devock.cpms.member.service.UserVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
    
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public UserVO selectMember4Login (LoginVO loginInfo) throws Exception {
        return memberMapper.selectMember4Login(loginInfo);
    }

    @Override
    public void insertLogIn (String userno) throws Exception {
        memberMapper.insertLogIn(userno);
    }

    @Override
    public void insertLogOut (String userno) throws Exception {
        memberMapper.insertLogOut(userno);
        
    }

}
