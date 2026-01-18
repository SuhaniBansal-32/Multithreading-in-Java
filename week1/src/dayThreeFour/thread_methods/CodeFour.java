package dayThreeFour.thread_methods;
// Java program to explain the
// concept of joining a thread.

class ThreadJoining extends Thread {
    @Override
    public void run() {
        for(int i = 0; i<2; i++) {
            try{
                Thread.sleep(500);
                System.out.println("Current Thread: " + Thread.currentThread().getName());
            }
            catch(InterruptedException e){
                System.out.println("Caught: " + e);
            }
            System.out.println(i);
        }
    }
}

public class CodeFour {
    public static void main(String[] args) throws InterruptedException {
        ThreadJoining t1 = new ThreadJoining();
        ThreadJoining t2 = new ThreadJoining();
        ThreadJoining t3 = new ThreadJoining();

        // thread t1 starts
        t1.start();

        // starts second thread after when
        // first thread t1 has died.

        t1.join();

        // t2 starts
        t2.start();

        // starts t3 after when thread t2 has died
        t2.join();

        // t3 starts
        t3.start();

        // After t2 has dead t3 starts
        t3.join();

        System.out.println("Main thread exiting...");

    }
}

