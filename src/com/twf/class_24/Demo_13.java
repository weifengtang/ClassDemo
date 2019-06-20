package com.twf.class_24;

/**
 * @ClassName:Demo_13
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1621:06
 * @Version:1.0
 **/
class Point {
    protected final int x, y;
    private final String name;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
        name = makeName();
    }

    protected String makeName() {
        return "[" + x + "," + y + "]";
    }

    @Override
    public final String toString() {
        return name;
    }

}

public class Demo_13  extends Point{
    protected final String color;

    Demo_13(int x, int y, String color) {
        super(x, y);
        this.color = color;

    }

    @Override
    protected String makeName() {
        return super.makeName() + ":" + color;
    }

    /**
     * 父类 覆写Object 的toString();
     * 而父类的toString方法返回的 name;
     * name 在父类构造中  name = makeName();
     * makeName()被子类覆盖
     * @param args
     */
    public static void main(String[] args) {
        Demo_13 d = new Demo_13(4, 2, "Blue");
        System.out.println(d.color);
        System.out.println(d);
    }


}
