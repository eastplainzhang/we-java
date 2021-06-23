# 1. Spring

## 1.1. 简介

解决企业级开发的复杂性

Spring是一个轻量级的控制反转（IOC）和面向切面（AOP)的容器框架

2004年3月24日发布，创始人为 Rod Johnson

Spring的理念：使现有的技术更加容易使用，本身是一个大杂烩，整合了现有的技术框架



SSH    Struct2 + Spring + Hibernate

SSM    SpringMVC + Spring + Mybatis



```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>
```

## 1.2. 优点

Spring是一个开源免费的容器

Spring是轻量级的，非入侵式的

- 控制反转  IOC
- 面向切面编程  AOP
- 支持事务的处理
- 对框架整合的支持

Spring是一个轻量级的控制反转和面向切面编程的框架

## 1.3. 组成

![](..\Spring\20171127110222693.jpg)

## 1.4. 

![现代化的Java开发](..\Spring\屏幕截图 2021-03-24 141104.jpg)

SpringBoot    快速开发的脚手架，可以快速开发微服务

SpringCloud    基于SpringBoot实现的，微服务的整合

# 2. IOC

IOC是一种思想

在之前的业务中，用户的需求可能会影响原来的代码，需要根据用户的需求去修改源代码，如果程序代码量十分大，修改的代价十分昂贵

![](..\Spring\屏幕截图 2021-03-24 150350.jpg)

![image-20210324151641872](..\images\image-20210324151641872.png)

# 3. HelloSpring

对象由Spring创建，注册，管理

- **所有的类都需要装配到bean里面**
- **所有的bean都需要通过去取**
- **容器里的bean取出来都是一个对象**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- 使用Spring创建对象 在Spring中这些称为bean
    bean相当于对象
    id相当于变量名
    class相当于要new的对象
    property相当于对象的属性设置-->

    <bean id = "hello" class="com.eastplain.pojo.Hello">
        <property name="str" value="Spring"/>
    </bean>

</beans>
```

```java
import com.eastplain.pojo.Hello;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author EastPlain
 * @create 2021-3-24 15:30
 */
public class MyTest {

    @Test
    public void HelloTest() {
        // 获取Spring的上下文对象  拿到Spring的容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 对象都在Spring中管理了，要使用，去取出来就可以了
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}

```

# 4. IOC创建对象的方式

- 默认使用无参构造创建bean
- 可以使用有参构造创建bean

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--无参构造-->
    <bean id="user" class="com.eastplain.pojo.User">
        <property name="name" value="nancy"/>
    </bean>

    <!--有参构造第1种 通过下标赋值-->
    <bean id="user" class="com.eastplain.pojo.User">
        <constructor-arg index="0" value="nancy method-01"/>
    </bean>

    <!--有参构造第2种 通过类型赋值 不建议使用-->
    <bean id="user" class="com.eastplain.pojo.User">
        <constructor-arg type="java.lang.String" value="nancy method-02"/>
    </bean>

    <!--有参构造第3种 通过参数名赋值-->
    <bean id="user" class="com.eastplain.pojo.User">
        <constructor-arg name="name" value="nancy method-03"/>
    </bean>

</beans>
```

在配置文件加载的时候，容器中管理的对象就已经被初始化了

# 5. Spring配置

## 5.1. 别名

```xml
<!--添加别名-->
<alias name="user" alias="userNancy"/>
```

```java
User user = (User) context.getBean("userNancy");
user.show();
```

## 5.2. bean的配置

```xml
<!--bean的配置
id  bean的唯一标识符  相当于对象名
class  bean对象所对应的全限定名（包名+类名）
name  别名  可以取多个别名-->
```

## 5.3. import

一般用于团队开发，将多个配置文件导入合并为一个

# 6. 依赖注入

**Dependency Injection  DI**

- 依赖：bean对象的创建依赖容器
- 注入：bean对象的所有属性由容器注入

## 6.1. 构造器注入

前面讲的就是构造器注入

## 6.2. set方式注入*

### 6.2.1. 环境搭建

复杂类型

```java
package com.eastplain.pojo;

/**
 * @author EastPlain
 * @create 2021-3-25 10:47
 */

public class Address {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
```

真实测试对象

```java
package com.eastplain.pojo;

import java.util.*;

/**
 * @author EastPlain
 * @create 2021-3-25 10:47
 */

public class Student {

    private String name;
    private Address address;
    private String[] books;
    private List<String> hobbies;
    private Map<String, String> card;
    private Set<String> games;
    private Properties info;
    private String girlfriend;
}

```

beans.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="address" class="com.eastplain.pojo.Address">
        <property name="address" value="nan jing"/>
    </bean>

