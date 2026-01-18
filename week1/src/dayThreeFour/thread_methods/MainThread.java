package dayThreeFour.thread_methods;

class ThreadDemo extends Thread {
    ThreadDemo() {
        System.out.println("Thread: " + Thread.currentThread().getName() + ", " + "State: New");
    }

    @Override
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getName() + ", " + "State: Running");
        for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + Thread.currentThread().getName() + ", " + i);
        }
        System.out.println("Thread: " + Thread.currentThread().getName() + ", " + "State: Dead");
    }

    public void start() {
        System.out.println("Thread: " + Thread.currentThread().getName() + ", " + "State: Start");
        super.start();
    }
}


public class MainThread {
    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo();
        ThreadDemo t2 = new ThreadDemo();
        t1.start();
        t2.start();
        System.out.println("Thread: " + Thread.currentThread().getName() + ", " + "State: Dead");
    }
}
