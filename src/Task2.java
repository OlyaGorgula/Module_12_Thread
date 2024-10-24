import java.util.concurrent.*;

public class Task2 {
//    Напишіть програму, що виводить в консоль рядок, що складається з чисел від 1 до n, але з заміною деяких значень:
//
//    якщо число ділиться на 3 - вивести fizz
//    якщо число ділиться на 5 - вивести buzz
//    якщо число ділиться на 3 і на 5 одночасно - вивести fizzbuzz
//    Наприклад, для n = 15, очікується такий результат: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.
//
//    Програма повинна бути багатопотоковою, і працювати з 4 потоками:
//
//    Потік A викликає fizz(), щоб перевірити, чи ділиться число на 3, і якщо так - додати в чергу на виведення для потоку D рядок fizz.
//    Потік B викликає buzz(), щоб перевірити, чи ділиться число на 5, і якщо так - додати в чергу на виведення для потоку D рядок buzz.
//    Потік C викликає fizzbuzz(), щоб перевірити, чи ділиться число на 3 та 5 одночасно, і якщо так - додати в чергу на виведення для потоку D рядок fizzbuzz.
//    Потік D викликає метод number(), щоб вивести наступне число з черги, якщо є таке число для виведення.

    public static volatile String resNumber = "";

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService A = Executors.newSingleThreadExecutor();
        ExecutorService B = Executors.newSingleThreadExecutor();
        ExecutorService C = Executors.newSingleThreadExecutor();

        ExecutorService D = Executors.newSingleThreadExecutor();

        for (int n = 1; n <= 15; n++){
            resNumber = "";
            Future<String> taskA = A.submit(new PrintNumber(n, Task2::fizz));
            Future<String> taskB = B.submit(new PrintNumber(n, Task2::buzz));
            Future<String> taskC = C.submit(new PrintNumber(n, Task2::fizzbuzz));
            while (!taskA.isDone() || !taskB.isDone() || !taskC.isDone()){
                // resNumber = "" || "fizz" || "buzz" || "fizzbuzz"
            }
            Future<?> taskD = D.submit(new PrintNumber(n, Task2::number));
            while (!taskD.isDone()){
                // Print: number || resNumber
            }
        }
        System.exit(0);

    }

    public static void setResNumber(String res){
        resNumber = res;
    }

    public static String fizz(int number){
        return (number % 3 == 0)? "fizz" : "";
    }

    public static String buzz(int number){
        return (number % 5 == 0)? "buzz" : "";
    }

    public static String fizzbuzz(int number){
        return (number % 3 == 0 && number % 5 == 0)? "fizzbuzz" : "";
    }

    public static String number(int number){
        if (resNumber.isEmpty()) {
            System.out.print(number+", ");
        }else {
            System.out.print(resNumber+", ");
        }
        // Print number end.
        return "";
    }

}
