package module12.lesson7;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SumTest {
    public static void main(String[] args) throws InterruptedException {
        //long start = System.currentTimeMillis();
        BigDecimal sum = BigDecimal.ZERO;

//        for (int i = 0; i<1_000_000_000; i++){
//            sum = sum.add(BigDecimal.valueOf(i));
//        }
//
//        long duration = System.currentTimeMillis() - start;
//        System.out.println("sum = "+sum+", time ms: "+duration);

        long startTime = System.currentTimeMillis();

        //1_000_000_000
        long[][] startFinish = {
                {0, 1_000_000_000},
                {1_000_000_01, 2_000_000_00},
                {2_000_000_01, 3_000_000_00},
                {3_000_000_01, 4_000_000_00},
                {4_000_000_01, 5_000_000_00},
                {5_000_000_01, 6_000_000_00},
                {6_000_000_01, 7_000_000_00},
                {7_000_000_01, 8_000_000_00},
                {8_000_000_01, 9_000_000_00},
                {9_000_000_01, 1_000_000_000}
        };

        List<BigDecimal> results = new CopyOnWriteArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (long[] pair : startFinish){
            long start = pair[0];
            long end = pair[1];

            SumThreads thread = new SumThreads(
                    BigDecimal.valueOf(start),
                    BigDecimal.valueOf(end),
                    results
            );
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads){
            thread.join();
        }

        BigDecimal finalResult = BigDecimal.ZERO;
        for (BigDecimal subSum : results){
            finalResult = finalResult.add(subSum);
        }
        //System.out.println("finalResult = "+finalResult);
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("sum = "+finalResult+", time ms: "+duration);

    }

    private static class SumThreads extends Thread{
        private BigDecimal start;
        private BigDecimal end;

        private List<BigDecimal> result;

        public SumThreads(BigDecimal start, BigDecimal end, List<BigDecimal> result) {
            this.start = start;
            this.end = end;
            this.result = result;
        }

        @Override
        public void run() {
            //BigDecimal tmpSum = start;
            long tmpSum = start.longValue();

            long startLong = start.longValue();
            long endLong = end.longValue();
            for (long i = startLong+1; i< endLong; i++){
                tmpSum += i;
                //tmpSum = tmpSum.add(BigDecimal.valueOf(i));
            }
//            while (true){
//                start = start.add(BigDecimal.ONE);
//                if (start.equals(end)){
//                    break;
//                }
//                tmpSum = tmpSum.add(start);
//            }

            result.add(BigDecimal.valueOf(tmpSum));
        }
    }
}
