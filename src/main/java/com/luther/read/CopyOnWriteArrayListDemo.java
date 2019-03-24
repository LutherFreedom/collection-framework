package com.luther.read;

import com.luther.read.po.Person;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * PackageName: com.luther.read
 *
 * @Author: Luther
 * CreateTime2019/3/20 22:43
 * TODO:
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, ClassNotFoundException {
        CopyOnWriteArrayList<Person> people = initList();

        ArrayList<Person> deletePeople = initDeleteList();

        people.removeAll(deletePeople);

        Person[] newEl = new Person[20];
        System.arraycopy(people.toArray(), 0, newEl, 0, people.size() - 1);


        System.out.println(people.get(0) == people.get(0));
        testThreadSafe(people);

        testReplaceAll(people);

        testSharedSecrets();

        testSubList(people);
    }

    private static void testSubList(CopyOnWriteArrayList<Person> people) throws NoSuchFieldException, ClassNotFoundException {
        List<Person> subList = people.subList(1,3);
        System.out.println(subList);
    }

    private static void testSharedSecrets() {
//        JavaLangAccess javaLangAccess = SharedSecrets.getJavaLangAccess();
    }

    private static void testReplaceAll(CopyOnWriteArrayList<Person> people) {
        people.replaceAll(p->{
            p.setSex("F");
            return p;
        });
        System.out.println(people);
    }

    private static CopyOnWriteArrayList<Person> initList() {
        CopyOnWriteArrayList<Person> people = new CopyOnWriteArrayList<>();
        people.add(new Person("Aaa", "M"));
        people.add(new Person("Bbb", "F"));
        people.add(new Person("Ccc", "F"));
        people.add(new Person("Dddd", "M"));
        people.add(new Person("Eee", "F"));
        for (int i = 0; i < 2 * 2 * 2 * 2 * 2 * 2 * 2; i++) {
            people.add(new Person("Ffff", "F"));
        }
        return people;
    }

    private static ArrayList<Person> initDeleteList(){
        ArrayList<Person> deletePeople = new ArrayList<>();
        deletePeople.add(new Person("Aaa", "M"));
        deletePeople.add(new Person("Ffff", "F"));
        return deletePeople;
    }

    private static void testThreadSafe(CopyOnWriteArrayList<Person> people) throws InterruptedException {
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
