public class Task1 {
//    Напишіть програму, яка кожну секунду відображає на екрані дані про час, що минув від моменту запуску програми.
//    Другий потік цієї ж програми кожні 5 секунд виводить повідомлення Минуло 5 секунд.

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Thread thread1sec = new Thread(() ->{
            long period = 0;
            while (period<=15000){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                long current = System.currentTimeMillis();
                period = current-start;
                System.out.println("1 thread. Time has passed: "+period/1000+" sec");
            }

        });
        thread1sec.start();

        Thread thread5sec = new Thread(() ->{
            long period = 0;
            while (period<=15000){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                long current = System.currentTimeMillis();
                period = current-start;
                System.out.println("  2 thread. Time has passed: "+period/1000+" sec");
            }

        });
        thread5sec.start();
    }
}
