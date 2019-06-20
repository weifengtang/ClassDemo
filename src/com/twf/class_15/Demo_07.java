package com.twf.class_15;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Demo_07 {

	public static void main(String[] args) {

		/*
		 * 第1次：-1244746321 第2次：1060493871 第3次：-1826063944 
		 * 第1次：-1244746321 第2次：1060493871第3次：-1826063944 
		 * 第1次：-1244746321 第2次：1060493871 第3次：-1826063944
		 * 
		 */
		/**
		 *   public Random(long seed) {
        if (getClass() == Random.class)
            this.seed = new AtomicLong(initialScramble(seed));
        else {
            // subclass might have overriden setSeed
            this.seed = new AtomicLong();
            setSeed(seed);
        }
    }
		 */
		//Random r = new Random(1000); //随机种子：参数值
		//无参构造：随机种子为，时间戳
		Random r = new Random(); 
		for (int i = 1; i < 4; i++) {
			System.out.println("第" + i + "次：" + r.nextInt());
		}

	}

}
