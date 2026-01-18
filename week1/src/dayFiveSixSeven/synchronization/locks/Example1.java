package dayFiveSixSeven.synchronization.locks;

class BankAccount{
    private int balance = 100;

    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw: " + amount);
        if(balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " proceeding with withdraw...");
            try {
                Thread.sleep(10000);
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
        }
        else {
            System.out.println(Thread.currentThread().getName() + " insufficient balance");
        }
    }
}

public class Example1 {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        // using runnable interface as an anonymous class. We can't make objects of an interface
        // directly implementing runnable interface: Anonymous Class
        Runnable task = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdraw(50);
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
    }
}

// due to implicit synchronization block, one thread has to wait
// until the execution of other thread is completed and thus
// this halts the concept of multithreading. Thus, we use explicit
// locking mechanism to achieve multithreading in case of critical
// section code where race condition may occur.