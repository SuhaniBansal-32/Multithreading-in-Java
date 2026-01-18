package dayOneTwo.threadLifecycle;

class ThreadDemo implements Runnable {
    private String threadName;
    private Thread t;
    public ThreadDemo(String name) {
        threadName = name;
        System.out.println("Thread: " + threadName + ", " + "State: New");
    }

    public void run() {
        System.out.println("Thread: " + threadName + ", " + "State: Running");
        try{
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while
                System.out.println("Thread: " + threadName + ", " + "State: Waiting");
                Thread.sleep(50);
            }
        }
        catch(InterruptedException e) {
            System.out.println("Thread: " + threadName + ", " + "State: Interrupted");
        }

        System.out.println("Thread: " + threadName + ", " + "State: Terminated");

    }

    public void start() {
        System.out.println("Thread: " + threadName + ", " + "State: Start");
        if(t == null) {
            t = new Thread(this,threadName);
            t.start();
        }
    }
}

public class Example {
    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo("Thread-1");
        ThreadDemo t2 = new ThreadDemo("Thread-2");
        t1.start();
        t2.start();
    }
}
