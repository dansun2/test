package com.ohgiraffers.understand.auth.impl;

import com.ohgiraffers.understand.auth.SnsAuth;
import com.ohgiraffers.understand.dto.MemberDTO;

public class NaverAuth implements SnsAuth {
    @Override
    public boolean login(MemberDTO member) {
        System.out.println("네이버 로그인 성공");
        return true;
    }
}
