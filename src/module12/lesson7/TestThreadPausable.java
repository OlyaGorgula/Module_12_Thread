package module12.lesson7;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestThreadPausable {
     public static void main(String[] args) throws InterruptedException {
        //System.out.println(Runtime.getRuntime().availableProcessors());

         List<String> itms = new CopyOnWriteArrayList<>(); // thread-safe потоко безпечна

         PausableThread pausableThread = new PausableThread();
         pausableThread.start();

        //Thread thread = new Thread(pausableThread);
        //thread.start();

        Thread.sleep(5000);
        pausableThread.setRunning(false);
         System.exit(0); //- завершає потоки

    }
}
