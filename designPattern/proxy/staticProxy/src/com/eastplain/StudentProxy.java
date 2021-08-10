package com.eastplain;

/**
 * 学生代理类
 *
 * @author EastPlain
 * @date 2021/8/10 19:30
 */
public class StudentProxy implements Person{

    /**
     * 被代理的学生
     */
    private Student student;

    public StudentProxy(Person student) {
        // 本类只能代理学生对象
        if (student.getClass() == Student.class) {
            this.student = (Student) student;
        }
    }

    @Override
    public void giveMoney() {

        System.out.println(student.getName() + " 的成绩很好");

        student.giveMoney();
    }
}
