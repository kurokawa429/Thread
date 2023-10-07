package org.zjx.ticket;

public class SellTicket {
    public static void main(String[] args) {
        Sell sell1 = new Sell();
        Sell sell2 = new Sell();
        Sell sell3 = new Sell();
        Thread thread1 = new Thread(sell1);
        Thread thread2 = new Thread(sell2);
        Thread thread3 = new Thread(sell3);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Sell extends Thread{
    private static int count = 100;



    @Override
    public void run() {

        while (true) {

            if (count <= 0) {
                System.out.println("售票结束");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
                System.out.println("线程" + Thread.currentThread().getName() + "售出了1张票，剩余票数：" + (--count));
        }

    }
}
