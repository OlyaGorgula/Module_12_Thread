package module12.lesson3;

public class Counter1 implements Runnable {
    private int counter = 0;

    private final static Object MONITOR = new Object();
    //private final Object MONITOR = new Object(); // не статическа сінхр

    @Override
    public void run(){
        for (int i = 0; i < 5; i++){
            //synchronized (this){ // new сінхранізація не статичиский - об'єкт
            //synchronized (Counter.class) = synchronized (MONITOR)
//            synchronized (MONITOR){ // статическая сінхронізація
//                increment();
//            }
            increment(); // сінхранізація по методу
            System.out.println(Thread.currentThread().getName()+" - "+ counter);
        }
    }

    private synchronized void increment(){ // static чи без
        try {
            Thread.sleep(20);
        }catch (InterruptedException e){
            System.out.println("Error: ");
        }

        counter++;
    }
}
