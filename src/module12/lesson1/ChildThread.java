package module12.lesson1;

public class ChildThread extends Thread{

    @Override
    public void run(){
        final Thread thisThread = Thread.currentThread();
        System.out.println("Назва дочернього потока: "+thisThread.getName());
        int count = 1;
        System.out.println("Початок цикла");
        //флаг остановлен чи поток
        while (!thisThread.isInterrupted()){
            System.out.println("цикла на count="+count);
            if (!threadSleep(thisThread)){
                System.out.println("Прерван цикл.");
                break;
                //або
                //thisThread.isInterrupted();
            };
            count++;
        }
    }

    private boolean threadSleep(Thread thread){
        try {
            System.out.println("Цикл заснув!!");
            thread.sleep(2);
            System.out.println("Цикл прокинувся!!");
            return true;
        }catch (InterruptedException ex){
            ex.printStackTrace();
            System.out.println("Error : "+Thread.currentThread().getName() + " interrupted");
            System.out.println("Error : "+"isInterrupted flag "+Thread.currentThread().isInterrupted());
            return false;
        }
    }
}
