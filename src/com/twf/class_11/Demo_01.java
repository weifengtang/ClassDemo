package com.twf.class_11;

import java.util.Date;
/**
 * 
 * 模板方法设计模式
 * @author TWF
 *
 */
public class Demo_01 {
	public static void main(String[] args) {
		Student student = new Student("刘星光","java班","拉肚子",
				new Date());
		student.permission();
	}
}

 abstract class Person_0{
	private String nameString;
	private String classString;
	private String reasonString;
	private Date date;
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getClassString() {
		return classString;
	}
	public void setClassString(String classString) {
		this.classString = classString;
	}
	public String getReasonString() {
		return reasonString;
	}
	public void setReasonString(String reasonString) {
		this.reasonString = reasonString;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public abstract String getContent();
	
	public void permission() {
		System.out.println("请假内容："+getContent());
	}
	public Person_0(String nameString, String classString, String reasonString, Date date) {
		super();
		this.nameString = nameString;
		this.classString = classString;
		this.reasonString = reasonString;
		this.date = date;
	}
}

class Student extends Person_0{

	public Student(String nameString, String classString, String reasonString, Date date) {
		super(nameString,classString,reasonString,date);
	}
	@Override
	public String getContent() {
		return "姓名："+super.getNameString()+
				"\t班级："+super.getClassString()+
				"\t原因： "+super.getReasonString()+
				"\t时间："+super.getDate();
	}
	
}