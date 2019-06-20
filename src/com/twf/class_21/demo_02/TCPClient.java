package com.twf.class_21.demo_02;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName:TCPClient
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/119:08
 * @Version:1.0 客户端
 **/
public class TCPClient {

    private  static Socket socket;
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        socket = new Socket(inetAddress.getHostAddress().toString(), 8080);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)) ;
        //接收服务器 消息
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //发送消息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        boolean flag = true;
        while (flag) {
            System.out.println("发送消息到服务器： ");
            String msg = input.readLine();//接收键盘输入
            bufferedWriter.write(msg);//发送消息
            if ("886".equals(msg)){ //关闭客户端
                flag = false;
            }else {
                String str = bufferedReader.readLine();
                if(str!=null&&str.equals("")){
                    System.out.println("Server->"+ str);
                }
            }
            bufferedWriter.flush();
        }
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();

    }


}
