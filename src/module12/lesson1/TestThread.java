package module12.lesson1;

public class TestThread {


    public static void main(String[] args) {
        System.out.println("Main поток стартовав - "+Thread.currentThread().getName());
        System.out.println("Main ріоритет - "+Thread.currentThread().getPriority());

        Thread.currentThread().setPriority(10);

        ChildThread childThread = new ChildThread();
        //старт
        childThread.start();

        try {
            Thread.currentThread().sleep(5);
            //стоп
            System.out.println("Прервати поток з циклом.");
            childThread.interrupt(); // якщо стопнуть поток в час сно, то видає помилку
            boolean stopChildTread =  childThread.isInterrupted();
            Thread.currentThread().sleep(5);
        }catch (InterruptedException ex){
            System.out.println("Thread has been interrupted ...");
        }

        System.out.println("Main поток завершон");
    }
}
