package com.eastplain;

/**
 * 客户端
 *
 * @author EastPlain
 * @date 2021/8/10 19:33
 */
public class Client {

    public static void main(String[] args) {

        Person cassie = new Student("cassie");

        Person monitor = new StudentProxy(cassie);

        monitor.giveMoney();
    }
}
