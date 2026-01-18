package dayThreeFour.thread_methods;
// Using the Thread.sleep() Method for a custom thread

class YourThread extends Thread {
    @Override
    public void run() {
        try{
            for(int i=0 ;i<5; i++){
                Thread.sleep(1000);
                System.out.print(i + " ");
            }
        }
        catch(InterruptedException e) {
            System.out.println("Caught: " + e);
        }
    }
}

public class CodeSeven {
    public static void main(String[] args) throws InterruptedException {
        YourThread t1 = new YourThread();
        t1.start();
        Thread.sleep(8000);
        System.out.println("\nMain thread exiting...");
    }
}
