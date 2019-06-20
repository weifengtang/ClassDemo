package com.twf.class_11;

/**
 * 监造器模式
 * @author TWF
 *
 */
public class Demo_02 {
	public static void main(String[] args) {
		PersonDirector personDirector = new PersonDirector();
		Person_02 person = personDirector.constructPerson_02(new ManBuilder());
		System.out.println(person);
		
	}
}

//人实体
class Person_02{
	private String head;
	private String body;
	private String foot;
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getFoot() {
		return foot;
	}
	public void setFoot(String foot) {
		this.foot = foot;
	}
	@Override
	public String toString() {
		return "Person_02 [head=" + head + ", body=" + body + ", foot=" + foot + "]";
	}	
	
}
//创造一个人类的接口
interface  PersonBuilder{
	
	abstract void buildBody();
	
	abstract void  buildFoot();
	
	abstract  void buildHead();
	
	abstract Person_02 buildPerson(); 
	
}
//构建一个男人
class ManBuilder implements PersonBuilder{

	private Person_02 person;
	
	public ManBuilder() {
		person = new Person_02();
	}

	@Override
	public void buildBody() {
		person.setBody("男人的圣体");
	}

	@Override
	public void buildFoot() {
		person.setFoot("男人的脚");
	}

	@Override
	public void buildHead() {
		person.setHead("男人的头");
	}

	@Override
	public Person_02 buildPerson() {
		return person;
	}
	
}

//构建一个人
class  PersonDirector{
	
  public Person_02 constructPerson_02(PersonBuilder personBuilder) {
	  personBuilder.buildBody();
	  personBuilder.buildHead();
	  personBuilder.buildFoot();
	  return personBuilder.buildPerson();
  }
}


