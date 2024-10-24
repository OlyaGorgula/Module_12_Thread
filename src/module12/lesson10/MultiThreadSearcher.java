package module12.lesson10;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadSearcher {
    public List<File> serch(String path, String search) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        List<File> files = new FileCollector().getFile(path);

        System.out.println("Search in files: "+files.size());

        List<File> result = new CopyOnWriteArrayList<>();

        List<Future<?>> futures = new ArrayList<>();
        for (File file : files) {
            Future<?> future = executor.submit(() ->
                    new FileSearcher().search(file, search, result));
            futures.add(future);
        }
        while (true){
            boolean searchFinished = futures.stream().allMatch(Future::isDone);
            if (searchFinished){
                break;
            }
            Thread.sleep(100);
        }
        return result;
    }
}
