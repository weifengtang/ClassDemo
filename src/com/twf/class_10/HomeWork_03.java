package com.twf.class_10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import jxl.Workbook;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 
 * 编写格式显示简历信息方法 
 * 请考虑其扩展性,如用简单文本输出,表格方式输出和Web 简历等形式,你将会怎么设计？

 * 
 * @author TWF
 *
 */
public class HomeWork_03 {

	public static void main(String[] args) {
		HomeWork_03 homeWork_03 = new HomeWork_03();
		Person person = new Person("",22d);
		person.setName("张三");
		person.setAge(20);
		person.setEmail("1184805995");
		homeWork_03.objectToText(person);
		homeWork_03.toExcel();
	}

	private void toExcel() {
		try {
			File file = new File("D://temp");
			if (!file.exists()) {
				file.mkdirs();
			}
			// 打开文件
			WritableWorkbook book = Workbook.createWorkbook(new File(file,"test.xls"));
			// 生成名为“sheet1”的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("sheet1", 0);
			// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0),单元格内容为string
			Label label = new Label(0, 0, "name");
			// 将定义好的单元格添加到工作表中
			sheet.addCell(label);
			Label label2 = new Label(0, 0, "age");
			// 将定义好的单元格添加到工作表中
			sheet.addCell(label2);
			// 生成一个保存数字的单元格,单元格位置是第二列，第一行，单元格的内容为1234.5
			Number number = new Number(1, 0,22);
			sheet.addCell(number);
			// 生成一个保存日期的单元格，单元格位置是第三列，第一行，单元格的内容为当前日期
			DateTime dtime = new DateTime(2, 0, new Date());
			sheet.addCell(dtime);
			// 写入数据并关闭文件
			book.write();
			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}


	// 格式化输出到文本
	private void objectToText(Person person) {
		BufferedWriter bWriter = null;

		File file = new File("D://temp");
		if (!file.exists()) {
			file.mkdirs();
		}
		try {
			bWriter = new BufferedWriter(new FileWriter(new File(file, "person.txt"), true));// 设置true 在不覆盖以前文件的基础上继续写
			bWriter.write("\r\n");
			bWriter.write(person.getName() + "的个人简历\r\n");
			bWriter.write("姓       名：" + person.getName() + "\r\n");
			bWriter.write("年       龄：" + person.getAge() + "\r\n");
			bWriter.write("邮箱地址：" + person.getEmail() + "\r\n");
			bWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
