package cn.vbiso.thread.test;

import java.util.Random;

public class TestThreadABC {


    public static void main(String[] args){
        A a=new A();

        while (true) {
            new Thread(()->{
                try {
                    a.A();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(()->{
                try {
                    a.B();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(()->{
                try {
                    a.C();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
 class A {
    private int count = 0;

    public synchronized void A() throws InterruptedException {
        if (count % 3 != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(System.currentTimeMillis() * i+"a");
            System.out.print(" "+count);
        }
        count += 1;
        this.notify();
        Thread.sleep(1000);
    }

    public synchronized void B() throws InterruptedException {
        if (count % 3 != 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(System.currentTimeMillis() * i+"b");
            System.out.print(" "+count);
        }
        count += 1;
        this.notify();
        Thread.sleep(1000);
    }

    public synchronized void C() throws InterruptedException {
        if (count % 3 != 2) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(System.currentTimeMillis() * i+"c");
            System.out.print(" "+count);
        }
        count += 1;
        this.notify();
        Thread.sleep(1000);
    }

}



