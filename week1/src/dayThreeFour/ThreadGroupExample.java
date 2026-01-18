package dayThreeFour;

public class ThreadGroupExample implements Runnable{
    public static void main(String[] args) {
        ThreadGroupExample tg = new ThreadGroupExample();
        tg.func();
    }

    public void func() {
        try{
            // create a parent ThreadGroup

            ThreadGroup pGroup = new ThreadGroup("Parent ThreadGroup");

            // create a child ThreadGroup
            ThreadGroup cGroup = new ThreadGroup(pGroup,"Child ThreadGroup");

            Thread t1 = new Thread(pGroup,this);
            System.out.println("Starting " + t1.getName() + "...");
            t1.start();

            // create another thread
            Thread t2 = new Thread(cGroup,this);
            System.out.println("Starting " + t2.getName() + "...");
            t2.start();

            // display the number of active threads
            System.out.println("Active threads in \"" + pGroup.getName() + "\" = " + pGroup.activeCount()) ;
            System.out.println("Active threads in \"" + cGroup.getName() + "\" = " + cGroup.activeCount());

            // block until the other threads finish
            t1.join();
            t2.join();
        }
        catch(InterruptedException e){
            System.out.println(e.toString());
        }
    }

//    implements run()
    public void run() {
        for(int i = 0; i < 1000; i++) {
            i++;
        }
        System.out.println(Thread.currentThread().getName() + " finished executing.");
    }
}
