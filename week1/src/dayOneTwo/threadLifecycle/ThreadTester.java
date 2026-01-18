package dayOneTwo.threadLifecycle;

public class ThreadTester extends Thread{
    @Override
    public void run() {
        System.out.println("RUNNING");
        try {
            Thread.sleep(2000);
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void main(String[] args) throws InterruptedException{
        ThreadTester t1 = new ThreadTester();
        System.out.println(t1.getState()); // NEW
        t1.start();
        System.out.println(t1.getState()); // RUNNABLE
        System.out.println(currentThread().getState() + ": for main thread"); // getting state of the main thread
        Thread.sleep(100);
        System.out.println(t1.getState()); // TIME_WAITING
        t1.join(); // main thread waiting for t1 to execute completely
        System.out.println(t1.getState()); // TERMINATE
    }
}
