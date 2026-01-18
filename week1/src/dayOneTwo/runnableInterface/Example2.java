package dayOneTwo.runnableInterface;

class RunnableClass implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside run method.");
    }
}

public class Example2 {
    public static void main(String[] args) {
    Runnable r1 = new RunnableClass();
    Thread t1 = new Thread(r1,"my_thread");
    t1.start();
    System.out.println(t1.getName());
    System.out.println(Thread.currentThread().getName());
    }
}
