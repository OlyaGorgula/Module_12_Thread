package module12.lesson10;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException, IOException {
        String folder = "C:\\Users\\User\\Desktop\\Java code";

//        List<File> files = new FileCollector().getFile(folder);
//        System.out.println(files.size());
//        for (File file : files){
//            System.out.println(file);
//        }


        long start = System.currentTimeMillis();
        List<File> result = new MultiThreadSearcher().serch(folder, "thread");
        long duration = System.currentTimeMillis() - start;
        System.out.println("duration: " + duration);

        System.out.println("Found: " + result.size());
        for (File file : result) {
            System.out.println(file.getCanonicalPath());
        }

    }
}
