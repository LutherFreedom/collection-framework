package com.luther.read.po;

import java.util.Objects;

/**
 * PackageName: com.luther.read.po
 *
 * @Author: Luther
 * CreateTime2019/3/19 22:29
 * TODO:
 */
public class Person {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(sex, person.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex);
    }
}
