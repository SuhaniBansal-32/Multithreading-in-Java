package dayFiveSixSeven.synchronization;

public class Stack {
    private static int [] array;
    private static int stackTop;
//    Object lock;

    public Stack(int capacity) {
        array = new int[capacity];
        stackTop = -1;
//        lock = new Object();
    }

    public static boolean isEmpty() {
        return stackTop < 0;
    }

    public static boolean isFull() {
        return stackTop >= array.length -1;
    }

    public synchronized static boolean push(int element) {
        // using synchronized block to prevent race condition
            if(isFull()) return false;
            ++ stackTop;
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                System.out.println("Caught: " + e);
            }
            array[stackTop] = element;
            return true;

    }

    public synchronized static int pop() {
        // using synchronized block to prevent race condition
        // internally -> synchronize(this){}

            if(isEmpty()) return Integer.MIN_VALUE;
            int obj = array[stackTop];
            array[stackTop] = Integer.MIN_VALUE;
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
                System.out.println("Caught: " + e);
            }
            --stackTop;
            return obj;

    }

    public static void main(String[] args) {
        System.out.println("main is starting...");
        Stack stack = new Stack(10);
        // creating a thread for pushing elements in stack
        new Thread(() -> {
            int counter = 0;
            while(++counter < 10){
                System.out.println("Pushed: " + stack.push(100));
            }
        },"Pusher").start();

        // creating a thread to pop out elements from stack
        new Thread(() -> {
            int counter = 0;
            while(++counter < 10) {
                System.out.println("Popped: " + stack.pop());
            }
        },"Popper").start();
        System.out.println("main is exiting...");
    }
}

// code written inside synchronized block is critical section code and only the thread which have acquired lock will
// be able to execute the critical section code
// any object can be used as lock to execute critical section block
// here, both the methods push and pop are bound by the same lock, so at one time only one method will run
// here same lock has to be used for both push and pop so that only one of the method executes at a time so that
// push and pop methods don't become inconsistent and code runs successfully
// "this" means using instance of current class as Lock
// thus the lock(this) will be same for all synchronized methods in class with; thus one synchronized method will be
// executed by thread at once
// synchronized with static method internally uses: Stack.class i.e. ClassName.class
// Conclusion:
// static methods: have no objects. ClassName.class is used as lock e.g. Stack.class
// non-static methods: instance of the current class (this) is used as lock.