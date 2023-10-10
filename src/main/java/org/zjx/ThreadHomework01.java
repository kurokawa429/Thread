package org.zjx;

import java.util.Random;
import java.util.Scanner;

public class ThreadHomework01 {
    public static void main(String[] args) {
        A a = new A();
        Thread thread = new Thread(a);
        thread.start();
        B b = new B(a);
        Thread thread2 = new Thread(b);
        thread2.start();
    }

}
class A extends Thread{
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1; // 生成1到100之间的随机整数
            System.out.println("随机整数: " + randomNumber);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class B extends Thread{
    private A a;

    public B(){}

    public B(A a){
        this.a = a;
    }

    private Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        while (true) {
            System.out.print("请输入一个字符：");
            char inputChar = scanner.next().charAt(0);
            if (inputChar == 'q') {
                a.setLoop(false);
                System.out.println("输出结束");
                break;
            }
        }
    }
}
