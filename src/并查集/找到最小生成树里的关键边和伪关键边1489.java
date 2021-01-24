package 并查集;

import java.util.*;

/**
 * @author: Xie
 * @Description: TODO
 * @Contact: qq307954865
 * @Date: 2021/1/21 10:28
 */
public class 找到最小生成树里的关键边和伪关键边1489 {
    public static void main(String[] args){
        int n = 5;
        int[][] edges = {{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}};
        findCriticalAndPseudoCriticalEdges(n, edges);
    }
    static int[] pre;
    public static List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        pre = new int[n];
        for (int i = 0; i < n; i++){
            pre[i] = i;
        }
        // 对边排序
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for(int i = 0; i < edges.length; i++){
            int weight = edges[i][2];
            List<int[]> list = map.getOrDefault(weight, new ArrayList<>());
            int[] temp = new int[3];
            temp[0] = edges[i][0];
            temp[1] = edges[i][1];
            temp[2] = i; // 边的索引
            list.add(temp);
            map.put(weight, list);
        }
        // 标准：最小生成树的权重：totalWeight
        int minWeight = MST(map, n, -1, -1, false, -1);
        Set<Integer> critical = new HashSet<>();
        Set<Integer> notCritical = new HashSet<>();
        for (int i = 0; i < edges.length; i++){
            int start = edges[i][0];
            int end = edges[i][1];
            int we = edges[i][2];
            int re = MST(map, n, start, end,false, -1);
            if (re != minWeight){ // 可能大于，可能小于
                critical.add(i);
            }else {
                int re1 = MST(map, n, start, end, true, we);
                if (re1 == minWeight){
                    notCritical.add(i);
                }
            }
        }
        result.add(new ArrayList<>(critical));
        result.add(new ArrayList<>(notCritical));
        return result;
    }
    public static int findRoot(int n){
        while (n != pre[n]){
            n = pre[n];
        }
        return n;
    }
    public static int MST(TreeMap<Integer, List<int[]>> map, int total, int n1, int n2, boolean predeal, int weight){
        int totalWeight = 0;
        int[] rank = new int[total];
        for (int i = 0; i < total; i++){
            pre[i] = i;
        }
        if (predeal){
            pre[n1] = n2;
            totalWeight += weight;
        }
        Iterator<Map.Entry<Integer, List<int[]>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, List<int[]>> entry = iterator.next();
            int we = entry.getKey();
            List<int[]> value = entry.getValue();
            for (int i = 0; i < value.size(); i++){
                if (total == 1){ // 说明已经是最小生成树了
                    break;
                }
                int start = value.get(i)[0];
                int end = value.get(i)[1];
                if (n1 == start && n2 == end){
                    continue;
                }

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
                    total--;
                    totalWeight += we;
                }
            }
        }
        return totalWeight;
    }
}
