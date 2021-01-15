package 并查集;

import java.util.*;

public class 执行交换操作后的最小汉明距离5650 {
    public static void main(String[] args){
        int[] source = {2,2,2,2,1};
        int[] target = {5,1,1,2,2};
        int[][] allowedSwaps = {{4,2},{1,4}};
        System.out.println(minimumHammingDistance(source, target, allowedSwaps));
    }
    static int[] pre;
    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        // 并查集判断是否是所有位置都可以互相交换
        int count = 0;
        int length = source.length;
        int[] rank = new int[length];
        pre = new int[length];
        for (int i = 0; i < length; i++){
            pre[i] = i;
        }
        for (int i = 0; i < allowedSwaps.length; i++){
            int start = allowedSwaps[i][0];
            int end = allowedSwaps[i][1];
            int root1 = findRoot(start);
            int root2 = findRoot(end);
            if (root1 != root2){
                if (rank[root1] > rank[root2]){
                    pre[root2] = root1;
                }else {
                    pre[root1] = root2;
                    if (rank[root1] == rank[root2]){
                        rank[root2]++;
                    }
                }
            }
        }
        // 后一个map：key是数值，value是出现次数
        Map<Integer, Map<Integer, Integer>> map_source = new LinkedHashMap<>();
        Map<Integer, Map<Integer, Integer>> map_target = new LinkedHashMap<>();
        for (int i = 0; i < length; i++){
            int root = findRoot(i);
            // source
            Map<Integer, Integer> map1 = map_source.getOrDefault(root, new HashMap<>());
            int n1 = map1.getOrDefault(source[i], 0); // 获取source[i] 出现次数
            map1.put(source[i], n1 + 1);
            map_source.put(root, map1);
            // target
            Map<Integer, Integer> map2 = map_target.getOrDefault(root, new HashMap<>());
            int n2 = map2.getOrDefault(target[i], 0);
            map2.put(target[i], n2 + 1);
            map_target.put(root, map2);
        }
        // 遍历map
        // 遍历sourse,如果target含有该sourse，则删除target里的元素（防止重复）
        Iterator<Map<Integer, Integer>> iterator1 = map_source.values().iterator();
        Iterator<Map<Integer, Integer>> iterator2 = map_target.values().iterator();
        while (iterator1.hasNext() && iterator2.hasNext()){
            Map<Integer, Integer> map1 = iterator1.next();
            Map<Integer, Integer> map2 = iterator2.next();
            Iterator<Map.Entry<Integer, Integer>> iterator = map1.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Integer, Integer> entry = iterator.next();
                int key = entry.getKey();
                int value = entry.getValue();
                int value2 = map2.getOrDefault(key, 0);
                if (value2 < value){
                    count += value - value2;
                }

            }
        }
        return count;
    }
    public static int findRoot(int n){
        while (n != pre[n]){
            n = pre[n];
        }
        return n;
    }
}
