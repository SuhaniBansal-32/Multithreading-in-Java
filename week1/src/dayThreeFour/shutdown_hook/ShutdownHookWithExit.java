package dayThreeFour.shutdown_hook;

public class ShutdownHookWithExit {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutdown hook executed...");
        }));
        System.out.println("Before System.exit()");
        System.exit(0);
        System.out.println("After System.exit()"); // never executes
    }
}

// Shutdown hook runs even with system.exit()