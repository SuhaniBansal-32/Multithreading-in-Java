package dayThreeFour.thread_methods;
// Java Program to illustrate
// stopping a thread
// using the interrupt() method

class MyThread implements Runnable {
    Thread t;
    MyThread() {
        t = new Thread(this);
        System.out.println("New Thread: " + t);
        t.start(); // starting the thread
    }
    @Override
    public void run() {
        try{
            while(!Thread.interrupted()) {
                Thread.sleep(1000);
                System.out.println("Thread is running.");
            }

        }
        catch (InterruptedException e) {
            System.out.println("Thread is interrupted and stopped.");
            System.out.println("Inside thread-1 caught: " + e);
        }

    }
}

public class CodeTwo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        try {
            Thread.sleep(5000);

            // t1 is an object of MyThread
            // which has an object t
            // which is of type thread

            t1.t.interrupt();

            Thread.sleep(5);

        }
        catch(InterruptedException e) {
            System.out.println("Caught: " + e);
        }

        System.out.println("Exiting of main Thread");

    }
}
