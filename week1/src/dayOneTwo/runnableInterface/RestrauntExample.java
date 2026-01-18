package dayOneTwo.runnableInterface;
class CookingJob implements Runnable{
    String task;
    public CookingJob(String task){
        this.task = task;
    }
    @Override
    public void run() {
        System.out.println(task + " is being prepared by : " + Thread.currentThread().getName());
    }
}

public class RestrauntExample {
    public static void main(String[] args) {
        System.out.println("Inside " + Thread.currentThread().getName() + " thread.");
        Thread t1 = new Thread(new CookingJob("Soup")); // Thread - 0
        Thread t2 = new Thread(new CookingJob("Pizza")); // Thread - 1
        Thread t3 = new Thread(new CookingJob("Burger")); // Thread - 2
        t1.start();
        t2.start();
        t3.start();
    }
}
