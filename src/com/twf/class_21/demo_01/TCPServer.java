package com.twf.class_21.demo_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName:TCPServer
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/118:58
 * @Version:1.0
 *
 * 服务器端
 **/
public class TCPServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("服务器正在运行----");
        Socket client = serverSocket.accept();//接收客户端socket
        System.out.println("服务器有客户端连接-");
        client.setSoTimeout(5000);//设置超时时间

        //向客户端发送消息
        PrintStream out = new PrintStream(client.getOutputStream());
        //out.println("hello word");

        //接收客户端消息
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println(bufferedReader.readLine());

        out.close();
        bufferedReader.close();
        client.close();

    }

}
