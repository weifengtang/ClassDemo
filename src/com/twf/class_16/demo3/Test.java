package com.twf.class_16.demo3;

/**
 * @ClassName:Test
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/316:57
 * @Version:1.0
 **/
public class Test {
    public static void main(String[] args) {
        Computer upanComputer = new Computer(new UPan());
        Computer mp3Computer = new Computer(new MP3Player());

        upanComputer.read();
        upanComputer.write();

        mp3Computer.read();
        mp3Computer.write();
    }
}
