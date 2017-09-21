package cn.vbiso.thread.test;

import org.junit.Test;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class TradionalThread {




    @Test
    public void test1(){
        new Thread(()-> System.out.println("runnable")).start();
    }

    @Test
    public void test2(){
       new Timer().schedule(new TimerTask() {
           @Override
           public void run() {
               System.out.println("2000");
           }
       }, 1000,3000  );
    }
}
