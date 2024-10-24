package module12.lesson6;

public class Parking {
    private int amountOfCars = 0;
    private int blockedPlaces = 0;
    private final Object MONITOR = new Object();

    public Parking(int amountOfCars) {
        this.amountOfCars = amountOfCars;
    }

    public void joinparking() throws InterruptedException{
        synchronized (MONITOR) {
            while (blockedPlaces == amountOfCars) {
                System.out.println("Парковка повністю зайнята!");
                MONITOR.wait(); // зупиняєм потік
            }
            blockedPlaces++;
            MONITOR.notifyAll(); // продовжуєм  потік
        }
    }

    public void leaveParking() throws InterruptedException{
        synchronized (MONITOR){
            while (blockedPlaces == 0){
                MONITOR.wait();
            }

            blockedPlaces--;
            MONITOR.notifyAll();
        }
    }

}
