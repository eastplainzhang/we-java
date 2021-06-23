# 1. 简介

## 1.1. Mybatis

获得Mybatis

maven仓库

```java
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.2</version>
</dependency>
```

Mybatis是持久层框架

中文文档：https://mybatis.org/mybatis-3/zh/index.html

## 1.2. 持久化

数据持久化

- 持久化就是将程序的数据从瞬时状态转化到持久转态
- 内存是断电即失的，有一些对象不愿意让其丢掉

## 1.3. 持久层

持久层就是完成持久化工作的代码块

层界限非常明显

## 1.4. 为什么需要Mybatis

- 操作方便
- JDBC代码太复杂

# 2. 第一个Mybatis程序

搭建环境-导入Mybatis-编写代码-测试

## 2.1. 搭建环境

### 2.1.1. 搭建数据库

```mysql
Create database `mybatis`;
use `mybatis`;

create table `user`(
  `id` 	int(20) not null primary key,
  `name` varchar(30) default null,
  `pwd` varchar(30) default null
)engine=innodb default charset=utf8;

`user`

insert into `user`(`id`, `name`, `pwd`) values 
(4, 'babe2', '123456')
```

### 2.1.2. IDEA环境搭建

- 创建一个maven项目
- 删除src目录
- 导入依赖

## 2.2. 创建模块

- 编写mybatis的核心配置文件

  ```xml
  <?xml version="1.0" encoding="UTF-8" ?>
  <!DOCTYPE configuration
          PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
          "http://mybatis.org/dtd/mybatis-3-config.dtd">
  <!--核心配置文件-->
  <configuration>
      <environments default="development">
          <environment id="development">
              <transactionManager type="JDBC"/>
              <dataSource type="POOLED">
                  <property name="driver" value="com.mysql.jdbc.Driver"/>
                  <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
                  <property name="username" value="root"/>
                  <property name="password" value="666999"/>
              </dataSource>
          </environment>
      </environments>
      <mappers>
          <mapper resource="org/mybatis/example/BlogMapper.xml"/>
      </mappers>
  </configuration>
  ```

- 编写mybatis工具类

  ```java
  package com.eastplain.utils;
  
  import org.apache.ibatis.io.Resources;
  import org.apache.ibatis.session.SqlSession;
  import org.apache.ibatis.session.SqlSessionFactory;
  import org.apache.ibatis.session.SqlSessionFactoryBuilder;
  
  import java.io.InputStream;
  
  /**
   * @author EastPlain
   * @create 2021-3-16 10:50
   */
  
  //sqlSessionFactory --> sqlSession  工厂模式
  public class MybatisUtils {
  
      private static SqlSessionFactory sqlSessionFactory;
  
      static {
          try {
              // 使用mybatis的第一步，获取SqlSessionFactory对象
              String resource = "mybatis-config.xml";
              InputStream inputStream = Resources.getResourceAsStream(resource);
              sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  
      // 既然有了，就可以从中获取SqlSession的实例了
      // SqlSession完全包含了面向数据库执行SQL命令所需的所有方法
      public static SqlSession getSqlSession() {
          return sqlSessionFactory.openSession();
      }
  }
  
  ```


## 2.3. 

- 实体类

  ```jav
  package com.eastplain.pojo;
  
  /**
   * @author EastPlain
   * @create 2021-3-16 11:04
   */
  public class User {
      private int id;
      private String name;
      private String pwd;
  
      public User() {
      }
  
      public User(int id, String name, String pwd) {
          this.id = id;
          this.name = name;
          this.pwd = pwd;
      }
  
      public int getId() {
          return id;
      }
  
      public void setId(int id) {
          this.id = id;
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public String getPwd() {
          return pwd;
      }
  
      public void setPwd(String pwd) {
          this.pwd = pwd;
      }
  }
  
  ```

- DAO接口

  ```java
  package com.eastplain.dao;
  
  import com.eastplain.pojo.User;
  
  import java.util.List;
  
  /**
   * @author EastPlain
   * @create 2021-3-16 11:08
   */
  public interface UserDao {
      List<User> getUserList();
  }
  
  ```

