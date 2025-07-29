package com.revature.threads;

public class MultiThread extends Thread{
    private String taskName;

    public MultiThread(String taskName){
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(taskName+" Started by "+ Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println(taskName+" interrupted.");
        }
        System.out.println(taskName+" finished.");
    }
}
