package module12.lesson8;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentCollections {

    public static void main(String[] args) {

        //List
        List<String> list = new CopyOnWriteArrayList<>();

        //Set
        Set<String> set1 = new ConcurrentSkipListSet<>();
        Set<String> set2 = Collections.newSetFromMap(new ConcurrentHashMap<>());
        Set<String> set3 = new CopyOnWriteArraySet<>();

        // Map
        Map<String, Long> map = new ConcurrentHashMap<>();
    }

}