- 接口实现类

  ```xml
  <?xml version="1.0" encoding="UTF-8" ?>
  <!DOCTYPE mapper
          PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
          "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  
  <!--namespace 绑定一个对应的Dao/Mapper接口-->
  <mapper namespace="com.eastplain.dao.UserDao">
      <select id="getUserList" resultType="com.eastplain.pojo.User">
          select * from mybatis.user;
      </select>
  </mapper>
  ```


## 2.4. 测试

JUnit测试

## 2.5. 总结流程

1. 写核心配置文件

   mybatis-config.xml

   db.properties

2. 写工具类

   MybatisUtils.java

3. 写实体类

   User.java

4. 接口与实现的sql

   UserMapper.java

   UserMapper.xml

5. 测试类

   UserMapperTest.java

![](..\MyBaits\pic\屏幕截图 2021-03-17 200628.jpg)

## 2.6. 流程剖析

![](..\MyBaits\流程.png)

# 3. 增删改查

## 3.1. select

选择查找语句

- id  就是对应的namespace中的方法名
- resultType  sql语句执行的返回值
- parameterType  参数类型

1. 编写接口

   ```java
   // 根据id选择用户
       User getUserById(int id);
   ```

1. 编写对应的mapper中的sql语句

   ```xml
   <select id="getUserById" resultType="com.eastplain.pojo.User" parameterType="int">
       select * from mybatis.user where id = #{id}
   </select>
   ```

2. 测试

   ```java
   @Test
       public void getUserById() {
           SqlSession sqlSession = MybatisUtils.getSqlSession();
           UserMapper mapper = sqlSession.getMapper(UserMapper.class);
           User user = mapper.getUserById(1);
           System.out.println(user);
           sqlSession.close();
       }
   ```

   注意，增删改要提交事务

## 3.2. insert

```xml
<insert id="addUser" parameterType="com.eastplain.pojo.User">
    insert into mybatis.user (id, name, pwd) values (#{id}, #{name}, #{pwd});
</insert>
```

## 3.3. update

```xml
<update id="updateUser" parameterType="com.eastplain.pojo.User">
    update mybatis.user set name = #{name}, pwd = #{pwd} where id = #{id};
</update>
```

## 3.4. delete

```xml
<delete id="deleteUser">
    delete from mybatis.user where id = #{id};
</delete>
```

## 3.5. Map

加入实体类或者数据库中的表字段或者参数过多，考虑使用map

```xml
<insert id="addUser_map" parameterType="map">
    insert into mybatis.user(id, name, pwd) values (#{userId}, #{userName}, #{userPwd});
</insert>
```

map传递参数，直接在sql中取出key即可  【parameterType="map"】

对象传递参数，直接在sql中取出对象的属性即可  【parameterType="某个Object"】

只有一个基本类型时，可以直接在sql中取到

多个参数用map，或者是注解

## 3.6. 模糊查询

在Java代码中，传递通配符%

```java
List<User> UserList = mapper.getUserLike("%cute%");
```

或者，在sql代码中，传递通配符%

```xml
<select id="getUserLike" resultType="com.eastplain.pojo.User">
    select * from mybatis.user where name like "%"#{value}"%"
</select>
```

# 4. 配置解析

## 4.1. 核心配置文件

mybatis-config.xml

![](..\MyBaits\pic\屏幕截图 2021-03-17 112538.jpg)

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
    <environments default="development">  
        <!--mybatis可以配置多种环境，但是每个SqlSessionFactory实例只能选择一个环境-->
        <environment id="development"
            <transactionManager type="JDBC"/>
            <!--mybatis中有两种事务管理器 JDBC(默认) MANAGED -->
            <dataSource type="POOLED">
            <!--数据源dbcp c3p0 druid等，用于连接数据库 连接池实现类型UNPOOLED POOLED(默认) UNDI-->
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
                <property name="username" value="root"/>
                <property name="password" value="666999"/>
            </dataSource>
        </environment>
        <environment id="development"
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
                <property name="username" value="root"/>
                <property name="password" value="666999"/>
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <mapper resource="com/eastplain/dao/UserMapper.xml"/>
    </mappers>
