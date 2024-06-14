package com.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client1 {

    public static void main(String[] args) {

        Socket socket = null;		//통신 소켓
        Scanner sc = null;		//서버에서 전송받는 데이터를 읽기 위한 스캐너
        PrintWriter printWriter = null; //서버로 데이터를 전송하는 PrintWriter

        System.out.println("1.214.19.22 서버의 22223번 포트로 접속 시도");

//		서버에 접속시키는 방법
//		new Socket("서버의 ip 주소", 포트 번호)로 서버에 접속한다.
        try {
            socket = new Socket("1.214.19.22", 22223);
            System.out.println("접속 성공  : " + socket);

//		서버에 접속한 후 서버로 데이터를 전송하기 위해서 전송용 객체를 생성한다.
            printWriter = new PrintWriter(socket.getOutputStream());
//		서버로 데이터를 전송한다. => 반드시 데이터의 맨 끝에 \n를 붙인다.
            printWriter.write("안녕하세요~~~~\n");

//		printWriter 객체로 데이터를 전송할 땐 출력 버퍼가 가득 찼을 때만 내용이 전송된다.
//		flush() : 출력 버퍼가 가득 차지 않았더라도 데이터를 전송하게 해준다.
            printWriter.flush();

//		서버에서 전송되는 데이터를 수신하기 위해 수신용 객체를 선언한다.
            sc = new Scanner(socket.getInputStream());
//		서버에서 전송되는 데이터를 읽는다.
            System.out.println(sc.nextLine());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//			통신에 사용한 객체를 닫는다.
            if(sc != null) {
                try {
                    sc.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(printWriter != null) {
                try {
                    printWriter.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}