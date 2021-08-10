package com.eastplain;

/**
 * 学生类 - 真实类
 *
 * @author EastPlain
 * @date 2021/8/10 19:27
 */
public class Student implements Person{

    /**
     * name
     */
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void giveMoney() {
        System.out.println(name + " 上交班费");
    }
}
