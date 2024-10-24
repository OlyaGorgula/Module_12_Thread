package module12.lesson10;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCollector {
    public List<File> getFile(String folder){
        List<File> result = new ArrayList<>();
        search(new File(folder), result);
        return result;
    }

    private void search (File base, List<File> result){
        if (base.isFile()){
            result.add(base);
        }else{
            for (File child : base.listFiles()){
                search(child, result);
            }
        }
    }
}
