package chap2.locking.reentrancy;

public class LoggingWidget extends Widget {

    @Override
    public synchronized void printName() {
        System.out.println(getClass().getSimpleName());
        super.printName();
    }

    public synchronized void method1() {
        System.out.println("method 1");
        method2();
    }

    public synchronized void method2() {
        System.out.println("This would deadlock without reentrancy");
    }

    public static void main(String[] args) {
        LoggingWidget logWidget = new LoggingWidget();
        logWidget.printName();
        logWidget.method1();
    }

}
