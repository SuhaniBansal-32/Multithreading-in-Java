package dayThreeFour.thread_priorities.daemon_threads;
// Behavior of Daemon Thread

class DaemonBehavior extends Thread {
    public void run() {
        while(true) {
            System.out.println("Daemon Thread running...");
        }
    }
}

public class CodeThree {
    public static void main(String[] args) {
        DaemonBehavior t = new DaemonBehavior();
        t.setDaemon(true);
        t.start();

        System.out.println("Main (user) thread ends...");
    }
}

// The JVM ends immediately after the main thread finishes,
// even though the daemon thread is still running
