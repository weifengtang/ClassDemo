package com.twf.class_28_jdbc_02;

import com.twf.class_28_jdbc_02.jdbcUtils.JDBCUtils_02;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @ClassName:ClassDemo_03
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/208:48
 * @Version:1.0
 *
 * jDBC调用存储过程
 **/
public class ClassDemo_03 {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils_02.getConnection();
//        String sql = "insert into student" +
//                "(studentid,studentName,Classid,Address,sex,Birthday)" +
//                "value(22,'刘星光',2,'江西南昌','男','1978-08-08')";
//
        String sql = "{CALL add_p(?,?,?)}";
        // 调用存储过程
         CallableStatement cstm = connection.prepareCall(sql);     // 实例化对象
         cstm.setInt(1, 111);
         cstm.setInt(2, 222);
         cstm.registerOutParameter(3, Types.INTEGER);//设置返回 值类型
         cstm.execute(); // 执行存储过程

         System.out.println(cstm.getInt(3)); // 取得存储过程的返回值

         JDBCUtils_02.realse(connection,cstm,null);
    }
}
