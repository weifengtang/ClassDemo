package com.twf.class_17_5_0.po;

import com.twf.class_10.Person;

import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @ClassName:Test
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/417:45
 * @Version:1.0
 **/
public class Test {

    public static void main(String[] args) {
        Rank r1 = new Rank(new Date(),"twf",25);
        Rank r2 = new Rank(new Date(),"cwf",21);
        Rank r3 = new Rank(new Date(),"awf",21);
        Rank r4 = new Rank(new Date(),"twf",20);

        TreeSet <Rank> treeSet = new TreeSet<Rank> ();
        treeSet.add(r1);
        treeSet.add(r2);
        treeSet.add(r3);
        treeSet.add(r4);

        Iterator<Rank> it=treeSet.iterator();
        while(it.hasNext()){
            Rank p=(Rank) it.next();
            System.out.println(p);
        }

    }
}
