package dayThreeFour.thread_methods;

// Using Thread.sleep() Method for sleeping the Main Thread

public class CodeSix {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i<5; i++) {
            Thread.sleep(1000);
            System.out.print(i + " ");
        }
        System.out.println("\nMain thread is exiting...");
    }
}
