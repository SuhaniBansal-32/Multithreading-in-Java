package dayFiveSixSeven.synchronization.locks.fairnessOfLocks;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class UnfairLockExample {
    private final Lock  lock = new ReentrantLock();

    public void accessResource() {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            Thread.sleep(1000);
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println(Thread.currentThread().getName() + " released the lock.");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        UnfairLockExample example = new UnfairLockExample();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };

        Thread t1 = new Thread(task,"Thread 1");
        Thread t2 = new Thread(task,"Thread 2");
        Thread t3 = new Thread(task,"Thread 3");
        t1.start();
        t2.start();
        t3.start();
    }
}
