import java.util.concurrent.Callable;

public class PrintNumber implements Callable<String> {
    int numble;
    CheckNumber checkNumber;

    public PrintNumber(int numble, CheckNumber checkNumber) {
        this.numble = numble;
        this.checkNumber = checkNumber;
    }

    @Override
    public String call(){

        String res = checkNumber.mCheckNumber(numble);

        if (!res.isEmpty()){
            Task2.setResNumber(res);
        }

        return res;
    }
}
