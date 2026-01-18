package dayThreeFour.thread_priorities;
 // order of execution of 2 threads with same priority is determined by the thread scheduler

class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println(
                getName() + " is running with priority " + getPriority()
        );
    }
}

public class CodeTwo {
    public static void main(String[] args) {
        // Set main thread's priority
        Thread.currentThread().setPriority(5);

        // Create 2 threads
        MyThread1 t1 = new MyThread1();
        MyThread1 t2 = new MyThread1();

        // Both threads inherit main thread priority (5)
        System.out.println("t1 priority: " + t1.getPriority());
        System.out.println("t2 priority: " + t2.getPriority());

        // Start threads
        t1.start();
        t2.start();
    }
}
