package module12.lesson2;

public class ChildRunnable implements Runnable{
    @Override
    public void run(){
        Thread thisRunnable = Thread.currentThread();
        System.out.println("Дочерний поток "+thisRunnable.getName());

    }
}
