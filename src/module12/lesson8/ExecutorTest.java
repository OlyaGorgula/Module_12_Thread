package module12.lesson8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // однопоточний
//        ExecutorService executor = Executors.newSingleThreadExecutor();
        // брати кількість потоків, що там є. // cтворили 2 потоки
        ExecutorService executor = Executors.newFixedThreadPool(2);


//        Future<Long> submit = executor.submit(new SumCallable(4, 6));
//        System.out.println("submit.get() = "+submit.get());

        //*****************************************
        //executor.execute(()-> System.out.println(Thread.currentThread().getName()));

        List<Future<?>> futures = new ArrayList<>();
        for (int i = 1; i<=10; i++){
            // ставіт задачі
            Future<?> f = executor.submit(new PritRunnable(i));
            futures.add(f);
            //executor.execute(new PritRunnable(i));
        }

        while (true){
            // порахувати скільки потоків не завершено
            long finishedCount = futures.stream().filter(Future::isDone).count();

            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
//**************************************


    }
}
