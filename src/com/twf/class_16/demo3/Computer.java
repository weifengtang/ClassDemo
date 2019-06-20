package com.twf.class_16.demo3;

/**
 * @ClassName:Computer
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/316:50
 * @Version:1.0
 **/
public class Computer {
    private  MoveInterface moveInterface ;
    public Computer() {
    }
    public Computer(MoveInterface moveInterface) {
        this.moveInterface = moveInterface;
    }

    //读
    public byte[] read(){
        return moveInterface.read();
    }
    //写
    public void write(){
        byte[] bytes = {};
        moveInterface.write(bytes);
    }
}
