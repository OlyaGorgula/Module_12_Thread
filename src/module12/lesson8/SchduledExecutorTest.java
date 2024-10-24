package module12.lesson8;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchduledExecutorTest {
    public static void main(String[] args) {
        // поставити в поток з затримкою часа
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        // ставіт задачу один раз
        service.schedule(
                () -> System.out.println("Excecutored!"),
                1,
                TimeUnit.SECONDS
        );

        // чи готова задача?
        //service.isShutdown();

        // повторно поставіти задачу
        service.scheduleAtFixedRate(
                () -> System.out.println(System.currentTimeMillis()),
                0, // ставимо задачу через
                1,   // через яку кількість часу виконати повторно задачу
                TimeUnit.SECONDS
        );

        service.scheduleWithFixedDelay(
                () -> System.out.println(System.currentTimeMillis()),
                0, // ставимо задачу через
                1,   // через яку кількість часу виконати повторно задачу після виконання задачі
                TimeUnit.SECONDS
        );

        // двa поточний
        ScheduledExecutorService service1 = Executors.newScheduledThreadPool(2);




    }
}
