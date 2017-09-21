package cn.vbiso.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStream {

    List<Employee> emps = Arrays.asList(
            new Employee("李四", 21, 5555.55),
            new Employee("张三", 25, 6666.66),
            new Employee("小红", 28, 8888.88),
            new Employee("小李", 28, 9999.77),
            new Employee("小明", 28, 1111.77),
            new Employee("小刘", 28, 2222.77)
    );

    @Test
    public void test1() {
        Stream<Employee> emp = emps.stream().filter((e) -> e.getAge() > 24)
                .limit(1);
        // emp.forEach(System.out::println);
        String[] array = new String[]{"a", "b", "c", "d"};
        Stream<String> array1 = Stream.of(array);
        //array1.forEach(System.out::println);

        //emps.stream().filter((e) -> e.getSalary() > 5000).forEach(System.out::println);
        Stream<String> stringStream = emps.stream().map(Employee::getName);
        // stringStream.forEach(System.out::println);
        emps.stream().map(employee -> (int) employee.getSalary())
                .forEach(System.out::println);

    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        Stream<String> stringStream = list.stream().map(string -> string.toUpperCase());
        stringStream.forEach(System.out::println);
    }

    @Test
    public void test3(){
        List<String>list=Arrays.asList("c","b","a");
       // list.stream().sorted().forEach(System.out::println);

        emps.stream().sorted((e1,e2)->{
            if(e1.getAge().equals(e2.getAge())){
                return e1.getName().compareTo(e2.getName());
            }else {
                return e1.getAge().compareTo(e2.getAge());
            }
        }).forEach(System.out::println);
    }
}
