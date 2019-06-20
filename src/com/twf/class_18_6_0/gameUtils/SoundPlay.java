package com.twf.class_18_6_0.gameUtils;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName:SoundPlay
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/515:18
 * @Version:1.0
 *
 * 音乐播放
 **/
public class SoundPlay extends Applet {
        public AudioClip loadSound(String filename) {
            URL url = null;
            try {
                url = new URL("file:" + filename);
            }
            catch (MalformedURLException e) {;}
            return JApplet.newAudioClip(url);
        }
        public void play() {
            AudioClip christmas = loadSound("sources/SoundTest.wav");
            christmas.loop();
        }

     /*   public static void main(String[] args) {
            SoundPlay p=new SoundPlay();
            p.play();
        }*/

    }