package dayOneTwo;

class Thread1 extends Thread {
    public Thread1(String name) {
        super(name);
    }
    @Override
    public void run() {
        for(int i = 0; i<5; i++) {
            System.out.println("Inside " + Thread.currentThread() + " " + i);
        }
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i<5; i++) {
            System.out.println("Inside " + Thread.currentThread() + " " + i);
        }
    }
}

public class Example {
    public static void main(String[] args) {
        System.out.println("main is starting.");
        Thread1 t1 = new Thread1("thread1");
        Thread t2 = new Thread(new Thread2(), "thread2");
        System.out.println(t1.getName()); // thread1
        System.out.println(t2.getName()); // thread 2
        t1.start();
        t2.start();
        System.out.println("main is exiting.");
    }
}
