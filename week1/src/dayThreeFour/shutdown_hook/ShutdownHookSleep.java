package dayThreeFour.shutdown_hook;

class MyThread extends Thread{
  @Override
  public void run() {
      System.out.println(Thread.currentThread().getName() + " is running...");
      for(int i = 0; i < 10; i++) {
          System.out.println(getName() + i);
          try{
              Thread.sleep(1000);
          }
          catch(Exception e){
              System.out.println("Caught: " + e.toString());
          }
      }
  }
}

public class ShutdownHookSleep{
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Main thread is running...");
        MyThread t1 = new MyThread();

        // initiating the JVM shutdown hook thread
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutdown hook is running...");
            System.out.println("program terminated successfully!");
        }));

        t1.start();
        t1.join();
        System.out.println("main method finished executing...");
    }
}

// even though the program is explicitly terminated, JVM will still execute shutdown hook before terminating