package module12.lesson8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicTest {
    private  static AtomicLong x = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {
        //long l = x.addAndGet(5);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i<100; i++){
            Thread thread = new Thread(() ->{
                for (int j = 0; j<100; j++){
                    //x = x + 1;
                    x.addAndGet(1);
                }
            });
            threads.add(thread);
        }

        for (Thread thread : threads){
            thread.start();
        }

        for (Thread thread : threads){
            thread.join();
        }
    }
}
