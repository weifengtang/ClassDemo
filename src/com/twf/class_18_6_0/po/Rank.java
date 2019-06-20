package com.twf.class_18_6_0.po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName:Rank
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/411:19
 * @Version:1.0
 * 排行榜
 **/
public class Rank  implements Serializable,Comparable<Rank>{

    private String date;
    private String userName;
    private int Socre;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public Rank() {
    }

    public Rank(Date date, String userName, int socre) {
        this.date = simpleDateFormat.format(date);
        this.userName = userName;
        Socre = socre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = simpleDateFormat.format(date);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSocre() {
        return Socre;
    }

    public void setSocre(int socre) {
        Socre = socre;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "date='" + date + '\'' +
                ", userName='" + userName + '\'' +
                ", Socre='" + Socre + '\'' +
                '}';
    }

    @Override
    public int compareTo(Rank inner) {
        return (this.Socre-inner.Socre)>0?-1:1;
    }
}
