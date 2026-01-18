package dayFiveSixSeven.synchronization;

class Counter {
    private int count = 0;
    public synchronized int increment() {
        return ++count;
    }

    public int getCount() {
        return count;
    }
}
