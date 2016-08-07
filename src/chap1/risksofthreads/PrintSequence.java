package chap1.risksofthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintSequence implements Runnable {

    private UnsafeSequence sequence = new UnsafeSequence();

    @Override
    public void run() {
        int val = sequence.getValue();
        System.out.println(val);
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PrintSequence ps = new PrintSequence();
        exec.execute(ps);
        exec.execute(ps);
        exec.execute(ps);
        exec.execute(ps);
        exec.execute(ps);
    }
}
