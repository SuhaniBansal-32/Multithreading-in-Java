package dayThreeFour.thread_methods;
// illustrating join method of thread class

import java.util.concurrent.ThreadFactory;

class MyThreadOne implements Runnable {
    String threadName;
    Thread t;
    public MyThreadOne(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i< 8; i++) {
                System.out.println(threadName + " is running" + "count: " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Caught: " + e);
        }
    }

    public void start() {
        if(t == null) {
            t = new Thread(this);
            t.start();
        }
    }

    public void join(){
        try{
            t.join();
        }
        catch (InterruptedException e) {
            System.out.println("Caught: " + e);
        }
    }
}

public class CodeThree {
    public static void main(String[] args) {
        MyThreadOne t1 = new MyThreadOne("Thread-1");
        t1.start();
        t1.join();
        System.out.println(Thread.currentThread().getName()+ ": " + Thread.currentThread().getState());
        System.out.println("Exiting main thread...");
    }

}
