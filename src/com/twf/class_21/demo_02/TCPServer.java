package com.twf.class_21.demo_02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName:TCPServer
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/118:58
 * @Version:1.0 服务器端
 **/
public class TCPServer {

    public static void main(String[] args) throws IOException {

        //1、服务器端不断在监听客户端的连接
        //2、

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("服务器正在运行----");

        boolean flag = true;
        while (flag) {//程序再此阻塞,等待客户端连接
            Socket client = waitClientAccpet(serverSocket);
            System.out.println(client);
            ThreadServer threadServer = new ThreadServer();
            threadServer.setClient(client);
            threadServer.start();
        }
        serverSocket.close();

    }

    private static Socket waitClientAccpet(ServerSocket serverSocket) throws IOException {
        Socket socketClient = serverSocket.accept();//接收客户端socket
        socketClient.setSoTimeout(50000);//设置超时时间
        return socketClient;
    }

}

class ThreadServer extends Thread {

    private Socket client;
    String msg;

    public void setClient(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            System.out.println("向客户端发送消息：");
            bufferedWriter.write(input.readLine());
            bufferedWriter.flush();
            msg = bufferedReader.readLine();
            System.out.println("Client->" + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}