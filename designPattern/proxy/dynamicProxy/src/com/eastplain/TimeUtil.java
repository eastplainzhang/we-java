package com.eastplain;

/**
 * 检测时间的工具类
 *
 * @author EastPlain
 * @date 2021/8/10 20:04
 */
public class TimeUtil {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void timeStart() {
        threadLocal.set(System.currentTimeMillis());
    }

    public static void timeEnd(String methodName) {
        long endTime = System.currentTimeMillis();
        System.out.println(methodName + " use time : " + (endTime - threadLocal.get())  + "ms");
    }
}
