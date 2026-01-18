package dayThreeFour.shutdown_hook;

class CustomThread implements Runnable {
    @Override
    public void run() {
        // most imp : this will throw IllegalStateException
        // since the shutdown hook has been started by JVM, and
        // we are trying to remove it

        Runtime.getRuntime().removeShutdownHook(new Thread(this));
        System.out.println("JVM is shutting down...");
    }
}

public class RemovingShutdownHook {
    public static void main(String[] args) throws InterruptedException {
        try{
            Thread hook = new Thread(new CustomThread());
            // register message as shutdown hook
            Runtime.getRuntime().addShutdownHook(hook);
            // print the state of program
            System.out.println("Program is starting...");
            // making thread sleep for 3 seconds
            System.out.println("Waiting for 3 seconds...");
            Thread.sleep(3000);
            // print that the program is closing
            System.out.println("Program is closing...");

        }
        catch(Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
