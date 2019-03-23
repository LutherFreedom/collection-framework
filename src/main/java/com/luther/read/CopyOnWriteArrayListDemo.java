package com.luther.read;

import com.luther.read.po.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * PackageName: com.luther.read
 *
 * @Author: Luther
 * CreateTime2019/3/20 22:43
 * TODO:
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<Person> people = new CopyOnWriteArrayList<>();
        people.add(new Person("Aaa", "M"));
        people.add(new Person("Bbb", "F"));
        people.add(new Person("Ccc", "F"));
        people.add(new Person("Dddd", "M"));
        people.add(new Person("Eee", "F"));

        ArrayList<Person> deletePeople = new ArrayList<>();
        deletePeople.add(new Person("Aaa", "M"));
        deletePeople.add(new Person("Ccc", "F"));

        people.removeAll(deletePeople);


        System.out.println(people.get(0) == people.get(0));
        Person person = people.get(0);

        Runnable runnable = () -> {
            int age = person.getAge();
            for (int i = 0; i < 1000; i++) {
                age++;
                person.setAge(age);
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(1000);
        System.out.println(people.get(0).getAge());
    }
}
