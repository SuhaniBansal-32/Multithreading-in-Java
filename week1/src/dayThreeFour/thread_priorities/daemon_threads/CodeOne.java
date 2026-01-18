package dayThreeFour.thread_priorities.daemon_threads;

// Creating a daemon thread

class DaemonThread extends Thread {
    @Override
        public void run() {
        while(true) {
            System.out.println("Hello World!");
        }
    }
}

class MyThread extends Thread {
    @Override
        public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("User Thread: " + Thread.currentThread().getName() + " " + i);
            try{
                Thread.sleep(100);
            }
            catch(Exception e) {
                System.out.println("Caught: " + e);
            }

        }
    }
}

public class CodeOne {
    public static void main(String[] args) throws InterruptedException {
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true); // daemon thread
        MyThread t1 = new MyThread(); // user thread
        t1.start();
        t1.join();
        daemonThread.start();
        System.out.println("Main done");
    }
}
