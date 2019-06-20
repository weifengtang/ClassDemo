package com.twf.class_15;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

/**
 * 
 *@Classname:ClassWork_01 
 *@author TWF
 *@Date:2019年5月31日下午3:57:57
 *@version 1.0
 *
 *编写一个银行卡号逻辑处理方法，
 *银行卡号只能由 12到21个0至9的数字组成，密码只能有6位,
 *每一 位也是有0-9的数字组成，
 *任何不符合帐户名和密 码要求的情况都视为异常，必须捕获并处理异常
 *
 */

public class ClassWork_01 {

	
	
	public static void main(String[] args) {
		String  bank ="223456123411111566" ;
		String  pwd = "223562";
		new ClassWork_01().fun(bank,pwd);



	}
	public  void fun(String  bank,String  pwd) {

		String regex_bank = "^[0-9]{12,21}$";
		String regex_pwd = "^[0-9]{6}$";
		Pattern pattern = Pattern.compile(regex_bank);
		Pattern pattern2 = Pattern.compile(regex_pwd);
		try {
			if(!pattern.matcher(bank).find()||!pattern2.matcher(pwd).find()) {//如果不匹配
				throw new RuntimeException();
			}
			System.out.println("账号匹配");
		}catch (Exception e) {
			System.out.println("不符合帐户名和密 码要求的情况都视为异");
		}
	}

}
