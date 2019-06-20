package com.twf.class_02;

/**
 * 对于String对象得理解
 */
public class JavaBase_String {

    public static void main(String[] args) {
        String str = "hello";
        String a = "he";
        String b = "llo";
        String c =  a;

        String d =  a+b;
        String e =  "he"+"llo";  //=str 编译器做了优化，编译器会先把字符串拼接，再在常量池中查找这个字符串是否存在，如果存在，则让变量直接引用该字符串
        String f =  a+"llo"; //先内存堆中先开辟“llo”的内存空间，把a和llo拼接后，再开辟另一个内存空间


        System.out.println(c==a); // true 把a的地址引用赋给c
        System.out.println(str==d); //false
        System.out.println(str==e); //true
        System.out.println(str==f); //false


        System.out.println(d==e); //false
        System.out.println(d==f); //false
        System.out.println(e==f); //false
        System.out.println(d.equals(e)); //true

    }



    public static  void fun(){
        /**
         * 八种基本类型转换成String
         byte a = 1;
         short b = 2;
         int c = 3;
         long d = 4;
         float e = 0.5f;
         double f = 0.5d;
         boolean flag = true;
         char g = 'g';
         char ch[] = {'a','b'};

         Son son = new Son();
         Inter inter;
         String sum = String.valueOf(a)+"--"+
         String.valueOf(b)+"--"+"--"+
         String.valueOf(c)+"--"+
         String.valueOf(e)+"--" +
         String.valueOf(f)+"--"+
         String.valueOf(flag)+"--"+
         String.valueOf(g)+"--"+
         String.valueOf(ch)+"--"+
         String.valueOf(son)+"--";

         System.out.println(sum);
         */

    }



    public static String tr(char []value,String str){

        int len = value.length;
        int st = 0;
        char[] val = value;    /* avoid getfield opcode */

        while ((st < len) && (val[st] <= ' ')) {
            st++;
        }
        while ((st < len) && (val[len - 1] <= ' ')) {
            len--;
        }
        return ((st > 0) || (len < value.length)) ? str.substring(st, len) : str;
    }











}
