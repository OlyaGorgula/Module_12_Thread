package module12.lesson8;

public class PritRunnable implements Runnable {
    private Object item;

    public PritRunnable(Object item) {
        this.item = item;
    }

    @Override
    public void run() {
        System.out.println("item = "+item);
        try {
           Thread.sleep(1000); // 1cek
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
