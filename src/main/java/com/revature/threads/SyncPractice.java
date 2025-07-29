package com.revature.threads;

public class SyncPractice {
    private int count =0;
    public synchronized void increment(){
        count++;
    }
    public  int getCount(){
        return  count;
    }
}