    <bean id="student" class="com.eastplain.pojo.Student">

        <!--方式1  普通值注入，直接使用value即可-->
        <property name="name" value="nancy"/>

        <!--方式2  bean注入，使用ref-->
        <property name="address" ref="address"/>

        <!--方式3  数组注入-->
        <property name="books">
            <array>
                <value>hong lou meng</value>
                <value>xi you ji</value>
            </array>
        </property>

        <!--方式4  list注入-->
        <property name="hobbies">
            <list>
                <value>code</value>
                <value>movie</value>
            </list>
        </property>

        <!--方式5  map注入-->
        <property name="card">
            <map>
                <entry key="student card" value="666666666"/>
                <entry key="bank card" value="790708078"/>
            </map>
        </property>

        <!--方式6  set注入-->
        <property name="games">
            <set>
                <value>coc</value>
                <value>lol</value>
            </set>
        </property>

        <!--方式7  null注入-->
        <property name="girlfriend">
            <null/>
        </property>

        <!--方式8  properties注入-->
        <property name="info">
            <props>
                <prop key="student id">201988888</prop>
                <prop key="gender">female</prop>
            </props>
        </property>

    </bean>

</beans>


```

测试类

```java
import com.eastplain.pojo.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author EastPlain
 * @create 2021-3-25 10:52
 */

public class MyTest {

    @Test
    public void test_01() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
    }
    /*
    Student{
        name='nancy',
        address=Address{address='nan jing'},
        books=[hong lou meng, xi you ji],
        hobbies=[code, movie],
        card={student card=666666666, bank card=790708078},
        games=[coc, lol], info={gender=female, student id=201988888},
        girlfriend='null'
     }
     */
}

```

## 6.3. 拓展方式注入

p命名空间注入可以直接注入属性

```java
<bean id="user" class="com.eastplain.pojo.User" p:name="nancy" p:age="23"/>

```

c命名空间注入可以通过构造器注入

```java
<bean id="user" class="com.eastplain.pojo.User" p:name="nancy" p:age="23"/>

```

## 6.4. bean的作用域

![](..\Spring\屏幕截图 2021-03-25 142147.jpg)

重点掌握单例模式和原型模式

### 6.4.1. 单例模式

是Spring的默认模式

![单例模式](..\Spring\单例模式.jpg)

```java
<bean id="user" class="com.eastplain.pojo.User" p:name="nancy" p:age="23" scope="singleton"/>
```

### 6.4.2. 原型模式

![原型模式](..\Spring\原型模式.jpg)

```java
<bean id="user" class="com.eastplain.pojo.User" p:name="nancy" p:age="23" scope="prototype"/>
```

每次从容器中get的时候，都会产生一个新对象

### 6.4.3. 其他的

request，session，application等在web开发中使用

# 7. bean的自动装配

自动装配是Spring满足bean依赖的一种方式

Spring会在上下文中自动寻找bean并为bean装配属性

**在Spring中有3中装配的方式**

1. **在xml中显式地配置**
2. **在Java中显式地配置**
3. **隐式地自动装配***

## 7.1. 环境搭建

一个人有一猫一狗两个宠物

xml手动装配

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="cat" class="com.eastplain.pojo.Cat"/>

    <bean id="dog" class="com.eastplain.pojo.Dog"/>

    <bean id="person" class="com.eastplain.pojo.Person">
        <property name="name" value="nancy"/>
        <property name="cat" ref="cat"/>
        <property name="dog" ref="dog"/>
    </bean>

</beans>
```

## 7.2. byName自动装配

```xml
<!--byName  会自动在容器上下文查找，和自己对象set方法后面的值对应的bean id-->
<bean id="person" class="com.eastplain.pojo.Person" autowire="byName">
    <property name="name" value="nancy"/>
</bean>
```

## 7.3. byType自动装配

```xml
<!--byName  会自动在容器上下文查找，和自己对象属性类型相同的bean id-->
<bean id="person" class="com.eastplain.pojo.Person" autowire="byName">
    <property name="name" value="nancy"/>
</bean>
```

## 7.4. 小结

- byName必须保证所有bean的id唯一，并需要和自动注入的属性的set方法的值一致
- byType必须保证所有的bean的class唯一，并需要和自动配置的属性的类型一致

## 7.5. 使用注解实现自动装配

JDK1.5从支持注解

Spring从2.5支持注解

**要使用注解**

1. 导入约束
2. 配置注解的支持

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/context/spring-aop.xsd">

    <!--开启注解的支持-->
    <context:annotation-config/>

    <bean id="cat" class="com.eastplain.pojo.Cat"/>

    <bean id="dog" class="com.eastplain.pojo.Dog"/>

    <bean id="person" class="com.eastplain.pojo.Person"/>


