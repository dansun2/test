package com.ohgiraffers.understand;

import com.ohgiraffers.understand.auth.impl.GoogleAuth;
import com.ohgiraffers.understand.auth.impl.KakaoAuth;
import com.ohgiraffers.understand.auth.impl.NaverAuth;
import com.ohgiraffers.understand.dto.MemberDTO;
import com.ohgiraffers.understand.service.MemberService;

import java.util.Scanner;

public class Application01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberService memberService;
        while(true){
            MemberDTO memberDTO;

            System.out.println("----로그인 프로그램 시작----");
            System.out.println("1. google 로그인");
            System.out.println("2. naver 로그인");
            System.out.println("3. kakao 로그인");
            System.out.println("9. 프로그램 종료");
            System.out.println("로그인 할 인증 수단을 선택해주세요");
            int choice = scanner.nextInt();
            if (choice != 1 && choice != 2 && choice != 3 && choice != 9){
                System.out.println("잘못 누르셨습니다. 다시 선택해주세요.");
                continue;
            }

            if(choice == 9) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            scanner.nextLine();
            System.out.print("아이디를 입력해주세요 : ");
            String id = scanner.nextLine();
            System.out.print("비밀번호를 입력해주세요 : ");
            String pwd = scanner.nextLine();
            // 위에서 선언한 memberDTO를 초기화해줌
            memberDTO = new MemberDTO(id, pwd);
            String result = "";


            switch (choice) {
                case 1: memberService = new MemberService(new GoogleAuth());
                    result = memberService.findMember(memberDTO);
                    if(result.equals("true")){
                        System.out.println("google 로그인에 성공하였습니다. " + memberDTO.getID());
                    }
                    break;
                case 2: memberService = new MemberService(new NaverAuth());
                    result = memberService.findMember(memberDTO);
                    if(result.equals("true")){
                        System.out.println("naver 로그인에 성공하였습니다. " + memberDTO.getID());
                    }
                    break;
                case 3: memberService = new MemberService(new KakaoAuth());
                    result = memberService.findMember(memberDTO);
                    if(result.equals("true")){
                        System.out.println("kakao 로그인에 성공하였습니다. " + memberDTO.getID());
                    }
                    break;
                case 9:
                    System.out.println("로그인을 종료합니다.");
                    return;
                default :
                    System.out.println("잘못 선택하였습니다. 다시 시도해 주세요.");
                    break;
            }
            System.out.println(result);
        }
    }



}
