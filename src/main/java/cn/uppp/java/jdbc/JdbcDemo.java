package cn.uppp.java.jdbc;

import java.sql.*;

/**
 * JDBC连接演示
 */
public abstract class JdbcDemo {
    public static void main(String[] args) {
        testJDBCConnection();
    }

    private static void testJDBCConnection() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 会将Driver实例反射到DriverManager中
            Class.forName("com.mysql.cj.jdbc.Driver");

            final String url = "jdbc:mysql://127.0.0.1:3306/crms?serverTimezone=Asia/Shanghai";
            final String username = "root";
            final String password = "123456";
            // 建立连接
            connection = DriverManager.getConnection(url, username, password);
            // 创建一个语句集
            statement = connection.createStatement();
            // 执行Sql语句
            final String sql = "select * from user";
            // 执行，并获取结果集
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