</beans>
```

### 7.5.1. @AutoWired和@Qualifier

可以在属性上使用，也可以在set方法上使用

```java
package com.eastplain.pojo;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author EastPlain
 * @create 2021-3-25 14:33
 */

public class Person {

    @Autowired
    private Cat cat;
    @Autowired
    private Dog dog;
    private String name;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}

```

如果显式地定义了@Autowired的required为false，则属性可以为null，否则不能为null

如果自动装配的环境比较复杂，自动装配无法通过一个注解@AutoWired完成，可以使用@Qualifier指定唯一的bean对象

### 7.5.2. @Resource

@Resource和@Autowired

- 都是用来自动装配的，都可以放在属性字段上
- @Autowired默认以byType的属性实现，如果不能唯一自动装配，通过@Qualifier
- @Resource默认以byName的属性实现，如果找不到名字，自通过byType方式实现，且必须要求对象存在

# 8. 使用注解开发

在Spring4之后，要使用注解开发，必须保证AOP的包导入了

使用注解要导入约束，增加注解支持

## 8.1. bean注入  @Component

组件，放在类上，说明这个类被Spring管理了，就是bean了

```java
// 等价于 <bean id="user" class="com.eastplain.pojo.User"/>
@Component
public class User {

    public String name = "nancy";
}
```

## 8.2. 属性注入  @Value

```java
// 等价于 <bean id="user" class="com.eastplain.pojo.User"/>
@Component
public class User {

    // 等价于 <property name="name" value="Nancy"/>
    @Value("Nancy")
    public String name;
}
```

## 8.3. 衍生注解

@Component有几个衍生注解，在web开发中，MVC三层架构分层

- dao 

  ```java
  @Repository
  ```

- service

  ```java
  @Service
  ```

- controller

  ```java
  @Controller
  ```

这四个注解的功能是一样的，都代表将某个类注册到Spring容器中

## 8.4. 作用域  @Scope

## 8.5. 小结

xml与注解

- xml可以用于任何场景，维护方便
- 注解不是自己的类不能使用，维护复杂

最佳实践

- xml管理bean
- 注解只负责属性注入
- 需要注意的问题，必须让注解生效，要开启注解的支持

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/context/spring-aop.xsd">

    <!--指定要扫描的包，这个包下的注解就会生效-->
    <context:component-scan base-package="com.eastplain"/>
    <!--开启注解的支持-->
    <context:annotation-config/>
    
</beans>
```

# 9. 使用JavaConfig实现配置

完全使用Java的方式配置Spring

完全不使用xml，全部交给Java

在Spring4之后，JavaConfig成为了核心功能



实体类

```java
package com.eastplain.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author EastPlain
 * @create 2021-3-25 16:48
 */

// 此处注解 说明这个类被Spring接管了 注册到了容器中
@Component
public class User {

    private String name;

    public String getName() {
        return name;
    }

    // 属性注入值
    @Value("nancy")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

```

配置类

```java
package com.eastplain.config;

import com.eastplain.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author EastPlain
 * @create 2021-3-25 16:50
 * 配置类
 */

// 也会被Spring托管 注册到容器中
// @Configuration代表这是一个配置类 和beans.xml是一样的
@Configuration
@ComponentScan("com.eastplain.pojo")
public class MyConfig {

    // 相当于之前写的一个bean标签
    // 这个方法的名字就相当于bean标签中的id属性
    // 这个方法的返回值就相当于bean标签中的class属性
    @Bean
    public User getUser() {
        return new User();  // 返回要注入到bean中的对象
    }
}

```

测试类

```java
import com.eastplain.config.MyConfig;
import com.eastplain.pojo.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author EastPlain
 * @create 2021-3-25 16:54
 */

public class MyTest {

    @Test
    public void test_01() {

        // 如果完全使用配置类方法去做 就只能通过AnnotationConfig上下文获取容器，通过配置类的class对象加载
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        User getuser = (User) context.getBean("user");
        System.out.println(getuser.getName());

    }
}

```

# 10. 代理模式



为什么要学习代理模式？

**因为是SpringAOP的底层！**

代理模式的分类

- 静态代理
- 动态代理

![](..\Spring\代理模式.png)

代理模式的好处

- 可以使真实角色的操作更加纯粹，不用去关注一些公共的业务
- 公共业务交给了代理角色，**实现了业务的分工**
- 公共业务发生扩展的时候，**方便集中管理**

代理模式不好的地方

- 一个真实角色就要产生一个代理角色，代码量会翻倍，开发效率会变低
- 使用动态代理解决

## 10.1. 静态代理

角色分析

