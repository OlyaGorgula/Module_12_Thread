package module12.lesson4;

public class TestThreadDeadlock {

    // Deadlock - Взаємне блокування
    private final static Object MONITOR1 = new Object();
    private final static Object MONITOR2 = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
          synchronized (MONITOR1) {
            System.out.println("Поток 1 заблокіровав монітор 1");
              try {
                  Thread.sleep(20);
              } catch (InterruptedException e) {
                  System.out.println("Error: ");
              }
              synchronized (MONITOR2) {
                  System.out.println("Поток 1 заблокіровав монітор 2");
              }
          }

      });

        Thread thread2 = new Thread(() -> {
            synchronized (MONITOR2) {
                System.out.println("Поток 2 заблокіровав монітор 2");
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    System.out.println("Error: ");
                }
                synchronized (MONITOR1) {
                    System.out.println("Поток 2 заблокіровав монітор 1");
                }
            }
        });


    }
}
