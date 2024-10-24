package module12.lesson4;

public class Car {
    private  boolean honking;
    private  String name;

    public Car(String name){
        this.name = name;
        this.honking = true;
    }

    public void passBridge(Car car){
        while (car.isHonking()){
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                //
            }
            System.out.println(car.getName()+" чекає проїхати мост");
        }
        System.out.println("Кінець ......"+name);
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("Error: ..");
        }
        System.out.println("Проїхала мост");
        this.honking = false;
    }

    public String getName() {
        return name;
    }

    public boolean isHonking(){
        return honking;
    }
}
