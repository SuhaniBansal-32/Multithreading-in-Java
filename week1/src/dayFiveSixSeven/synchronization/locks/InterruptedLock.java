package dayFiveSixSeven.synchronization.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount3 {
    private final Lock lock = new ReentrantLock();
    private int balance = 1000;

    public void withdraw(int amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+ " attempting to withdraw ");
       try{
           lock.lockInterruptibly();

           if(balance >= amount){
               System.out.println(Thread.currentThread().getName()+ " proceeding withdraw...");
               Thread.sleep(3000);
               balance -= amount;
               System.out.println(Thread.currentThread().getName()+" completed withdrawal. Remaining balance: " + balance);
           }
           else {
               System.out.println(Thread.currentThread().getName()+" not enough balance");
           }
       }
       catch(InterruptedException e){
           System.out.println("Can't process withdraw, try again later.");
           throw e; // Rethrow the same exception object
       }
       finally {
           lock.unlock();
       }
    }
}

public class InterruptedLock {
    public static void main(String[] args) throws InterruptedException {
        BankAccount3 sbi = new BankAccount3();
        Runnable task = new Runnable() {
            @Override
            public void run() {

                try{
                    sbi.withdraw(1000);
                }
                catch(InterruptedException e){
                    System.out.println(e);
                }
            }
        };

        Thread t1 = new Thread(task,"Thread 1");
        Thread t2 = new Thread(task,"Thread 2");
        t1.start();
        t2.start();

        // main method will sleep for 2 secs and after that it will interrup thread t2

        try{
            Thread.sleep(10000);
            t2.interrupt();
        }
        catch (InterruptedException e) {
            System.out.println("Waiting time to acquire lock finished...");
            System.out.print(e.getMessage());
        }

    }
}

// How to re-throw an exception in Java?