package com.twf.class_21.demo_03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @ClassName:Client
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1117:07
 * @Version:1.0
 **/
public class Client {
    /*
        1、创建客户端Socket,建立连接
        2、接收服务器消息
        3、从控制读取消息，发送到服务器

     */
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getLocalHost();

        Socket clientSocket = new Socket(inetAddress.getHostAddress(), 8080);

        new Thread(new ClientSendMassage(clientSocket)).start();
        new Thread(new ClientReceiveMassage(clientSocket)).start();
    }

}

//客户端接收消息
class ClientReceiveMassage implements Runnable {
    private BufferedReader bufferedReader;
    private boolean isRunning = true;
    //初始化输入流
    public ClientReceiveMassage(Socket clientSocket) {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("客户端准备接收消息---");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //接收消息
    private void receiveMassage() throws IOException {
        String msg = bufferedReader.readLine();
        System.out.println("Server>> "+msg);
    }


    @Override
    public void run() {
       while (isRunning){
           try {
               receiveMassage();
           } catch (IOException e) {
               e.printStackTrace();
               isRunning =false;
               try {
                   bufferedReader.close();
               } catch (IOException ex) {
                   ex.printStackTrace();
               }

           }
       }
    }
}

//客户端发送消息
class ClientSendMassage implements Runnable {

    //控制台输入流
    private BufferedReader console;
    //输出流
    private BufferedWriter bufferedWriter;
    //控制线程标识
    private boolean isRunning = true;

    public ClientSendMassage() {
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    public ClientSendMassage(Socket clientSocket) {
        this();
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            System.out.println("客户端准备发送消息---");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            sendMassage(getConsole());
        }
    }

    //发送消息
    private void sendMassage(String msg) {
        if (msg == null && "".equals(msg))
            return;
        try {
            bufferedWriter.write(msg);
            bufferedWriter.flush();//强制刷新
        } catch (IOException e) {
            isRunning = false;
            try {
                bufferedWriter.close();
                console.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    //接收控制台消息
    public String getConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}