package module12.lesson4;

public class TestThreadLiveLock {

    // LiveLock - колесо взаімне
    private static Car bmw = new Car("BMW");
    private static Car mersedes = new Car("Mersedes");

    public static void main(String[] args) {
        new Thread(() ->{bmw.passBridge(mersedes);}).start();
        new Thread(() ->{mersedes.passBridge(bmw);}).start();

    }
}
