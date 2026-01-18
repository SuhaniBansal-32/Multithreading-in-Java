package dayThreeFour.thread_priorities;

class MyThread2 extends Thread {
    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread is running...");
        for(int i = 1; i <= 5; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.println(Thread.currentThread().getName() + ":"
                        + " - Priority: "
                        + Thread.currentThread().getPriority()
                        + " - count: " + i
                );

                try {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e) {
                    System.out.println("Caught: " + e);
                }

            }
        }
    }
}

public class CodeThree {
    public static void main(String[] args) {
        MyThread2 l = new MyThread2("Low Priority Thread");
        MyThread2 m = new MyThread2("Medium Priority Thread");
        MyThread2 n = new MyThread2("High Priority Thread");

        l.setPriority(Thread.MIN_PRIORITY); // 1
        m.setPriority(Thread.NORM_PRIORITY); // 5
        n.setPriority(Thread.MAX_PRIORITY); // 10

        l.start();
        m.start();
        n.start();

    }
}
