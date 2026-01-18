package dayOneTwo.runnableInterface;

class World implements Runnable {
    @Override
    public void run() {
        System.out.println("world!");
    }
}

public class Example1 {
    public static void main(String[] args) {
        World world = new World();
        Thread t1 = new Thread(world);
        System.out.println("Hello," + Thread.currentThread().getName());
        t1.start();
    }

}
