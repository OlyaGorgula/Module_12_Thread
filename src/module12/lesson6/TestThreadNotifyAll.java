package module12.lesson6;

public class TestThreadNotifyAll {
    Parking parking = new Parking(5);

    public static void main(String[] args) {
        TestThreadNotifyAll parkingDemo= new TestThreadNotifyAll();

        for (int i = 0; i < 15; i++){
            Thread car = new Thread(() -> {
                try {
                    parkingDemo.parking();
                }catch (InterruptedException e){
                    //
                }
            });

            car.start();
        }
    }

    public void parking() throws InterruptedException{
        parking.joinparking(); // машина заблокувала місце
        System.out.println("Мшина "+Thread.currentThread().getName()+" заїхала на парковку");
        Thread.sleep(3000);
        parking.leaveParking();
        System.out.println("Мшина "+Thread.currentThread().getName()+" виїхала з парковки");

    }
}
