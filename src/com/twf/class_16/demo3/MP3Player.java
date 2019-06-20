package com.twf.class_16.demo3;

/**
 * @ClassName:MP3Player
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/316:55
 * @Version:1.0
 **/
public class MP3Player extends Player {
    @Override
    public byte[] read() {
        System.out.println("，MP3Player读");
        return new byte[0];
    }

    @Override
    public void write(byte[] datas) {
        System.out.println("，MP3Player写"+datas);
    }

    @Override
    public void playMusic(){
        System.out.println("，MP3Player-MP3Player");
    }
}
