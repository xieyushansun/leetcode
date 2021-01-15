package Sort;

import java.util.*;

public class MapSort {
    public static void main(String[] args){
        // TreeMap默认按键升序排列
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("d", 2);
        map.put("c", 1);
        map.put("s", 1);
        map.put("p", 3);

        Map<String, Integer> sortedMap = new HashMap<>();
        sortedMap.put("d", 2);
        sortedMap.put("c", 1);
        sortedMap.put("z", 1);
        sortedMap.put("p", 3);

        sortedMap = sortMap(sortedMap);
        Iterator<Map.Entry<String, Integer>> iterator = sortedMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
//        System.out.println("遍历整个map:方法1");
//        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String, Integer> m = iterator.next();
//            System.out.println(m.toString());
//            System.out.println(m.getKey() + ": " + m.getValue());
//        }
//        System.out.println("遍历整个map:方法2");
//        for (Map.Entry<String, Integer> entry : map.entrySet()){
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//        System.out.println("遍历键:方法1");
//        Iterator<String> iterator1 = map.keySet().iterator();
//        while (iterator1.hasNext()){
//            System.out.println(iterator1.next());
//        }
//        System.out.println("遍历键：方法2");
//        for (String key: map.keySet()) {
//            System.out.println(key);
//        }
//        System.out.println("遍历值：方法1");
//        Iterator<Integer> iterator2 = map.values().iterator();
//        while (iterator2.hasNext()){
//            System.out.println(iterator2.next());
//        }
//        System.out.println("遍历值: 方法2");
//        for(Integer value: map.values()){
//            System.out.println(value);
//        }
    }
    // map排序
    public static Map<String, Integer> sortMap(Map<String, Integer> map){
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        // A:65
        // a:97
        Map<String, Integer> mm = new HashMap<>();
        for (int i = 0; i < 26; i++){
            String key = String.valueOf((char) (97 + i));
            mm.put(key, i);
        }
        // 1. 将map转为list
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        // 2. 排序
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return mm.get(o2.getKey()) - mm.get(o1.getKey());
            }
        });

        // 3. 将list转回map
        Iterator<Map.Entry<String, Integer>> iterator = list.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }



}
