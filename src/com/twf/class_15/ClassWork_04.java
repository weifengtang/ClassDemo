package com.twf.class_15;

/**
 *
 * 定义一个季节枚举,应用抽象方法,输出对应季 节的信息
 * @ClassName:ClassWork_04
 * @Description TODO
 * @Author:TWF
 * @Date:2019/5/3120:53
 * @Version:1.0
 *
 * 枚举是对 常量的一种封装
 **/
public class ClassWork_04 {



    public static void main(String[] args) {
        System.out.println("-----------");
        final String string = "春天";
        String string2 = new String("春天");
        String name =  Seasons.SPRING.getName();

        System.out.println(name.equals(string));
        System.out.println(name==string);
        System.out.println(name.equals(string2));
        System.out.println(name==string2);

        System.out.println(Seasons.SPRING.getType());
        System.out.println("-----------");

        for (Food.Dessert dessert:Food.Dessert.values()){
            System.out.println(dessert);
        }
        //实现接口，来组织枚举，简单讲，就是分类吧。如果大量使用枚举的话，这么干，在写代码的时候，就很方便调用啦。
        //还有就是个“多态”的功能吧，
        Food food = Food.Coffee.BLACK_COFFEE;
        System.out.println(food);

        for (Food.Coffee coffee:Food.Coffee.values()) {
            System.out.println(coffee+"--"+coffee.ordinal());
        }

    }
}



enum  Seasons{
   SPRING("春天","春风又绿江南岸"),
   SUMMER("夏天","映日荷花别样红"),
   AUTUMN("秋天","秋水共长天一色"),
   WINTER("冬天","冬天来了");

   //成员变量
   private  String name;
   private  String type;


//   构造方法
    Seasons(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Seasons{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
//使用接口组织枚举类
interface  Food{
    enum Coffee implements  Food{
        BLACK_COFFEE,DECAF_COFFEE
    }
    enum Dessert implements  Food{
        FRIT,CAKE,GELATO
    }
}