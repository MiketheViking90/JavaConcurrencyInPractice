package chap1.risksofthreads;

public class UnsafeSequence {

    private int value;

    public int getValue() {
        return value++;
    }

}
