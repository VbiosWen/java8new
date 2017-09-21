package cn.vbiso.thread.test.thread;

import org.junit.Test;

public class ThreadInterruptTest {


    public static void main(String[] args) throws InterruptedException {
        /*
        此時的线程并不会中断,因为线程中没有中断处理的逻辑 所以t1即使被置上了中断状态,但是这个中断不会发生任何作用
         */
//        Thread t1=new Thread(()->{
//           while (true){
//               Thread.yield();
//           }
//        });
//        t1.start();
//        Thread.sleep(2000);
//        t1.interrupt();
        Thread t1=new Thread(()->{
           while (true) {
               if (Thread.currentThread().isInterrupted()) {
                   System.out.println("Interrupted");
                   break;
               }
               Thread.yield();
           }
        });
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }

    @Test
    public void TestThreadSleep() throws InterruptedException {
        Thread t1=new Thread(()->{
            while (true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("Interrupted");
                    break;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted When Sleep");

                   Thread.currentThread().interrupt();
                }
                Thread.yield();
            }
        });
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
