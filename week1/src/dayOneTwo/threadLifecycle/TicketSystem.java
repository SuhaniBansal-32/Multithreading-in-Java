package dayOneTwo.threadLifecycle;

// Java Program to demonstrate thread states
// using a real-world ticket booking scenario

class TicketBooking implements Runnable {
    @Override
    public void run() {
        try {

            // Timed waiting
            Thread.sleep(200);
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("State of bookingThread while mainThread is waiting: " + TicketSystem.mainThread.getState());
        try {

            // Another timed waiting
            Thread.sleep(100);
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}


public class TicketSystem implements Runnable {
    public static Thread mainThread;
    public static TicketSystem ticketSystem;

    @Override
    public void run() {
        TicketBooking booking = new TicketBooking();
        Thread bookingThread = new Thread(booking); // NEW

        System.out.println("State after creating booking thread : " + bookingThread.getState());

        bookingThread.start(); // RUNNABLE
        System.out.println("State after starting booking thread : " + bookingThread.getState());

        try {
            Thread.sleep(100);
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("State after sleeping bookingThread: " + bookingThread.getState()); // TIME_WAITING

        try {

            // Moves mainThread to waiting state
            bookingThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("State after bookingThread finishes: " + bookingThread.getState());

    }

    public static void main(String[] args) {
        ticketSystem = new TicketSystem();
        mainThread = new Thread(ticketSystem);

        System.out.println("State after creating mainThread : " + mainThread.getState());
        mainThread.start();
        System.out.println("State after starting mainThread : " + mainThread.getState());

    }

}

/*
    Conclusion:
    If a thread instance has to wait inside the another class : TIMED_WAITING state
    If a thread waits inside its own class : WAITING state
*/
