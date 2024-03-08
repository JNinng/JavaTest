package top.ninng.data.database;

import java.sql.*;

/**
 * @Author OhmLaw
 * @Date 2024/2/23 13:17
 * @Version 1.0
 */
public class JDBC {

    public static void main(String[] args) {
        Connection connection;
        Statement statement = null;
        PreparedStatement updateStatement = null, preparedStatement = null;
        ResultSet resultSet = null, resultSet2 = null;
        // 1. 驱动包，注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 2. 获取数据库连接
        connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/spring?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT",
                    "root", "root");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //  3. 操作数据库
        String selectSql = "SELECT * FROM account WHERE balance >= -10000";
        // 执行 sql
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id") + "  ");
                System.out.print(resultSet.getString("username") + "  ");
                System.out.println(resultSet.getDouble("balance"));
            }

            System.out.println("====");

            int balance = 1001;
            String updateSql = "update account SET balance = ? WHERE id >= ?";
            updateStatement = connection.prepareStatement(updateSql);
            updateStatement.setDouble(1, balance * 1.2);
            updateStatement.setInt(2, 3);

            // 关闭自动提交，准备事务
            connection.setAutoCommit(false);
            System.out.println(updateStatement.executeUpdate());
            // 提交事务
//            int i = 1 / 0;
            connection.commit();

            System.out.println("====");

            String selectSqlStatement = "SELECT * FROM account";
            preparedStatement = connection.prepareStatement(selectSqlStatement);
            resultSet2 = preparedStatement.executeQuery();
            while (resultSet2.next()) {
                System.out.print(resultSet2.getInt("id") + "  ");
                System.out.print(resultSet2.getString("username") + "  ");
                System.out.println(resultSet2.getDouble("balance"));
            }

        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (resultSet2 != null) {
                    resultSet2.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (statement != null) {
                    statement.cancel();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (updateStatement != null) {
                    updateStatement.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
