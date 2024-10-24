package module12.lesson3;

public class TestThread3 {


    public static void main(String[] args) {
        Counter1 counter = new Counter1();
        Thread thread0 =  new Thread(counter);
        Thread thread1 = new Thread(counter);

        thread0.start();
        thread1.start();
    }
}
