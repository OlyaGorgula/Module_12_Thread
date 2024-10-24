package module12.lesson7;

public class PausableThread extends Thread{
    private volatile static boolean running = true; // volatile - відна для всіх потоків

    @Override
    public void run() {
        while (true){
            if (running){
                System.out.println("In thread");
            }else {
                //break; //- завершає цикл з тим і поток
            };
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void setRunning(boolean running){
        this.running = running;
    }
}
