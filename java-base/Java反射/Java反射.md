# 1. Java反射机制概述

![](..\Java反射\pic\屏幕截图 2021-03-26 113559.jpg)

![](..\Java反射\pic\屏幕截图 2021-03-26 113756.jpg)

![](..\Java反射\pic\屏幕截图 2021-03-26 114049.jpg)

**反射相关的API**

![](..\Java反射\pic\屏幕截图 2021-03-26 114602.jpg)

# 2. Class类

![](..\Java反射\pic\屏幕截图 2021-03-29 144735.jpg)

![](..\Java反射\pic\屏幕截图 2021-03-29 144848.jpg)

## 2.1. Class类的创建方式

```java
/**
 * @author EastPlain
 * @create 2021-3-29 14:57
 *
 * 测试Class类的创建方式有哪些
 */

public class MyTest {

    public static void main(String[] args) throws ClassNotFoundException {

        Person person = new Student();
        System.out.println("this person is: " + person.name);

        // 通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        // forname获得
        Class c2 = Class.forName("com.eastplain.reflection.Student");
        System.out.println(c2.hashCode());

        // 通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

    }
}
```

# 3. 类的加载与ClassLoader

# 4. 创建运行时类的对象

