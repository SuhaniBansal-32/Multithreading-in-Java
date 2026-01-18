package dayOneTwo.threadClass;
// creating thread by extending the thread class
// creating a new thread

public class World extends Thread{
    @Override
    public void run() {
        System.out.println("world!");
    }
}
