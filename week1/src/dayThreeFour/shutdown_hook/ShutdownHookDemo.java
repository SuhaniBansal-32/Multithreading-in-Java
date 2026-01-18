package dayThreeFour.shutdown_hook;

public class ShutdownHookDemo {
    public static void main(String[] args) {
        // initializing the shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutdown hook is running...");
            System.out.println("Cleaning up resources...");
        }));

        System.out.println("main method is running...");
    }
}
