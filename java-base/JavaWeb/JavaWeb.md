# 1. JavaWeb的基本概念

静态web：

提供给所有人看的数据始终不会变化

html  css  txt  jpg

动态web：

提供给所有人看的数据会有变化，每个人在不同的时间看到的信息不同

Servlet/JSP  PHP

在Java中，动态web资源开发的技术称为JavaWeb

JavaWeb是基于请求和响应开发的

请求：客户端给服务器发送数据 Request

响应：服务器给客户端回传数据 Response

请求和响应成对出现

常用的web服务器：TomCat，提供对jsp和Servlet的支持

## 1.1. web应用程序

可以提供浏览器访问的程序

多个web资源[.html]可以被外界访问

# 2. TomCat

bin目录下存放TomCat的可执行程序

conf目录下存放TomCat的配置文件

lib目录下存放TomCat的jar包

webapps目录下存放部署的Web工程

work是TomCat的工作目录

## 2.1. 启动TomCat服务器

方式一：

TomCat/bin/startup.bat  双击启动

在浏览器中  https://localhost:8080

方式二：

打开命令行

cd到TomCat的bin目录下

catalina run

## 2.2. 停止TomCat服务器

方式一：

TomCat/bin/shutdown.bat  双击启动

## 2.3. 修改TomCat的默认端口号

TomCat/conf/server.xml  Connector的port属性

## 2.4. 把Web工程部署到TomCat

方式一：

把web工程的目录拷贝到TomCat的webapps目录下

1. webapps目录下新建book_test01文件夹

2. 把web工程拷贝到book_test01文件夹中
3. 访问工程，localhost:8080/book_test01

方式二：

1. conf/Catalina/localhost下创建xml文件
2. 写入<Context path="book_test02" docBase="F:\IDEA\JavaWeb\05_book_static" />

## 2.5. IDEA整合TomCat

https://blog.csdn.net/jimanglai/article/details/109284411

我们访问一个网站，需要指定一个文件夹的名字

## 2.6. 发布一个网站

将自己写的网站放到TomCat的webapps文件夹下，就可以访问这个网站了

--webapps

​        --bookstore  网站的目录名

​                --WEB-INF  放网站程序的文件夹

​                        --classes  Java程序

​                        --lib  web应用所依赖的jar包

​                        --web.xml  网站配置文件

​                --index.html或index.jsp  默认的首页

​                --static

​                        --css

​                        --js

​                        --img

# 3. Http

Http（超文本传输协议）是一个请求-响应协议，通常运行tcp之上。

默认端口80

Https  安全的  默认端口43

## 3.1. Http请求

客户端--发请求（Request）--服务器

### 3.1.1. 请求行

请求方式：**Get**和**Post**

Get  高效，不安全

Post  安全，不高效

## 3.2. Http响应

服务器--响应Reponse--客户端

# 4. Maven

JavaWeb中需要导入大量的jar包

自动地导入和配置jar包的工具——Maven

Maven就是一个工具，项目架构管理工具

Maven核心思想：约定大于配置，有约束，不能违反。Maven会规定如何编写Java

## 4.1. Maven安装

必须要配置环境

建议使用阿里云镜像

## 4.2. Maven本地仓库

建立本地仓库

## 4.3. 在IDEA中使用Maven

IDEA默认使用自带的Maven，我们每次用的时候要手动改Maven配置

![image-20210301145926315](..\images\image-20210301145926315.png)

一个纯净的Maven项目

main.java  放Java源代码

main.resources  放配置文件

test.java  放测试代码

![image-20210301151239883](..\images\image-20210301151239883.png)

## 4.4. pom文件

pom.xml是Maven的核心配置文件

方式一：使用Maven模板