</configuration>
```

## 4.2. 环境配置environments

mybatis可以配置多种环境，但是每个SqlSessionFactory实例只能选择一个环境

mybatis默认的事务管理器是JDBC，默认连接池类型POOLED

## 4.3. 属性properties

properties在配置文件中排第一 

可以用过属性来实现引用配置文件

这些属性都是可外部配置且动态替换的，既可以在典型的java配置文件(db.properties)中配置，也可通过properties元素的子元素来传递

1. 编写一个配置文件db.properties

   ```properties
   driver = com.mysql.cj.jdbc.Driver
   url = jdbc:mysql://localhost:3306/mybatis?useSSL=false&useUnicode=true&characterEncoding=UTF-8  # 不需要amp；转义
   username = root
   password = 666999
   ```

2. 在核心配置文件中引入

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE configuration
           PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-config.dtd">
   
   <configuration>
       <!--在核心配置文件中引入外部properties，只能写在最上方-->
       <properties resource="db.properties"/>
   
       <environments default="development">
           <environment id="development">
               <transactionManager type="JDBC"/>
               <dataSource type="POOLED">
                   <property name="driver" value="${driver}"/>
                   <property name="url" value="${url}"/>
                   <property name="username" value="${username}"/>
                   <property name="password" value="${password}"/>
               </dataSource>
           </environment>
       </environments>
   
       <mappers>
           <mapper resource="com/eastplain/dao/UserMapper.xml"/>
       </mappers>
   </configuration>
   ```

3. 可以在其中增加一些配置，但是优先级低于外部配置文件，优先使用外部配置文件

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE configuration
           PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-config.dtd">
   
   <configuration>
       <!--在核心配置文件中引入外部properties，只能写在最上方-->
       <properties resource="db.properties">
           <property name="password" value="1234565"/>
       </properties>
   
       <environments default="development">
           <environment id="development">
               <transactionManager type="JDBC"/>
               <dataSource type="POOLED">
                   <property name="driver" value="${driver}"/>
                   <property name="url" value="${url}"/>
                   <property name="username" value="${username}"/>
                   <property name="password" value="${password}"/>
               </dataSource>
           </environment>
       </environments>
   
       <mappers>
           <mapper resource="com/eastplain/dao/UserMapper.xml"/>
       </mappers>
   </configuration>
   ```

## 4.4. 设置settings

typeAlias在配置文件中排第二

## 4.5. 别名typeAlias

typeAlias在配置文件中排第三

![](..\MyBaits\pic\屏幕截图 2021-03-17 121311.jpg)

```xml
<typeAliases>
    <!--第一种方式 给实体类起别名-->
    <typeAlias type="com.eastplain.pojo.User" alias="User"/>
    <!--第二种方式 扫描实体类的包，类的默认别名为这个类的类名，首字母小写-->
    <package name="com.eastplain.pojo"/>
</typeAliases>
```

## 4.6. 其他配置

typeHandlers  类型处理器

objectFactory  对象工厂

plugins  插件

​    mybatis-plus

## 4.7. 映射器mappers

MapperRegistry  注册绑定我们得mapper文件

![](..\MyBaits\pic\屏幕截图 2021-03-17 182616.jpg)

方式一：

```xml
<mappers>
    <mapper resource="com/eastplain/dao/UserMapper.xml"/>
</mappers>
```

方式二：使用class文件绑定注册

```xml
<mappers>
    <mapper class="com.eastplain.dao.UserMapper"/>
</mappers>
```

注意点：接口和他的Mapper配置文件必须同名，必须在同一个包下

方式三：使用包扫描进行注入绑定

```xml
<mappers>
    <package name="com.eastplain.dao"/>
