package com.twf.class_03;


/**
 * 货运公司承接用户的运货请求时,会根据货运里程给客户一定的优惠折扣。
 * • 当货运里程在500km（不包括500km）以内时,没有折扣(discount)；
 * • 当货运里程在1000km（不包括1000km）以内时,减免客户5%的运费；
 * • 当货运里程在1500km（不包括1500km）以内时,减免客户8%的运费；
 * • 当货运里程在2500km（不包括2500km）以内时,减免客户10%的运费；
 * • 当货运里程超过2500km时，减免客户12%的运费。
 * • 给定用户货物重量weight、货运里程dist及单位运费fee（每吨公里运
 * 费），编程计算用户应支付的运费。
 *
 */
public class CustomerFee {
    //用户货物重量weight、货运里程dist及单位运费fee（每吨公里运费）
    public static void main(String[] args) {
        System.out.println("支付运费："+fun(500d,2500d));
       // System.out.println("支付运费："+fun2(500d,2500L));
    }



    private static Double fun(Double weight,Double dist) {
        double fee = 100.55d;//每吨公里运费
        double totalFee = 0d;
        if (dist<500){
            totalFee =  weight*dist*fee;
        }else if (dist>=500&&dist<1000){
            totalFee =  (weight*dist*fee)*0.95;
        }else if(dist>=1000&&dist<1500){
            totalFee =  (weight*dist*fee)*0.92;
        }else if(dist>=1500&&dist<2500){
            totalFee =  (weight*dist*fee)*0.9;
        }else{
            totalFee =  (weight*dist*fee)*0.88;
        }
        return totalFee;
    }

}
