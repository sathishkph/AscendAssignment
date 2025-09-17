package com.student;

class SyncThreadwait implements Runnable{
    private final Object obj1;
    private final Object obj2;

    public SyncThreadwait(Object o1, Object o2){
        this.obj1 = o1;
        this.obj2 = o2;
    }

    @Override
    public void run(){
        String name = Thread.currentThread().getName();
        System.out.println(name + " acquiring lock on obj1 " + obj1);
        synchronized (obj1){
            System.out.println(name + " acquired lock on obj1 " + obj1);
            work();
            synchronized (obj2){
                System.out.println(name + " acquired lock on obj2 " + obj2);
                work();
                obj2.notify(); // Notify other threads waiting on obj2
            }
            while (true){ // Wait until obj1 is available
                try{
                    System.out.println(name + " released lock on obj2 " + obj2);
                    obj1.wait();
                    System.out.println(name + " reacquired lock on obj1 " + obj1);
                    break;
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(name + " released lock on obj1" + obj1);
        }
    }

    private void work(){
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
