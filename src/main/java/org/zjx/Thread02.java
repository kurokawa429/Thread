package org.zjx;

public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();

        Thread thread1 = new Thread(() -> {
            int i = 0;
            while (true) {
                System.out.println("thread1线程类启动" + (++i) + "当前线程名：" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        int i = 0;
        while (true){
            System.out.println("主线程类启动" + (++i) + "当前线程名：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Dog implements Runnable {

    int i;

    @Override
    public void run() {
        while (true) {

            System.out.println("Dog线程类启动" + (++i) + "当前线程名：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
