package com.twf.class_24;

/**
 * @ClassName:HomeWork_01
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1622:12
 * @Version:1.0
 **/

 enum Role{
 ADMIN("管理员",22),
 USER("用户",22);

 private  String name;//表示的是该角色的中文名称。
 private Integer lifeTime; //表示的是该角色的生命期,也就是多长 时间该角色失效。

 //   构造方法
 Role(String name, Integer lifeTime) {
  this.name = name;
  this.lifeTime = lifeTime;
 }

}
public class HomeWork_01 {
 public static void main(String[] args) {
  System.out.println(Role.USER);
 }
}
