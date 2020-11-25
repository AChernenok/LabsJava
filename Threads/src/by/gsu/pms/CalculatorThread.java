package by.gsu.pms;

public class CalculatorThread extends Thread {
    private long result = 0;
    private final int maxValue;
    private final int minValue;

    public long getResult() {
        return this.result;
    }

    public CalculatorThread(int minValue, int maxValue) {
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread " + threadName + " starting..");
        for (int i = this.minValue; i <= maxValue; i++) {
            if ((i % 10 + i / 10) > 10) {
                System.out.print(i + ", ");
                this.result += i;
            }
        }
    }
}
