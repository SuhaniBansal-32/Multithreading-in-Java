package dayThreeFour.shutdown_hook;

class ShutdownHookThread implements Runnable {
    String threadname;
    Thread t;
    public ShutdownHookThread(String threadname) {
        this.threadname = threadname;
    }

    @Override
    public void run() {
        System.out.println("Shutdown hook has started...");
        System.out.println(threadname + " ,is running...");
        try{
            Thread.sleep(2000);
            // JVM waits for shutdown hooks to finish before exiting.
        }
        catch(Exception e){
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println("Shutdown hook is completed.");
    }
}


class UserThread extends Thread {

    public UserThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running...");
        try{
            for(int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ", count:" + i);
                Thread.sleep(1000);
            }
        }
        catch(Exception e){
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println("User thread terminated...");
    }
}

public class ShutdownHookWithSleep1 {
    public static void main(String[] args) throws Exception {
        System.out.println("main thread started...");
        ShutdownHookThread s = new ShutdownHookThread("SHThread");
        UserThread t1 = new UserThread("T1");
        Thread fileCloseThread = new Thread(() -> {
            System.out.println("closing file: \"sample.txt\"");
        });

        Runtime.getRuntime().addShutdownHook(new Thread(s));

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutdown hook 2 has started for file closing...");
            fileCloseThread.start();
        }));

        t1.start();
//        t1.join();
        System.out.println("main thread finished executing...");

    }
}


