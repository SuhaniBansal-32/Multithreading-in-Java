package dayOneTwo.threadClass;

class Shopkeeper extends Thread{
    String role;
    Shopkeeper(String role) {
        this.role = role;
    }

    @Override
    public void run() {
        System.out.println("Welcome to the supermarket. \nI am shopkeeper : " + Thread.currentThread().getName() + "\nMy role is " + role );
    }
}

public class SuperMarket {
    public static void main(String[] args) {
        System.out.println("Welcome to the main thread");
        Shopkeeper s1 = new Shopkeeper("Assistant 1");
        Shopkeeper s2 = new Shopkeeper("Bill Keeper");
        s1.start();
        s2.start();
    }
}
