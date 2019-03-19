package com.luther.read;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * PackageName: com.luther.read
 *
 * @Author: Luther
 * CreateTime2019/3/19 19:19
 * TODO:
 */
public class CollectionDemo {
    public static void main(String[] args) {
        //返回一个空集合， 但是此集合不能调用add方法， 因为Collections.EMPTY_LIST的集合（EmptyList）继承自
        //AbstractList, AbstractList的add方法是直接报UnsupportException
        Collection emptyCollection = Collections.EMPTY_LIST;

        //同样是返回一个空集合,但是这个可以指定泛型，之后与Collections.EMPTY_LIST相同
        emptyCollection = Collections.<String>emptyList();


        Collection personCollection = new ArrayList<>();
        personCollection.add(new Person("张三", "F"));
        personCollection.add(new Person("李四", "F"));
        personCollection.add(new Person("王五", "F"));
        personCollection.add(new Person("赵六", "F"));
        personCollection.add("assadas");

        //这是集合中不同的对象都能被转成数组，且不会报错
        Object[] arrA = personCollection.toArray();
        System.out.println(arrA.length);

        //toArray参数中指定了数组类型， 如果集合中类型不一致会报 element type mismatch
        Person[] arrB = (Person[]) personCollection.toArray(new Person[]{});
        System.out.println(arrB.length);

        //要它有什么用？？？
        Object[] arrC = personCollection.toArray(Person[]::new);//== toArray(value -> new Person[value])
        System.out.println(arrC.length);
    }

    static class Person {
        private String name;
        private String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Person() {
        }

        public Person(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }

        public Person(Person source) {
            this.name = source.getName();
            this.sex = source.getSex();
        }
    }
}
