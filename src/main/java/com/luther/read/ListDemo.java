package com.luther.read;

import com.luther.read.po.Person;

import java.util.*;
import java.util.function.UnaryOperator;

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

        //删除元素
        personList.remove(new Person("张三", "F"));
        System.out.println(personList.size());

        //替换全部元素
        UnaryOperator<Person> operator = person -> {
            person.setSex("M");
            return person;
        };
        personList.replaceAll(operator);
        System.out.println(personList.size());

        //元素排序
        personList.sort(Comparator.comparing(person -> person.getName().hashCode()));
        System.out.println(personList.size());

        personList.set(2, new Person("罗成", "M"));
        System.out.println(personList.size());

        personList.add(1, new Person("李元霸", "M"));
        System.out.println(personList.size());

        System.out.println(personList.indexOf(new Person("李元霸", "M")));

        personList.add(4, new Person("李元霸", "M"));
        System.out.println(personList.lastIndexOf(new Person("李元霸", "M")));

        ListIterator<Person> personListIterator = personList.listIterator();
        while (personListIterator.hasNext()) {
            Person person = personListIterator.next();
            System.out.println(person.getName() + person.getSex());
        }

        ListIterator<Person> personListIterator1 = personList.listIterator(2);
        while (personListIterator1.hasNext()) {
            Person person = personListIterator1.next();
            System.out.println(person.getName() + person.getSex());
        }

        List<Person> subList = personList.subList(1,4);
        forEach(subList);

        List<Person> copyList = List.copyOf(subList);
        copyList.add(new Person("xxx", "M"));
    }

    private static <E> void forEach(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            E element = list.get(i);
            System.out.println(element.toString());
        }
    }
}
