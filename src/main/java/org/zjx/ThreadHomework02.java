package org.zjx;

public class ThreadHomework02 {
    public static void main(String[] args) {
        Money money = new Money();
        new Thread(money).start();
        new Thread(money).start();
    }
}
class Money implements Runnable{
    private Integer money = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (money < 1000) {
                    System.out.println("余额不足，当前余额： " + money);
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "取出1000元，当前余额： " + money);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    }
}
