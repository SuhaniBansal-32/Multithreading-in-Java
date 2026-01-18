package dayThreeFour.thread_priorities.daemon_threads;

class DaemonExample extends Thread {
    public void run() {
        if(Thread.currentThread().isDaemon()) {
            System.out.println("Daemon Thread running...");
        }
        else {
            System.out.println("User Thread running...");
        }
    }
}

public class CodeTwo {
    public static void main(String[] args) {
        DaemonExample t1 = new DaemonExample();
        DaemonExample t2 = new DaemonExample();

        t1.setDaemon(true); // must be set before start

        t1.start();
        t2.start();

    }
}
