package cn.vbiso.thread.test.thread;

/**
 * notify 和 wait 方法
 * 共同点:必须包含在synchronzied语句中,必须先获取目标对象的一个监视器.都是在方法调用之前获取监视器,在方法调用之后释放监视器
 * 目的:使其他等待在object对象上的线程不至于因为一个线程的休眠而全部无法正常执行
 * 不同点:notify 会随机唤醒一个休眠状态的线程,wait使一个线程进入休眠状态
 * wait 与 sleep 方法的区别 wait会获取对象的监视器,并在执行后释放监视器
 * sleep不会释放任何资源
 */

public class SimpleWN {

    final  static Object object=new Object();
    public static class T1 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis()+":T1 start");
                try {
                    System.out.println(System.currentTimeMillis()+": T1 wait for object");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()+":T1 end");
            }
        }
    }
    public static class T2 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis()+":T2 start,notify one thread");

                object.notify();
                System.out.println(System.currentTimeMillis()+":T2 end");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }
            }
        }
    }
    public static void main(String[] args){
        Thread t1=new T1();
        Thread t2=new T2();
        t1.start();
        t2.start();
    }

}
