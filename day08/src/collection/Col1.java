package collection;

import java.util.*;

public class Col1 {
    public static void main(String[] args) {
        // List 중복 허용
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        System.out.println("List");
        System.out.println(list);

        // Set 중복 미 허용
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(3);
        set.add(2);
        set.add(1);
        System.out.println("Set");
        System.out.println(set);

        // Map 중복 미 허용
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("c", 3);
        System.out.println("Map");
        System.out.println(map);
    }
}
