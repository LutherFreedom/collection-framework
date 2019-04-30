package com.luther.read;

import com.luther.read.po.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName: com.luther.read
 *
 * @Author: Luther
 * CreateTime2019/3/29 11:03
 * TODO:
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        remove();
    }

    static void remove(){
        List<String> rootList = new ArrayList<String>(){
            {
                add("AAAA");
                add("BBBB");
                add("CCCC");
                add("DDDD");
            }
        };

        List<String> sonList = new ArrayList<String>(){
            {
                add("AAAA");
                add("BBBB");
                add("EEEE");
                add("FFFF");
            }
        };

        rootList.removeAll(sonList);

    }

    static void toArray(){
        List<String> rootList = new ArrayList<String>(){
            {
                add("AAAA");
                add("BBBB");
                add("CCCC");
                add("DDDD");
            }
        };

        String[] a = new String[10];
        String re[] = rootList.toArray(a);
        System.out.println(re.length);

        printArr(re);
    }
    static void testCopy(){
        ArrayList<Person> rootList = new ArrayList<Person>(){
            {
                add(new Person("Aaaa", "F"));
                add(new Person("Bbbb", "F"));
                add(new Person("Cccc", "F"));
                add(new Person("Dddd", "F"));
            }
        };
        ArrayList<Person>  copyList = (ArrayList<Person>) rootList.clone();

        System.out.println(rootList.get(0) == copyList.get(0));
    }

    static void testInit(){
        List<String> list1 = new ArrayList<>();

        List<String> list2 = new ArrayList<>(0);

        List<String> list3 = new ArrayList<>(Integer.MAX_VALUE);

        System.out.println(list1.size());
        System.out.println(list2.size());
    }

    static void testSub(){
        List<String> rootList = new ArrayList<String>(){
            {
                add("AAAA");
                add("BBBB");
                add("CCCC");
                add("DDDD");
            }
        };
        printList(rootList);

        List<String> subList = rootList.subList(1,3);
        subList.set(0, "EEEE");
        printList(subList);
        printList(rootList);
    }
    static void printList(List<String> list){
        System.out.println("Start println");
        list.forEach(System.out::println);
    }

    static void printArr(String[] arr){
        System.out.println("Start println");
        for (int i = 0; i< arr.length; i++)
            System.out.println(arr[i]);
    }
}
