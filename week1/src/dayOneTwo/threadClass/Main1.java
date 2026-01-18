package dayOneTwo.threadClass;

class T1 extends Thread{
    public T1(String name) {
        super(name);
    }
    @Override
    public void run() {
        for(int i = 0; i<5; i++) {
            System.out.println("inside " + " " + Thread.currentThread().getName() + " " + i);
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        T1 thread1 = new T1("firstThread");
//        thread1.setDaemon(true);
        System.out.println("Main function executing");
        thread1.start();
        System.out.println("exiting main function");
    }
}
