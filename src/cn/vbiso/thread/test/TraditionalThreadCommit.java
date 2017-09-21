package cn.vbiso.thread.test;

public class TraditionalThreadCommit {
  private boolean flag=true;

    public static void main(String[] args){

        new Thread(()->{
           for(int i=0;i<50;i++){
               synchronized (TraditionalThreadCommit.class) {
                   for (int j = 0; j < 50; j++) {
                       System.out.println("sub thread" + i + "loop is " + j);
                   }
               }
           }
        }).start();


           for(int i=0;i<50;i++){
               synchronized (TraditionalThreadCommit.class) {
                   for (int j = 0; j < 100; j++) {
                       System.out.println("main thread" + i + "loop is " + j);
                   }
               }
       }
    }
}
