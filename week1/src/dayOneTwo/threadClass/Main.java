package dayOneTwo.threadClass;

class Cook extends Thread{
    String task;
    public Cook(String task) {
        this.task = task;
    }
    @Override
    public void run() {
        System.out.println("I am cooking "+ task + ", Chef : " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        // making new user threads
        Thread t1 = new Cook("pasta");
        Thread t2 = new Cook("pizza");
        Thread t3 = new Cook("burger");
        // the order of execution of other user threads is random and not sequential
        t1.start();
        t2.start();
        t3.start();
        System.out.println(Thread.currentThread().getName());
        System.out.println("Welcome to the cooking world!");
    }
}

// parent class     child class
// hierarchy : high     low
// parent class obj with child class constructor - possible
// child class obj with parent class constructor - not possible
