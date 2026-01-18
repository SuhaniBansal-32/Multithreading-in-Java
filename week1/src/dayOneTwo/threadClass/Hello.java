package dayOneTwo.threadClass;

public class Hello {
    public static void main(String[] args) {
        Thread t1= new World();
        t1.start();
        System.out.println("Hello");
    }
}