</mappers>
```

注意点：必须同名，必须在同一个包下

## 4.8. 总结

- 将数据库配置文件外部引入
- 实体类别名
- 保证UserMapper接口和UserMapper.xml同名并在同一个包下

## 4.9. 生命周期和作用域

生命周期和作用域至关重要，错误地使用会导致并发问题

![](..\MyBaits\2.png)



![](..\MyBaits\1.png)

# 5. resultMap

## 5.1. 问题

解决属性名和字段名不一致的问题

```java
public class User {
    private int id;
    private String name;
    private String password;
}
```

测试出现问题，结果：**User{id=1, name='nancy', password='null'}**

解决方法

1. 起别名

   ```xml
   <select id="getUserById" resultType="com.eastplain.pojo.User" parameterType="int">
       select id, name, pwd as password from mybatis.user where id = #{id}
   </select>
   ```

2. ResultMap

## 5.2. resultMap的简单使用

结果集映射

字段名  id  name  pwd

属性名  id  name  password

```xml
<mapper namespace="com.eastplain.dao.UserMapper">

    <!--resultMap标签-->
    <!--结果集映射-->
    <resultMap id="UserMap" type="User">
        <!--column是数据库中的字段 property是实体类中的属性-->
        <!--<result column="id" property="id"/>-->
        <!--<result column="name" property="name"/>-->
        <result column="pwd" property="password"/>
    </resultMap>

    <select id="getUserById" resultMap="UserMap" parameterType="int">
        select * from mybatis.user where id = #{id}
    </select>

</mapper>
```

resultMap的设计思想：对于简单的语句根本不需要配置显式的结果映射，对于复杂一点的语句只需要描述他们的关系就可以了

# 6. 日志

## 6.1. 日志工厂

如果一个数据库操作出现了异常，日志是排错的好助手

Mybatis 通过使用内置的日志工厂提供日志功能。内置日志工厂将会把日志工作委托给下面的实现之一：

logImpl              

- SLF4J        
-  Apache Commons Logging      
- STDOUT_LOGGING  
- LOG4J2        
- LOG4J       
- JDK logging        

在核心配置的settings中配置标准日志工厂STDOUT_LOGGING 

```xml
<settings>
    <setting name="logImpl" value="STDOUT_LOGGING"/>
</settings>
```

STDOUT_LOGGING的输出

```latex
Opening JDBC Connection
Created connection 1325056130.
Setting autocommit to false on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@4efac082]
==>  Preparing: select * from mybatis.user where id = ? 
==> Parameters: 1(Integer)
<==    Columns: id, name, pwd
<==        Row: 1, nancy, 123456
<==      Total: 1
User{id=1, name='nancy', password='123456'}
Resetting autocommit to true on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@4efac082]
Closing JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@4efac082]
Returned connection 1325056130 to pool.

Process finished with exit code 0
```

## 6.2. LOG4J

- Log4j是[Apache](https://baike.baidu.com/item/Apache/8512995)的一个开源项目，通过使用Log4j，我们可以控制日志信息输送的目的地是[控制台](https://baike.baidu.com/item/控制台/2438626)、文件、[GUI](https://baike.baidu.com/item/GUI)组件
- 可以控制每一条日志的输出格式
- 通过定义每一条日志信息的级别，我们能够更加细致地控制日志的生成过程
- 可以通过一个[配置文件](https://baike.baidu.com/item/配置文件/286550)来灵活地进行配置，而不需要修改应用的代码

使用LOG4J

1. 先导入LOG4J的包

   ```xml
   <dependency>
       <groupId>log4j</groupId>
       <artifactId>log4j</artifactId>
       <version>1.2.17</version>
   </dependency>
   ```

2. log4j.properties

   ```properties
   #将等级为DEBUG的日志信息输出到console和file这两个目的地，console和file的定义在下面的代码
   log4j.rootLogger=DEBUG, console, file
   
   #控制台输出的相关设置
   log4j.appender.console = org.apache.log4j.ConsoleAppender
   log4j.appender.console.Target = System.out
   log4j.appender.console.Threshold = Debug
   log4j.appender.console.layout = org.apache.log4j.PatternLayout
   log4j.appender.console.layout.ConversionPattern = [%c]-%m%n
   
   #文件输出的相关设置
   log4j.appender.file = org.apache.log4j.RollingFileAppender
   log4j.appender.file.File = ./log/eastplain.log
   log4j.appender.file.MaxFileSize = 10mb
   log4j.appender.file.Threshold = DEBUG
   log4j.appender.file.layout = org.apache.log4j.PatternLayout
   log4j.appender.file.layout.ConversionPattern = [%p][%d{yy-mm-dd}][%c]%m%n
   
   #日志输出级别
   log4j.logger.org.mybatis = DEBUG
   log4j.logger.java.sql = DEBUG
   log4j.logger.java.sql.Statement = DEBUG
   log4j.logger.java.sql.ResultSet = DEBUG
   log4j.logger.java.sql.PreparedStatement = DEBUG
   ```

3. 配置log4j为日志的实现

   ```xml
   <settings>
       <setting name="logImpl" value="LOG4J"/>
   </settings>
   ```

4. log4j的使用

   ```java
   // 导入包
   import org.apache.log4j.Logger;
   
   // 
   static Logger logger = Logger.getLogger(UserMapper.class);
   
   //
   @Test
   public void testLOG4J() {
       logger.info("info: 进入了testLOG4J");
       logger.debug("debug: 进入了testLOG4J");
       logger.error("error: 进入了testLOG4J");
   }
   ```

# 7. 分页

减少数据的处理量

```mysql
SELECT * FROM TABLE LIMET START_INDEX, PAGE_SIZE;
```

使用mybatis实现分页

实现类

```java
public interface UserMapper {

