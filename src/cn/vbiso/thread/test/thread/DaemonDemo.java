package cn.vbiso.thread.test.thread;

/**
 * 守护线程
 */
public class DaemonDemo {

    public static class DaemonT extends Thread{
        @Override
        public void run() {
            while (true){
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        long time=System.currentTimeMillis();
        Thread t=new DaemonT();
        t.setDaemon(true);
        t.start();
        Thread.sleep(2000);
        System.out.println(System.currentTimeMillis()-time );
    }
}
