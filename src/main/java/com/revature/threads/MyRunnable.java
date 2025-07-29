package com.revature.threads;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Running thread"+ Thread.currentThread().getName());
    }
}
