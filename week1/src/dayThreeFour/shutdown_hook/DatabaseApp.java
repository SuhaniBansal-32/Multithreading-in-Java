package dayThreeFour.shutdown_hook;

public class DatabaseApp {
    static void closeDatabase() {
        System.out.println("Database connection closed...");
    }

    public static void main(String[] args) {
        System.out.println("main thread started...");
        Runtime.getRuntime().addShutdownHook(
                new Thread(DatabaseApp::closeDatabase)
        );

        System.out.println("application running in main thread...");
    }
}
