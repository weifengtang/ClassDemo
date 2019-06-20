package com.twf.class_25_jdk8;

import java.time.Clock;
import java.time.LocalDateTime;

/**
 * @ClassName:Demo_05
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1719:28
 * @Version:1.0
 **/
public class Demo_05 {
    public static void main(String[] args) {
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
        final LocalDateTime datetime = LocalDateTime.now();
        final LocalDateTime datetimeFromClock = LocalDateTime.now(clock);
        System.out.println(datetime);
        System.out.println(datetimeFromClock);

    }
}
