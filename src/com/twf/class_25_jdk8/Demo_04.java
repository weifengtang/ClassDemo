package com.twf.class_25_jdk8;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName:Demo_04
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1718:08
 * @Version:1.0 此Stream和IO没有关系, JDK8中的Stream是对集合对象功能 的增强,它专注于对集合对象进行各种非常便利、
 * 高效的聚合操 作,或者大批量的操作 •Stream API和Lambda表达式,极大的提高编程效率和程序的可 读性。
 * •同时它提供串行和并行两种模式进行汇聚操作,并发操作模式能 够充分利用多核处理器的优势,使用fork/join
 * 并行方式来拆分 任务和加速处理过程。
 * •通常编写并行代码很难而且很容易出错,但使用Stream API无需编写一行多线程的代码,就可以很方便地写出高性能的并发程序。
 * •JDK8出现的Stream是一个函数式语言+多核时代的产物
 **/

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        super();
        this.name = name;
        this.score = score;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // @Override
    public String toString() {
        return "Student [name=" + name + ", score=" + score + "]\n";
    }
}

//Stream示例
public class Demo_04 {
    Random random;
    ArrayList<Student> stuList;

    @Before
    public void before() {
        random = new Random();

        stuList = new ArrayList() {//内部类
            {
                for (int i = 0; i < 100; i++) {
                    add(new Student("Student" + i, random.nextInt(50) + 50));
                }
            }
        };
    }

    @Test
    public void test1() {
  /*      List<String> studentList = stuList.stream().filter(x -> x.getScore() > 85)
                .sorted(Comparator.comparing(Student::getScore)
                        .reversed()).map(Student::getName)
                .collect(Collectors.toList());
*/
        Function<Student, Integer> function = Student::getScore;  //方法引用：调用其实例方法
//        Function<Student, Integer> function = (student)->student.getScore();  //Function<T, R> 传入T返回R
        Function<Student, String> function2 = Student::getName;
//        Function<Student, String> function2 = (student)->student.getName();

        //过滤流
        Stream stream = stuList.stream().filter((student) -> { return student.getScore() > 85; });
        List<String> studentList = (List<String>) stream.sorted(Comparator.comparing(function).reversed())
                .map(function2)//方法引用的方式
                .collect(Collectors.toList());
        System.out.println(studentList);

    }

}
