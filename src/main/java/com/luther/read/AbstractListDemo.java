package com.luther.read;

import com.luther.read.po.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * PackageName: com.luther.read
 *
 * @Author: Luther
 * CreateTime2019/3/28 0:03
 * TODO:
 */
public class AbstractListDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person("AAA", "F"));
        personArrayList.add(new Person("AAA", "F"));

        personArrayList.add(new Person("AAA", "F"));

        personArrayList.add(new Person("AAA", "F"));

        Class clazz = ArrayList.class;
        Field[] fields = clazz.getDeclaredFields();
        Method[] methods = clazz.getMethods();
        Class superClass = clazz.getSuperclass();
        Field[] superFields = superClass.getDeclaredFields();
        Field modCountField = superClass.getDeclaredField("modCount");
        modCountField.setAccessible(true);
        System.out.println(modCountField.get(personArrayList));
        System.out.println("1111");
    }
}
