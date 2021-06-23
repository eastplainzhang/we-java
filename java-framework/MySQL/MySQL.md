# 7. 索引

索引（**Index**）是帮助M有SQL高效获取数据的数据结构

## 7.1. 索引的分类

1. 主键索引  PRIMARY KEY

   唯一的标识，不可重复，只能有一个列作为主键

2. 唯一索引  UNIQUE KEY

   避免重复的列出现

   索引可以重复，多个列都可以标识为唯一索引

3. 常规索引  KEY/INDEX

   默认情况下不填，就是常规索引

4. 全文索引  FullText

   快速定位数据

## 7.2. 索引的使用

在创建表的时候，给字段增加索引

在创建表完毕后，增加索引

```mysql
/*
显示所有的索引
*/
SHOW INDEX FROM 表名;

/*
添加索引
*/
ALTER TABLE 表名 ADD FULLTEXT INDEX 列名;
```

## 7.3. 索引的原则

1. 索引不是越多越好
2. 不要对经常变动的数据加索引
3. 小数据量的表不需要加索引
4. 索引一般加在经常查询的字段上

## 7.3. 索引的数据结构

InnoDB的默认数据就够：B树

# 8. JDBC

Java开发人员对数据库的操作的统一规范

对于Java开发人员来说，只需要掌握JDBC的接口的操作即可

java.sql

javax.sql

还需要导入数据库驱动包  mysql-connector-java-5.1.47.jar

## 8.1. DEMO

```java
package com.eastplain.lesson;

import java.sql.*;

/**
 * @author EastPlain
 * @create 2021-3-02 21:14
 */
public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 用户信息和url
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password = "666999";

        // 3. 连接成功，数据库对象  connection就代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        // 4. 执行SQL对象
        Statement statement = connection.createStatement();

        // 5. 执行SQL对象去执行SQL
        String sql = "SELECT * FROM `users`";
        ResultSet resultSet = statement.executeQuery(sql);  // 返回的结果集
        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("NAME"));
            System.out.println("password=" + resultSet.getObject("PASSWORD"));
            System.out.println("email=" + resultSet.getObject("email"));
            System.out.println("birthday=" + resultSet.getObject("birthday"));
            System.out.println("------");
        }

        // 6. 关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
```

## 8.2. 数据库连接池

池化技术：准备一些预先的资源，过来就连接预先准备好的

由于数据库连接-执行完毕-释放的过程非常浪费资源

编写连接池，实现一个接口DataSource

开源数据源实现  DBCP  C3P0  Druid  使用这些数据库连接池之后，在项目开发中就不需要编写连接数据库的代码了