- 抽象角色  一般使用接口或者抽象类来解决
- 真实角色  被代理的角色
- 代理角色  代理真实角色  代理真实角色后一般会有一些附属操作
- 客户  访问代理对象的人

## 10.2.  静态代理深入理解

![](..\Spring\aop实现机制.png)

代码对应spring-08-proxy

## 10.3. 动态代理

**动态代理的底层都是反射**

- 动态代理和静态代理的角色是一样的
- 动态代理的代理类是动态生成的，不是直接写好的

**动态代理分类**

- 基于接口的动态代理

  JDK动态代理

- 基于类的动态代理

  cglib

- Java字节码流

**需要了解两个类**

- Proxy
- InvocationHandler  调用处理程序

# 11. AOP

面向切面编程

## 11.1. Spring实现AOP方式一

使用Spring的API接口

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <bean id="userService" class="com.eastplain.service.UserServiceImpl"/>
    <bean id="log" class="com.eastplain.log.Log"/>
    <bean id="afterlog" class="com.eastplain.log.AfterLog"/>

    <!--方式一 使用原生的API接口-->
    <!--导入aop的约束-->
    <aop:config>
        <!--切入点-->
        <aop:pointcut id="pointcut" expression="execution(* com.eastplain.service.UserServiceImpl.*(..))"/>

        <!--执行环绕增强-->
        <aop:advisor advice-ref="log" pointcut-ref="pointcut"/>
        <aop:advisor advice-ref="afterlog" pointcut-ref="pointcut"/>
    </aop:config>

</beans>

```

## 11.2. Spring实现AOP方式二

自定义实现AOP

```java
package com.eastplain.diy;

/**
 * @author EastPlain
 * @create 2021-3-30 11:13
 */
public class DIYPointCut {

    public void before() {
        System.out.println("======方法执行前======");
    }

    public void after() {
        System.out.println("======方法执行后======");
    }
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <bean id="userService" class="com.eastplain.service.UserServiceImpl"/>
    <bean id="log" class="com.eastplain.log.Log"/>
    <bean id="afterlog" class="com.eastplain.log.AfterLog"/>

    <!--方式二 自定义类-->
    <bean id="diy" class="com.eastplain.diy.DIYPointCut"/>

    <aop:config>
        <!--自定义切面-->
        <aop:aspect ref="diy">
            <!--切入点-->
            <aop:pointcut id="point" expression="execution(* com.eastplain.service.UserServiceImpl.*(..))"/>
            <!--通知-->
            <aop:before method="before" pointcut-ref="point"/>
            <aop:after method="after" pointcut-ref="point"/>
        </aop:aspect>
    </aop:config>

</beans>


```

## 11.3. Spring实现AOP方式三

使用注解实现AOP

```java
package com.eastplain.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author EastPlain
 * @create 2021-3-30 11:48
 *
 * 使用注解方式实现AOP
 */

@Aspect  // 标注这个类是一个切面
public class AnnotationPointCut {

    @Before("execution(* com.eastplain.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("方法执行前");
    }

    @After("execution(* com.eastplain.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("方法执行后");
    }

    @Around("execution(* com.eastplain.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前");
        Object process = pjp.proceed();
        System.out.println("环绕后");
    }


}

```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <bean id="userService" class="com.eastplain.service.UserServiceImpl"/>
    <bean id="log" class="com.eastplain.log.Log"/>
    <bean id="afterlog" class="com.eastplain.log.AfterLog"/>

    <!--方式三 使用注解-->
    <bean id="annotationpointcut" class="com.eastplain.diy.AnnotationPointCut"/>
    <!--开启注解支持-->
    <aop:aspectj-autoproxy/>

</beans>
```

# 12. Spring整合Mybatis

1. 导入jar包
   - junit
   - mybatis
   - mysql
   - spring
   - aop
   - mybatis-spring
2. 编写配置文件
3. 测试

## 12.1. 回顾Mybatis

1. 编写实体类
2. 编写核心配置文件
3. 编写接口
4. 编写Mapper.xml
5. 测试

## 12.2. Mybatis-Spring

允许mybatis参与到spring的事务管理中

1. 编写数据源
2. sqlSessionFactory
3. sqlSessionTemplate
4. 需要给接口加实现类
5. 将自己写的实现类注入到Spring中，测试使用

# 13. 声明式事务

## 13.1. 回顾事务

- 要么都成功，要么都失败
- 事务在项目中十分重要，关系到数据完整性和一致性

事务的ACID原则

- 原子性
- 一致性
- 隔离性
  - 多个业务可能操作同一个资源，防止数据损坏
- 持久性

## 13.2. 声明式事务

AOP 不改变原有的代码



