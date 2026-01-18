package dayThreeFour.thread_methods;
// Java code to see that all threads are
// pushed on same callstack if we use run()
// instead of start()

class ThreadTest extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " is running" );
        }catch(Exception e) {
            System.out.println("Exception is caught");
        }
    }
}

public class CodeOne {
    public static void main(String[] args) {
        int n = 8;
        for(int i=0; i<n; i++) {
            ThreadTest object = new ThreadTest();

            // start() is replaced with run() for
            // seeing the purpose of start
            object.start();
        }
    }
}

// if we use start() instead of run() then we get same name for all threads -> main thread
// the main function is executed by main thread.
// the other threads thus needed to be executed inside a different callstack and not the main callstack