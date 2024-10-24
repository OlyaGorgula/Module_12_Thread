package module12.lesson2;

public class TestThread2 {


    public static void main(String[] args) {
        Runnable run = new ChildRunnable();

        Thread childTread = new Thread(run);
        childTread.start();
    }
}
