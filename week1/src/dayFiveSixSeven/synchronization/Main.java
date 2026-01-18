package dayFiveSixSeven.synchronization;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(); // shared resource object
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        t1.start();
        t2.start();

        // I want main method to wait while t1 and t2 are executing and once their execution is finished,
        // I will print the final value of counter
        t1.join();
        t2.join();
        System.out.println("Total count: " +counter.getCount());
    }
}
