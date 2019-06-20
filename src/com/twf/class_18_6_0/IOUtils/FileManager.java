package com.twf.class_18_6_0.IOUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName:FileManager
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/515:28
 * @Version:1.0
 **/
public class FileManager {


    //读取文件得到List
    public  List<String> getList(String  fileName){
        String  list  = IOUtils.readDatas(fileName);
        String strings[] = list.split(";");
        List<String> lists = Arrays.asList(strings);
        lists= new ArrayList<String>(lists);
        sort(lists);
        return  lists;
    }
    //对列表数据进行排序
    public  void sort( List<String> datas){
        int length =datas.size();
        for (int i = 0; i < length; i++) {//循环次数
            int key = Integer.parseInt(getString(datas.get(i),"Socre"));
            int position=i;
            for (int j = i + 1; j < length; j++) {//选出最小的值和位置
                int b = Integer.parseInt(getString(datas.get(j),"Socre"));
                if (b > key) {
                    key = b;
                    position = j;
                }
            }
            Collections.swap(datas, position, i);//交换位置
        }
    }
    //得到每一个元素 Rank{date='2019-06-04 06:49:31', userName='twf', Socre='3'}
    public  String getString(String str,String nameString){
        int start = str.indexOf(nameString+"='")+nameString.length()+2;
        int end = str.indexOf("'",start);
        return str.substring(start,end);
    }
    //生成列表数据
    public  Object[][] getDatas(String fileName){
        List<String> lists = getList(fileName);
        Object[][] datas = new Object[lists.size()][3];
        for (int i = 0;i<lists.size();i++){
            datas[i][0]=getString(lists.get(i),"date");;
            datas[i][1]=getString(lists.get(i),"userName");;
            datas[i][2]=getString(lists.get(i),"Socre");;
        }
        return datas;
    }



}
