package cn.vbiso.java8;


import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.function.*;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by v on 2017/9/9.
 */
public class TestLamada {



    @Test
    public void testLambda(){
        Comparator<Integer> com=(x, y)->Integer.compare(x,y);
        TreeSet<Integer> ts=new TreeSet<Integer>(com);
    }


    @Test

    public void test1(){
        Integer num=opration(100,(x)->x+100);
        System.out.println(num);
    }

    public Integer opration(Integer num,MyFunc<Integer> myFunc){
        return myFunc.getValue(num);
    }

    @Test
    public void test2(){
        Consumer<String> consumer=System.out::println;
        consumer.accept("abcdeff");
        BiPredicate<String,String> bp=String::equals;
        System.out.println(bp.test("1","2"));
        Function<Integer,String[]>fun=(x)->new String[x];
        String[] strs=fun.apply(109);
        System.out.println(strs.length);

        Function<Integer,String[]> fun2=String[]::new;
        String[] str2=fun2.apply(20);
        System.out.println(str2.length);

    }
    @Test
    public void test3(){

        Instant start=Instant.now();
        LongStream.rangeClosed(0,10000000000L)
                .parallel()
                .reduce(0,Long::sum);
        Instant end=Instant.now();
        System.out.println("耗费时间为:"+ Duration.between(start,end).toMillis());


    }
}
