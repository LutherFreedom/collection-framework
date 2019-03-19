package com.luther.read;

import com.luther.read.po.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName: com.luther.read
 *
 * @Author: Luther
 * CreateTime2019/3/19 22:29
 * TODO:
 */
public class ListDemo {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>() {
            {
                add(new Person("张三", "F"));
                add(new Person("李四", "F"));
                add(new Person("王五", "F"));
                add(new Person("赵六", "F"));
                add(new Person("张三", "F"));
            }
        };

        personList.remove(new Person("张三", "F"));
        System.out.println(personList.size());
    }
}
