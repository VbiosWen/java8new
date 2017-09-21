package cn.vbiso.niukewang;

import java.util.*;

abstract class Animal {
    abstract void say();
}

public class Cat extends Animal {

    public Cat() {
        System.out.println("i am a cat!");
    }
    public static void main(String[] args){
        Cat cat=new Cat();
        Hashtable<String, String> stringStringHashtable = new Hashtable<>();
        stringStringHashtable.put("1","李四");
        stringStringHashtable.put("2","张三");
        Enumeration e=stringStringHashtable.keys();
        while (e.hasMoreElements()){
            System.out.println(stringStringHashtable.get(e.nextElement()));
        }
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

    }

    @Override
    void say() {

    }
}
