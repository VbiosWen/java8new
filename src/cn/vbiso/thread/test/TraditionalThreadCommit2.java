package cn.vbiso.thread.test;

public class TraditionalThreadCommit2 {


    public static void main(String[] args){
         Business business=new Business();
         new Thread(()->{
            for(int i=0;i<50;i++){
                business.sub(i);
            }
         }).start();
        for(int i=0;i<50;i++){
            business.main(i);
        }
    }
}

class Business{
    private boolean flag=true;
    public synchronized void sub(int i){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int j=0;j<10;j++){
            System.out.println("sub thread is "+j+" loop of "+i);
        }
        flag=false;
        this.notify();
    }

    public synchronized void main(int i){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int j=0;j<100;++j){
            System.out.println("main thread is "+j+" loop of "+i);
        }
        flag=true;
        this.notify();
    }
}
