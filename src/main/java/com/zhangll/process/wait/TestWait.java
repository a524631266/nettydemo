package com.zhangll.process.wait;
class A{
    public boolean running = true;
    private Object ob = new Object();
    public void run (){
        synchronized (ob) {
            while (running) {
                try {
                    System.out.println("start waiting");
                    System.out.println(Thread.currentThread());
                    ob.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void notifyob(){
        running = false;
        synchronized (ob){
            ob.notifyAll();
        }
    }
}
public class TestWait {
    public static void main(String[] args) {

        A a = new A();
        new Thread(()->{
            try {
                Thread.sleep(1000);
                a.notifyob();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        a.run();
        System.out.println("1111");
    }
}
