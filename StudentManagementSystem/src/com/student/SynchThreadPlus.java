package com.student;

class SyncThreadPlus implements Runnable {

    private Object obj1;
    private Object obj2;

    public SyncThreadPlus(Object o1, Object o2) {
        this.obj1 = o1;
        this.obj2 = o2;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        // Acquire locks in a consistent order
        Object firstLock = obj1;
        Object secondLock = obj2;

        // Check if the order needs to be swapped
        if (System.identityHashCode(obj1) > System.identityHashCode(obj2)) {
            firstLock = obj2;
            secondLock = obj1;
            System.out.println("print       :"+ Thread.currentThread().getName());
        }

        System.out.println(name + " acquiring lock on firstLock  " + firstLock);
        synchronized (firstLock) {
            System.out.println(name + " acquired lock on firstLock " + firstLock);
            work();
            System.out.println(name + " acquiring lock on secondLock " + secondLock);
            synchronized (secondLock) {
                System.out.println(name + " acquired lock on secondLock " + secondLock);
                work();
            }
            System.out.println(name + " released lock on secondLock " + secondLock);
        }
        System.out.println(name + " released lock on firstLock " + firstLock);
        System.out.println(name + " finished execution.");
    }

    private void work() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}