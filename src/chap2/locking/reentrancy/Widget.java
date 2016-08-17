package chap2.locking.reentrancy;

public class Widget {

    public synchronized void printName() {
        System.out.println(getClass().getSimpleName());
    }

}
