package module12.lesson5;

public class TestThreadDemon {

    //Demon
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 10; i++){
                System.out.println("Поток "+Thread.currentThread().getName()+" run = "+i);
                try {
                    Thread.sleep(1);
                }catch (InterruptedException e){
                    System.out.println("Erro****");
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        try {
            //Приєднання потоків
            thread.join(); // main не завершає роботу пока цей поток не завершит роботу
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Finish thread = "+Thread.currentThread().getName());

    }
}
