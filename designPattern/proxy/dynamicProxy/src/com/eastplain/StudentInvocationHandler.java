package com.eastplain;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author EastPlain
 * @date 2021/8/10 20:07
 */
public class StudentInvocationHandler<T> implements InvocationHandler {

    /**
     * 持有的被代理的对象
     */
    T target;

    public StudentInvocationHandler(T target) {
        this.target = target;
    }

    /**
     * @param proxy 动态代理对象
     * @param method 正在执行的方法
     * @param args 调用目标方法时传入的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("正在代理执行 " + method.getName() + " 方法");

        // 代理过程中加入时间检测方法
        TimeUtil.timeStart();
        Object result = method.invoke(target, args);
        TimeUtil.timeEnd(method.getName());

        return result;
    }
}
