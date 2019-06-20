package com.twf.class_16.demo3;

/**
 * @ClassName:UPan
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/316:54
 * @Version:1.0
 **/
public class UPan implements MoveInterface {

    @Override
    public byte[] read() {
        System.out.println("U盘读");
        return new byte[0];
    }

    @Override
    public void write(byte[] datas) {
        System.out.println("U盘写");
    }
}
