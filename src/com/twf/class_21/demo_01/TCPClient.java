package com.twf.class_21.demo_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

/**
 * @ClassName:TCPClient
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/119:08
 * @Version:1.0
 *
 *  客户端
 **/
public class TCPClient {

    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        Socket socket = new Socket(inetAddress.getHostAddress().toString(),8080);

        //发送消息
        String outString = "hhhh";
        PrintStream out = new PrintStream(socket.getOutputStream());
        out.println(outString);

        //接收服务器 消息
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("等待服务器发送消息");
        String str = bufferedReader.readLine();
        System.out.println("服务器发送的消息： "+ str);

        bufferedReader.close();
        socket.close();
    }
}
