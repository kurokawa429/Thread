package org.zjx;

public class Thread01 {
    public static void main(String[] args) {
        cat cat = new cat();
        cat.start();
    }
}

class cat extends Thread{
    int i = 0;
    @Override
    public void run() {

        while (true) {
            i++;
            System.out.println("线程启动" + i  + "线程名："  + Thread.currentThread().getName());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(i == 10){
                break;
            }

        }
    }
}