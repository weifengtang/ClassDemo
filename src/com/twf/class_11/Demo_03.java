package com.twf.class_11;
/**
 * 
 * 适配器模式
 * @author TWF
 *
 */
public class Demo_03 {

	public static void main(String[] args) {
		ComputerImpl computerImpl = new ComputerImpl();
		computerImpl.play("-");
	}

}

//定义电脑接口，操作
interface Computer{
	abstract void play(String nameString);
	abstract void play2();	
}

//定义抽象类实现接口，在此类中重写方法，但是所有的方法体为空
abstract class ComputerAdapter implements Computer{

	@Override
	public void play2() {}
	@Override
	public void play(String nameString) {}

}

// 子类直接继承WindowAdapter类，有选择的实现需要的方法
class ComputerImpl extends ComputerAdapter{
	@Override
	public void play(String nameString) {
		System.out.println("计算机电源适配器"+nameString);
	}
	
}


