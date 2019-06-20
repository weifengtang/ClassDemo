package com.twf.class_16.demo1;

/**
 * @ClassName:Dicoument   折扣
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/317:18
 * @Version:1.0
 *
 **/
public class Dicoument {

    private  double dic;

    public Dicoument() {
    }

    public Dicoument(double price) {
        if (price>=40){
            this.dic = 0.9;
        }else {
            this.dic = 0.8;
        }

    }

    public double getDic() {
        return dic;
    }


}
