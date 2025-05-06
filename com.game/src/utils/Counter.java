package utils;

/**
 * Simple class that is used for counting things.
 */
public class Counter {
    private int counter = 0;

    /**
     * add number to current count.
     * @param number
     */
    public void increase(int number) {
        counter += number;
    }

    /**
     * subtract number from current count.
     * @param number the number we want to subtract
     */
    public void decrease(int number) {
        counter -= number;
    }

    /**
     * @return the current count
     */
    public int getValue() {
        return this.counter;
    }

    @Override
    public String toString() {
        return String.valueOf(counter);
    }
}