package com.ohgiraffers.understand.auth.impl;

import com.ohgiraffers.understand.auth.SnsAuth;
import com.ohgiraffers.understand.dto.MemberDTO;

public class GoogleAuth implements SnsAuth {

    @Override
    public boolean login(MemberDTO member) {
        System.out.println("구글 로그인 성공됨");
        return true;
    }
}
