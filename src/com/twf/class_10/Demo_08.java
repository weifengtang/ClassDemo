package com.twf.class_10;

/**
 * 
 * 
 * 不推荐 在接口中：写方法实现
 * @author TWF
 *
 */
public class Demo_08 {

	public static void main(String[] args) {
		ImplInterface.ts.methodTS();// 调用接口的实现

	}

}

//被实现的接口
interface ITest {
	public void methodTS();
}

//在接口中存在实现代码 
interface ImplInterface {
	public static final ITest ts = new ITest() {//匿名类
		public void methodTS() {
			System.out.println("我在接口中实现了");
		}
 	};
}