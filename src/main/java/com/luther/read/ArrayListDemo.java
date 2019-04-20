package com.luther.read;

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
}
