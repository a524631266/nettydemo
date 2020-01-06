package com.zhangll.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantRWLock {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        Condition condition = writeLock.newCondition();
//        Condition condition1 = readLock.newCondition(); 报错，没有读的条件
        try{
            readLock.lock();
        }catch (Exception e){
            readLock.unlock();
        }


    }

}
