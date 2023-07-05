package com.example.springcruddemo;

public class LongestCommonPrefix {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runner());
        thread.start();
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(Long.parseLong("1000"));
        Thread thread1 = new Thread(new Runner());
        thread1.start();
//        MyThread myThread = new MyThread();
//        myThread.start();
//
//        Thread.sleep(2000);
//        MyThread myThread1 = new MyThread();
//        myThread1.start();
    }

}

class Runner implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("MyThread " + Thread.currentThread().getName() + " i " + i);
        }

    }
}

class MyThread extends Thread {

    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello from MyThread " + i);
        }
    }
}