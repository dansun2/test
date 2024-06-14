package com.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {

    public static void main(String[] args) {

        ServerSocket server = null;    //서버 소켓 선언
        Socket socket = null;            //통신 소켓 선언
        //클라이언트에서 전송받는 데이터를 읽기 위한 스캐너
        Scanner sc = null;
        //클라이언트로 데이터를 전송하기 위한 PrintWriter
        PrintWriter printWriter = null;

        try {
//			서버를 만든다. => 10004번 포트를 열어서 서버 소켓을 생성한다.
            server = new ServerSocket(22223);
            System.out.println("서버 시작 : " + server);
            System.out.println("클라이언트가 접속하기를 기다립니다...");
//			accept() : 지정된 포트로 클라이언트가 접속할 때까지 무한 연결 대기하다가 연결요청이 오면 새로운 Socket 객체 반환
            socket = server.accept();
            System.out.println("클라이언트 접속 : " + socket);

//			클라이언트에서 전송되는 데이터를 수신하기 위해 수신용 객체를 선언한다.
            sc = new Scanner(socket.getInputStream());
//			클라이언트에서 전송되는 데이터를 읽는다.
            System.out.println(sc.nextLine());

//			클라이언트로 데이터를 전송하기 위해 전송용 객체를 생성
            printWriter = new PrintWriter(socket.getOutputStream());
//			클라이언트로 데이터를 전송한다. => 반드시 데이터의 맨 끝에 \n를 붙인다.
            printWriter.write("어서와 클라이언트야~~~~\n");
//			printWriter 객체로 데이터를 전송할 땐 출력 버퍼가 가득 찼을 때만 내용이 전송된다.
//			flush() : 출력 버퍼가 가득 차지 않았더라도 데이터를 전송하게 해준다.
            printWriter.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//			통신에 사용한 객체를 닫는다.
            if (server != null) {
                try {
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                try {
                    sc.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (printWriter != null) {
                try {
                    printWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}