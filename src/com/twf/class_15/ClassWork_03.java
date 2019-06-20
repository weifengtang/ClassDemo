package com.twf.class_15;




import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 
 * 
 * 现有一个接口MyDateTime 取得日期的字符串,
 * public String getDate() ; 2009-12-22 取得日期时间的字符串
 * public String getDateTime() ; //2009-12-22 11:06:23.345
 * 
 * 要求用两种方式实现 •实现一：基于Calendar类 •实现二：基于SimpleDateFormat类
 * 
 * @Classname:ClassWork_03
 * @author TWF
 * @Date:2019年5月31日下午5:09:35
 * @version 1.0
 */
public class ClassWork_03 implements MyDateTime {
	Calendar calendar = null;

	public static void main(String[] args) {
		ClassWork_03 work = new ClassWork_03();

		String dateTime = work.getDateTime();
		String dateTime2 = work.getDate();

		System.out.println(dateTime);
		System.out.println(dateTime2);
	}

	// •实现一：基于Calendar类 2009-12-22
	@Override
	public String getDate() {
		calendar = Calendar.getInstance();
		// 获取年
		int year = calendar.get(Calendar.YEAR);

		// 获取月，这里需要需要月份的范围为0~11，因此获取月份的时候需要+1才是当前月份值
		int month = calendar.get(Calendar.MONTH) + 1;

		// 获取日
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		// 获取时
		// int hour = calendar.get(Calendar.HOUR);
		int hour = calendar.get(Calendar.HOUR_OF_DAY); // 24小时表示

		// 获取分
		int minute = calendar.get(Calendar.MINUTE);

		// 获取秒
		int second = calendar.get(Calendar.SECOND);

		// 星期，英语国家星期从星期日开始计算
		int weekday = calendar.get(Calendar.DAY_OF_WEEK) - 1;

		return year + "年" + month + "月" + day + "日" + hour + "时" + minute + "分" + second + "秒" + "星期" + weekday;
	}

	// 实现二：基于SimpleDateFormat类2009-12-22 11:06:23.345
	@Override
	public String getDateTime() {
		Date nowDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return simpleDateFormat.format(nowDate);
	}

	@Before
	public void test() {
		calendar = Calendar.getInstance();
	}

	// 基本用法，获取年月日时分秒星期
	@Test
	public void test1() {
		// 获取年
		int year = calendar.get(Calendar.YEAR);

		// 获取月，这里需要需要月份的范围为0~11，因此获取月份的时候需要+1才是当前月份值
		int month = calendar.get(Calendar.MONTH) + 1;

		// 获取日
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		// 获取时
		int hour = calendar.get(Calendar.HOUR);
		// int hour = calendar.get(Calendar.HOUR_OF_DAY); // 24小时表示

		// 获取分
		int minute = calendar.get(Calendar.MINUTE);

		// 获取秒
		int second = calendar.get(Calendar.SECOND);

		// 星期，英语国家星期从星期日开始计算
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);

		System.out.println("现在是" + year + "年" + month + "月" + day + "日" + hour + "时" + minute + "分" + second + "秒"
				+ "星期" + weekday);
	}

	// 一年后的今天
	@Test
	public void test2() {
		// 同理换成下个月的今天calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.YEAR, 1);

		// 获取年
		int year = calendar.get(Calendar.YEAR);

		// 获取月
		int month = calendar.get(Calendar.MONTH) + 1;

		// 获取日
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		System.out.println("一年后的今天：" + year + "年" + month + "月" + day + "日");
	}

	// 获取任意一个月的最后一天
	@Test
	public void test3() {
		// 假设求6月的最后一天
		int currentMonth = 6;
		// 先求出7月份的第一天，实际中这里6为外部传递进来的currentMonth变量
		// 1
		calendar.set(calendar.get(Calendar.YEAR), currentMonth, 1);

		calendar.add(Calendar.DATE, -1);

		// 获取日
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		System.out.println("6月份的最后一天为" + day + "号");
	}

	// 设置日期
	@Test
	public void test4() {
		calendar.set(Calendar.YEAR, 2000);
		System.out.println("现在是" + calendar.get(Calendar.YEAR) + "年");

		calendar.set(2008, 8, 8);
		// 获取年
		int year = calendar.get(Calendar.YEAR);

		// 获取月
		int month = calendar.get(Calendar.MONTH);

		// 获取日
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		System.out.println("现在是" + year + "年" + month + "月" + day + "日");
	}
}

interface MyDateTime {
	public abstract String getDate();// 2009-12-22 取得日期时间的字符串

	public abstract String getDateTime(); // 2009-12-22 11:06:23.345
}
