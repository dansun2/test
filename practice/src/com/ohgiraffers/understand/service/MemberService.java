package com.ohgiraffers.understand.service;

import com.ohgiraffers.understand.auth.SnsAuth;
import com.ohgiraffers.understand.dto.MemberDTO;

public class MemberService {

    private SnsAuth snsAuth;

    public MemberService(SnsAuth snsAuth) {
        this.snsAuth = snsAuth;
    }

    public String findMember(MemberDTO memberDTO){
        boolean result = snsAuth.login(memberDTO);
        String type = String.valueOf(snsAuth.getClass()).split("impl.")[1];
        return type + "으로 로그인" + result;

    }

}
