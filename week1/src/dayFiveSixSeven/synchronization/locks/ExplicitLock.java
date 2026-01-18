package dayFiveSixSeven.synchronization.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccountTwo{
    private final Lock lock = new ReentrantLock();
    private int balance = 100;
    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName()+" attempting to withdraw");
        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if(balance >= amount){
                    try{
                        System.out.println(Thread.currentThread().getName()+" proceeding with withdraw...");
                        Thread.sleep(3000); // Simulate time taken to process the withdrawal
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName()+" completed withdrawal. Remaining balance: " + balance);
                    }
                    catch(InterruptedException e){
                        System.out.println(e.getMessage());
                        // restoring thread's state to interrupt instead of just printing the final message
                        Thread.currentThread().interrupt();
                    }
                    finally{
                        lock.unlock();
                    }
                }
                else {
                    System.out.println(Thread.currentThread().getName()+" insufficient balance");
                }
            }
            else {
                System.out.println(Thread.currentThread().getName()+" couldn't acquire the lock, will try again later.");
            }
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
            // restoring thread's state to interrupt instead of just printing the final message
            Thread.currentThread().interrupt();
        }

        if(Thread.currentThread().isInterrupted()){
            // now we can perform cleanup or other tasks if thread is in interrupted state
            System.out.println(Thread.currentThread().getName()+" interrupted");
        }


    }
}

public class ExplicitLock {
    public static void main(String[] args) {
        BankAccountTwo sbi = new BankAccountTwo();
        Runnable task = new Runnable(){
            @Override
            public void run(){
                sbi.withdraw(50);
            }
        };
        Thread t1 = new Thread(task,"Thread 1");
        Thread t2 = new Thread(task,"Thread 2");
        t1.start();
        t2.start();
    }
}
