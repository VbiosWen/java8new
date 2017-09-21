package cn.vbiso.thread.test;

public class TraditionalThreadSy {

    private boolean flag=true;

    public static void main(String[] args) {
        new TraditionalThreadSy().init();

    }

    private void init() {
        final Outputer outputer = new Outputer();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outputer.output("liming");
            }
        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outputer.output2("zhangzicheng");
            }
        }).start();
    }

  static   class Outputer {
        public  synchronized void output(String name) {
            long length = name.length();
            for (int i = 0; i < length; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

        public void output1(String name) {
            long length = name.length();
            synchronized (this) {
                for (int i = 0; i < length; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }
        public static synchronized void output2(String name) {
            long length = name.length();
            for (int i = 0; i < length; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }


}


