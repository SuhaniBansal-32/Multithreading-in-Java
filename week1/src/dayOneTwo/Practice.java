package dayOneTwo;

// Creating 3 threads that print numbers concurrently

class ThreadTester implements Runnable {
    String name;
    public ThreadTester(String name) {
        this.name = name;
    }

    public void run() {
        for(int i = 1; i<=5; i++) {
            System.out.println("Thread: " + name + ", " + i);
        }
    }
}

public class Practice {
    public static void main(String[] args) {
        Thread t1 = new Thread (new ThreadTester("Thread-1"));
        Thread t2 = new Thread (new ThreadTester("Thread-2"));
        Thread t3 = new Thread(new ThreadTester("Thread-3"));

        t1.start();
        t2.start();
        t3.start();
    }
}
