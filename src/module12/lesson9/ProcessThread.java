package module12.lesson9;

import java.util.concurrent.atomic.AtomicBoolean;

public class ProcessThread extends Thread{
    private int number;
    private AtomicBoolean processed = new AtomicBoolean(false);
    private NumberProessor processor;

    public ProcessThread(NumberProessor processor) {
        this.processor = processor;
    }

    public void process(int number){
        this.number = number;
        processed.set(false);
    }

    public boolean isProcessed(){
        return processed.get();
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (processed.get()){
                continue;
            }

           processor.process(number);

            processed.set(true);
        }
    }
}
