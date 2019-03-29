package com.luther.read;

import com.luther.read.po.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.ListIterator;

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
        personArrayList.add(new Person("BBB", "F"));

        personArrayList.add(new Person("CCCC", "F"));

        personArrayList.add(new Person("DDD", "F"));

        Class clazz = ArrayList.class;
        Field[] fields = clazz.getDeclaredFields();
        Method[] methods = clazz.getMethods();
        Class superClass = clazz.getSuperclass();
        Field[] superFields = superClass.getDeclaredFields();
        Field modCountField = superClass.getDeclaredField("modCount");
        modCountField.setAccessible(true);
        System.out.println(modCountField.get(personArrayList));
        System.out.println("1111");

        ListIterator<Person> personIterator = personArrayList.listIterator();
        personIterator.next();
        personIterator.set(new Person("EEE", "m"));
        personIterator.add(new Person("FFF", "F"));


        System.out.println(personIterator.nextIndex());
    }
}