    // 根据id选择用户
    User getUserById(int id);

    // 分页查询
    List<User> getUserByLimit(Map<String, Integer> map);
}
```

Mapper映射

```xml
<select id="getUserByLimit" parameterType="map" resultMap="UserMap">
    select * from mybatis.user limit #{startIndex}, #{pageSize}
</select>
```

测试类

```java
@Test
    public void getUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);
        List<User> list = mapper.getUserByLimit(map);
        for (User user : list) {
            System.out.println(user);
        }

        sqlSession.close();
    }
```

# 8. 使用注解开发

## 8.1. 面向接口编程

**解耦**

**接口与实现的分离**

## 8.2. 使用注解开发

1. 注解在接口上实现

   ```java
   public interface UserMapper {
   
       @Select("select id, name, pwd as password from user")
       List<User> getUsers();
   }
   ```

2. 需要在核心配置文件中绑定接口

   ```xml
   <mappers>
       <mapper class="com.eastplain.dao.UserMapper"/>
   </mappers>
   ```

注解的本质：反射机制

注解的底层：动态代理

## 8.3. 使用注解完成CRUD

可以在工具类创建的时候实现自动提交事务

```java
public static SqlSession getSqlSession() {
    return sqlSessionFactory.openSession(true);
}
```

编写接口，增加注解

```java
package com.eastplain.dao;

import com.eastplain.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author EastPlain
 * @create 2021-3-16 11:08
 */
public interface UserMapper {

    @Select("select id, name, pwd as password from user")
    List<User> getUsers();

    // 方法存在多个参数时，所有参数之前必须加@Param注解
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user (id, name, pwd) values (#{id}, #{name}, #{password})")
    int addUser(User user);
}

```

注意：

必须要将接口注册绑定到核心配置文件中

```xml
<mappers>
    <mapper class="com.eastplain.dao.UserMapper"/>
</mappers>
```

## 8.4. @Param()注解

- 基本类型的参数和String类型的参数，需要加上
- 引用类型不用加
- 如果只有一个基本类型的话，可以忽略，但是建议加上
- 我们在SQL中引用的就是在@Param("uid")中设定的属性名

# 9.Lombok

使用步骤

1. 安装Lombok

   直接在IDEA中安装

2. 导入Lombok的jar包

   ```xml
   <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
   <dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
       <version>1.18.10</version>
   </dependency>
   ```

@Data

无参构造器，get，set，equals，toString

```java
@Data
public class User {
    
