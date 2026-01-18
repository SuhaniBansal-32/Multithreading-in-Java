package dayFiveSixSeven.synchronization.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class ReentrantExample {
    private final Lock lock = new ReentrantLock();

    public synchronized void outerMethod() {
        lock.lock();
        try{
            System.out.println("Outer method");
            innerMethod();
            System.out.println("Outer method finished..");
        }
        finally{
            lock.unlock();
        }

    }

    public synchronized void innerMethod() {
        lock.lock();
        try{
            System.out.println("Inner method");
        }
        finally{
            lock.unlock();

        }
    }



    public static void main(String[] args) {
        ReentrantExample example = new ReentrantExample();
        example.outerMethod();
    }
}

// each lock count is paired with its unlock