```xml
<?xml version="1.0" encoding="UTF-8"?>

<!-- Maven版本和头文件 -->
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <!-- 配置的GAV -->
  <groupId>com.eastplain</groupId>
  <artifactId>javaweb-01-maven</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>war</packaging>
  <!-- Package 项目的打包方式
   jar:  java应用
   war:  java web应用
   -->

  <name>javaweb-01-maven Maven Webapp</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  <!-- 配置 -->
  <properties>
    <!-- 项目的默认构建编码 -->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <!-- 编码版本 -->
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>

  <!-- 项目依赖 -->
  <dependencies>
  <!-- 具体依赖的jar包配置文件 -->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <!-- 项目构建用的东西 -->
  <build>
    <finalName>javaweb-01-maven</finalName>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-war-plugin</artifactId>
          <version>3.2.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
</project>

```

方式二：从一个纯净的Maven手动创建

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>javaweb-02-maven-pure</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <!-- 具体依赖的jar包配置文件 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.11</version>
            <scope>test</scope>
        </dependency>

        <!-- Maven的高级之处在于，会帮你导入这个jar所依赖的其他jar包 -->
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.3.4</version>
        </dependency>
    </dependencies>

    <!--在build中配置resources,来防止我们资源导出失败的问题-->
    <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>

</project>
```

## 4.5. Maven仓库的使用

https://mvnrepository.com/

# 5. Servlet

用于开发动态web资源

servlet是JavaWeb三大组件之一，JavaWeb三大组件：servlet程序  filter过滤器  listener监听器

servlet是运行在服务器上的Java小程序，接收和响应来自客户端的请求

servlet本质上是一个接口，开发servlet程序，只需要完成两个步骤：

1. 编写一个类实现servlet接口
2. 把开发好的java类部署到web服务器中

把实现了Servlet接口的Java程序叫做Servlet程序

## 5.1. Hello Servlet

**javaweb-03-servlet**  工程

1. 构建一个普通的Maven项目，删除src目录。在项目project中建立module。把依赖写在主工程里

2. 关于Maven父子工程的理解

   父项目中会有

   ```xml
   <modules>
       <module>servlet-01</module>
   </modules>
   ```

   子项目中会有

   ```xml
   <parent>
           <artifactId>javaweb-03-servlet</artifactId>
           <groupId>com.eastplain</groupId>
           <version>1.0-SNAPSHOT</version>
       </parent>
   ```

3. Maven环境优化

   修改web.xml为最新的

   将maven的结构搭建完整

4. 编写一个Servlet程序

   编写一个普通类

   实现Servlet接口，直接继承HttpServlet

   ```java
   public class HelloServlet extends HttpServlet {
   
       // doGet()和doPost()只是请求实现的不同方式，可以相互调用，业务逻辑相同
       @Override
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           PrintWriter writer = resp.getWriter();
           writer.print("Hello Servlet");
       }
   
       @Override
       protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           doGet(req, resp);
       }
   }
   ```

5. 编写Servlet的映射

   为什么需要映射：写的是Java程序，但是要通过浏览器访问，浏览器需要连接web服务器，所以需要在web服务中注册我们写的Servlet，需要给一个浏览器需要访问的路径

6. 配置TomCat

   配置项目发布的路径

7. 启动测试

## 5.2. Servlet原理

servlet是由web服务器调用的

![servlet原理](..\JavaWeb\servlet.png)

## 5.3. ServletContext

web容器在启动的时候，为每个web程序都创建一个ServletContext对象，代表了当前的web应用。

![ServletContext](..\JavaWeb\ServletContext.png)

ServletContext凌驾于一切之上。

### 5.3.1. ServletContext用于共享数据

在一个ServletContext中保存的数据，可以在另一个ServletContext中使用

首先需要一个放置数据的类

```java
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // this.getInitParameter();  // 初始化参数
        // this.getServletConfig();  // Servlet配置
        // *this.getServletContext();  // Servlet上下文
        ServletContext context = this.getServletContext();
        String username = "nancy";  // 数据
        context.setAttribute("username", username);  // 将一个数据保存在了SerletContext中，以键值对的形式
        System.out.println("Hello Servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

其次需要一个读取数据的类

```java
public class GetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        String username = (String) context.getAttribute("username");
        resp.getWriter().print("username demo " + username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

配置xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
         http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
  
  <servlet>
    <servlet-name>Hello</servlet-name>
    <servlet-class>com.eastplain.servlet.HelloServlet</servlet-class>

  </servlet>
  <servlet-mapping>
    <servlet-name>Hello</servlet-name>
    <url-pattern>/servlet</url-pattern>
  </servlet-mapping>

  <servlet>
    <servlet-name>GetName</servlet-name>
    <servlet-class>com.eastplain.servlet.GetServlet</servlet-class>

  </servlet>
  <servlet-mapping>
    <servlet-name>GetName</servlet-name>
    <url-pattern>/name</url-pattern>
  </servlet-mapping>

</web-app>

```

### 5.3.2. ServletContext用于获得初始化参数

### 5.3.3. ServletContext用于请求转发

![](..\JavaWeb\请求转发.png)

```java
package com.eastplain.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author EastPlain
 * @create 2021-3-02 9:54
 */
public class ServletContextDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        context.getRequestDispatcher("/servlet").forward(req, resp);  // 用于请求转发
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

### 5.3.4. ServletContext用于读取资源文件

## 5.4. HttpServletRequest

HttpServletRequest代表客户端的请求，用户通过http协议访问服务器，http请求中的所有信息会被封装到HttpServletRequest中，通过HttpServletRequest的方法，获得客户端的所有信息

常见应用

1. 获取前端的参数
2. 下载文件

```java
package com.eastplain.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author EastPlain
 * @create 2021-3-02 11:33
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("---------------");
        System.out.println(username);
        System.out.println(password);
        // 通过请求转发
        // 说明："/"代表当前的web应用
        req.getRequestDispatcher("/success.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

```

## 5.5. HttpServletResponse

web服务器接收到客户端的http请求，针对这个请求，分别创建一个代表请求的HttpServletRequest对象，一个代表响应的HttpServletResponse对象

1. 负责向浏览器发送数据的方法

   ```java
   ServletOutputStream getOutputStream() throws IOException;
   
   PrintWriter getWriter() throws IOException;
   ```

2. 负责向浏览器发送响应头的方法

   ```java
   void setCharacterEncoding(String var1);
   
   void setContentLength(int var1);
   
   void setContentLengthLong(long var1);
   
   void setContentType(String var1);
   
   void setBufferSize(int var1);
   ```

常见应用

1. 向浏览器输出消息
2. 请求转发

### 5.4.1. 向浏览器输出信息

### 5.5.1. 下载文件

获取下载文件的路径

获取下载文件的文件名

设置浏览器使其支持下载

获取下载文件的输入流

创建缓冲区

获取OutputStream对象

将FileOutputStream写入到buffer缓冲区

使用OutputStream将缓冲区的数据输出到客户端

### 5.5.2. 实现重定向

![](..\JavaWeb\重定向.png)

一个web资源受到客户端请求，会通知客户端去访问另一个web资源，这个过程被称为重定向

例如，登录成功跳转到新的页面

```java
package com.eastplain.servlet;

        import javax.servlet.ServletContext;
        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

/**
 * @author EastPlain
 * @create 2021-3-02 10:54
 */
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/servlet_02_war_exploded/name");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

**重定向与转发**

相同点：页面都会跳转

不同点：请求转发时，url不会变化，307；

​                 重定向时，url会变化，302

# 6. Cookie和Session

**Cookie  小饼干**

**Session  会话**  



**会话**

用户打开一个浏览器，点击链接，访问多个web资源，关闭浏览器，这个过程称为会话

**有状态会话**

一个同学来过教室，下次他再来教室时，我们会知道，他曾经来过

## 6.1. 保存会话的两种技术

1. Cookie

   服务端给客户端一个信件，客户端下次访问服务端带上信件就可以了  **Cookie**

   Cookie是一种客户端技术，用到（请求，响应）

2. 服务器登记客户端来过了，下次服务器进行匹配  **Session**

   Session是一种服务器技术，利用这种技术，可以保存用户的会话信息，我们可以把会话和信息放在session中

常见应用：网站登录一次后，下一次可以直接登录（一定时间内）



















































