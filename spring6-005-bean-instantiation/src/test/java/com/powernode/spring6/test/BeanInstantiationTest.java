package com.powernode.spring6.test;

import com.powernode.spring6.bean.*;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Scanner;
import java.util.Scanner;

/**
 * @author 动力节点
 * @version 1.0
 * @className BeanInstantiationTest
 * @since 1.0
 **/
public class BeanInstantiationTest {
    @Test
    public void testDate2()
    {
        Date date = new Date();
        System.out.println(date);

    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        String[] strings = new String[a];
//        int b = scanner.nextInt();
//        for(int i=0;i<a;i++){
//            strings[i] = scanner.next();
//        }

        String[] strings = {"##.#","....","##.#",".#.#"};
        int h = strings.length;
        int w = strings[0].length();
        for (int i = 0; i < h; i++) {
            boolean flag = true;
            for (int j = 0; j < w; j++) {
                if (strings[i].charAt(j) == '#') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int j = i; j < h - 1; j++) {
                    strings[j] = strings[j + 1];
                }
                h--;
                i--;
            }
        }
        for (int i = 0; i < w; i++) {
            boolean flag = true;
            for (int j = 0; j < h; j++) {
                if (strings[j].charAt(i) == '#') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int j = 0; j < h; j++) {
                    StringBuilder stringBuilder = new StringBuilder(strings[j]);
                    stringBuilder.deleteCharAt(i);
                    strings[j] = stringBuilder.toString();
                }
                w--;
                i--;
            }
        }
        for (String string : strings) {
            System.out.println(string);
        }
    }
    @Test
    public void testDate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean("studentBean", Student.class);
        System.out.println(student);
    }
    @Test
    public void test2() {
        //给出H*W的图，如果这个图上一行或一列没有#的话将这一行或这一列删除，输出处理完后的图。1<=H,W<=100
        //输入
        //H W
        //接下来H行，每行W个字符，表示图
        //输出
        //处理完后的图
        //样例输入
        //4 4
        //##.#
        //....
        //##.#
        //.#.#
        //样例输出
        //###
        //###
        //.##
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        String[] strings = new String[h];
        for(int i=0;i<h;i++){
            strings[i] = scanner.next();
        }
        for (int i = 0; i < h; i++) {
            boolean flag = true;
            for (int j = 0; j < w; j++) {
                if (strings[i].charAt(j) == '#') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int j = i; j < h - 1; j++) {
                    strings[j] = strings[j + 1];
                }
                h--;
                i--;
            }
        }
        for (int i = 0; i < w; i++) {
            boolean flag = true;
            for (int j = 0; j < h; j++) {
                if (strings[j].charAt(i) == '#') {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                for (int j = 0; j < h; j++) {
                    StringBuilder stringBuilder = new StringBuilder(strings[j]);
                    stringBuilder.deleteCharAt(i);
                    strings[j] = stringBuilder.toString();
                }
                w--;
                i--;
            }
        }
        for (String string : strings) {
            System.out.println(string);
        }

    }


    @Test
    public void testInstantiation4(){
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }


    @Test
    public void testInstantiation3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Gun gun = applicationContext.getBean("gun", Gun.class);
        System.out.println(gun);
    }

    @Test
    public void testInstantiation2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Star star = applicationContext.getBean("star", Star.class);
        System.out.println(star);
    }

    @Test
    public void testInstantiation1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);
    }

}
