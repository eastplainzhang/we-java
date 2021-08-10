package com.eastplain;

import java.lang.reflect.Proxy;

/**
 * @author EastPlain
 * @date 2021/8/10 20:12
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {

        // 创建一个真是的实例对象，这个对象就是被代理的对象
        Person cassie = new Student("cassie");

        // 创建一个与被代理实例相关联的invocationHandler
        StudentInvocationHandler<Person> invocationHandler =
                new StudentInvocationHandler<>(cassie);

        // 创建一个代理实例来代理 cassie
        // 代理对象的每个执行方法都会替代执行 StudentInvocationHandler 中的 invoke 方法
        Person proxyInstance = (Person) Proxy.newProxyInstance(
                Person.class.getClassLoader(),
                new Class<?>[]{Person.class},
                invocationHandler
        );

        proxyInstance.giveMoney();
    }
}
