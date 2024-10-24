package module12.lesson8;

import java.util.concurrent.Callable;

public class SumCallable implements Callable<Long> {
    private long a;
    private long b;

    public SumCallable(long a, long b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Long call() {
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return a+b;
    }
}
