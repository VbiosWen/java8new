package cn.vbiso.java8;

import org.junit.Test;

public class TestNiuKe {


    @Test
    public void test(){
        short a=128;
        byte b= (byte) a;
        System.out.println(a+" "+b);
        int i=5;
        int s=(i++)+(++i)+(i--)+(--i);
        System.out.println(s);
    }
}