    private int id;
    private String name;
    private String password;
    
}
```

偷懒神器

# 10. 多对一处理

## 10.1. 创建数据库：

```sql
USE mybatis

CREATE TABLE `teacher` (
  `id` INT(10) NOT NULL,
  `name` VARCHAR(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

INSERT INTO teacher(`id`, `name`) VALUES (1, '秦老师'); 

CREATE TABLE `student` (
  `id` INT(10) NOT NULL,
  `name` VARCHAR(30) DEFAULT NULL,
  `tid` INT(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fktid` (`tid`),
  CONSTRAINT `fktid` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

INSERT INTO `student` (`id`, `name`, `tid`) VALUES ('1', '小明', '1'); 
INSERT INTO `student` (`id`, `name`, `tid`) VALUES ('2', '小红', '1'); 
INSERT INTO `student` (`id`, `name`, `tid`) VALUES ('3', '小张', '1'); 
INSERT INTO `student` (`id`, `name`, `tid`) VALUES ('4', '小李', '1'); 
INSERT INTO `student` (`id`, `name`, `tid`) VALUES ('5', '小王', '1');
```

## 10.2. 测试环境搭建：

1、新建实体类Teacher，Student

2、建立Mapper接口

3、建立Mapper.xml

4、在核心配置文件中绑定注册我们的Mapper接口或文件

5、测试查询是否成功

## 10.3. 按照查询嵌套处理

```xml
<select id="getStudent" resultMap="StudentTeacher">
    select * from student;
</select>
<resultMap id="StudentTeacher" type="Student">
    <association property="teacher" column="tid" javaType="Teacher" select="getTeacher"/>
</resultMap>
<select id="getTeacher" resultType="Teacher">
    select * from teacher where id = #{id}
</select>
```

## 10.4. 按照结果嵌套处理

```xml
<!--联表查询方式，按照结果嵌套处理-->
<select id="getStudent2" resultMap="StudentTeacher2">
    select s.id as sid, s.name as sname, t.name as tname
    from student as s, teacher as t
    where s.tid = t.id
</select>
<resultMap id="StudentTeacher2" type="Student">
    <result property="id" column="sid"/>
    <result property="name" column="sname"/>
    <association property="teacher" javaType="Teacher">
        <result property="name" column="tname"/>
    </association>
</resultMap>
```

# 11. 一对多处理

## 11.1. 创建环境

 实体类：

```java
public class Student {
    private int id;
    private String name;
    
    private int tid;
    //......
}
```

```java
public class Teacher {
    private int id;
    private String name;
    private List<Student> students;
    //......
}
```

## 11.2. 按照结果嵌套处理

```xml
<select id="getTeacher2" resultMap="TeacherStudent">
    select s.id sid, s.name sname, t.name tname, t.id tid
    from student s, teacher t
    where s.tid = t.id and t.id = #{tid}
</select>
<resultMap id="TeacherStudent" type="Teacher">
    <result property="id" column="tid"/>
    <result property="name" column="tname"/>
    <collection property="students" ofType="Student">
        <result property="id" column="sid"/>
        <result property="name" column="sname"/>
        <result property="tid" column="tid"/>
    </collection>
</resultMap>
```



## 11.3. 按照查询嵌套处理

```xml
<select id="getTeacher3" resultMap="TeacherStudent2">
    select * from teacher where id = #{tid}
</select>
<resultMap id="TeacherStudent2" type="Teacher">
    <collection property="students" javaType="ArrayList" ofType="Student" select="getStudentByTeacherId" column="id"/>
</resultMap>
<select id="getStudentByTeacherId" resultType="Student">
    select * from student where tid = #{tid}
</select>
```

# 12. 动态SQL

**动态SQL**

**根据不同的条件生成不同的SQL语句**

## 12.1. 搭建环境

```mysql
CREATE TABLE `blog`(
`id` VARCHAR(50) NOT NULL COMMENT '博客id',
`title` VARCHAR(100) NOT NULL COMMENT '博客标题',
`author` VARCHAR(30) NOT NULL COMMENT '博客作者',
`create_time` DATETIME NOT NULL COMMENT '创建时间',
`views` INT(30) NOT NULL COMMENT '浏览量'
)ENGINE=INNODB DEFAULT CHARSET=utf8
```

创建基础工程

导包

编写配置文件

编写实体类

```java
public class Blog {
    private int id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
```

编写实体类对应Mapper接口和Mapper.xml文件

## 12.2. IF

```xml
<select id="queryBlogIF" parameterType="map" resultType="blog">
    select * from mybatis.blog where 1 = 1
    <if test="title != null">
        and title = #{title}
    </if>
    <if test="author != null">
        and author = #{author}
    </if>
</select>
```

























