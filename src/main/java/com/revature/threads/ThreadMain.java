package com.revature.threads;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
//        thread using Thread class
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
//        thread using runnable
        Thread boomThread = new Thread(new MyRunnable(), " BoomThread");
//        multi-threading example
        MultiThread mt = new MultiThread("Task-A");
        MultiThread mt2 = new MultiThread("Task-B");
//        Synchronized block of thread
        SyncPractice counter = new SyncPractice();
        Thread thre1 = new Thread();
            for(int i=0;i<1000;i++) counter.increment();

        Thread thre2 = new Thread();
            for(int i=0;i<1000;i++) counter.increment();
        thre1.start();
        thre2.start();
        thre1.join();
        thre2.join();
        System.out.println("Finally Count: "+counter.getCount());
//        t1.setName(" Woker-a");
//        t2.setName(" Woker-b");
//        t1.start();
//        t2.start();
//        boomThread.start();
//        multi-threading example
//        mt.setName("Worker-1");
//        mt2.setName("Worker-2");
//        mt.start();
//        mt2.start();
    }
}
