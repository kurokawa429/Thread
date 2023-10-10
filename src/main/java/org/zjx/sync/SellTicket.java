package org.zjx.sync;

public class SellTicket {
    public static void main(String[] args) {
        Sell sell1 = new Sell();
        new Thread(sell1).start();
        new Thread(sell1).start();
        new Thread(sell1).start();
    }
}

class Sell implements Runnable{
    private static int count = 100;

    private static boolean loop = true;

public void sell(){

    synchronized (this){
        if (count <= 0) {
            System.out.println("售票结束");
            loop = false;
            return;
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("线程" + Thread.currentThread().getName() + "售出了1张票，剩余票数：" + (--count));
    }
}

    @Override
    public void run() {

        while (loop) {
            sell();
        }

    }
}
