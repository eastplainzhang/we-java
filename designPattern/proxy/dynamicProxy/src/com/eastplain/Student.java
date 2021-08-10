package com.eastplain;

/**
 * 学生类 - 真实类
 *
 * @author EastPlain
 * @date 2021/8/10 20:01
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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " 上交班费");
    }
}
