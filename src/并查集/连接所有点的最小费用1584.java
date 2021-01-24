package 并查集;

import java.util.*;

/**
 * @author: Xie
 * @Description: TODO
 * @Contact: qq307954865
 * @Date: 2021/1/19 9:33
 */
public class 连接所有点的最小费用1584 {
    public static void main(String[] args){
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        minCostConnectPoints(points);
    }
    static int[] pre;
    public static int minCostConnectPoints(int[][] points) {
        int reuslt = 0;
        int ll = points.length;
        pre = new int[ll];
        for (int i = 0; i < ll; i++){
            pre[i] = i;
        }
        int total = ll;
        TreeMap<Integer, List<int[][]>> map = new TreeMap<>();
        for (int i = 0; i < ll; i++){
            for (int j = i + 1; j < ll; j++){
                int dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                List<int[][]> list = map.getOrDefault(dis, new ArrayList<>());
                int[][] temp = new int[1][2];
                temp[0][0] = i;
                temp[0][1] = j;
                list.add(temp);
                map.put(dis, list);
            }
        }
        Iterator<Map.Entry<Integer, List<int[][]>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, List<int[][]>> m = iterator.next();
            int we = m.getKey();
            List<int[][]> list = m.getValue();
            for (int i = 0; i < list.size(); i++){
                if (total > 1){
                    int x = list.get(i)[0][0];
                    int y = list.get(i)[0][1];
                    int root1 = findRoot(x);
                    int root2 = findRoot(y);
                    if (root1 != root2){
                        pre[root1] = root2;
                        reuslt += we;
                    }
                }else if (total == 1) { // 说明已经全部合并了
                    return reuslt;
                }
            }
        }
        return reuslt;
    }
    public static int findRoot(int n){
        int temp = n;
        while (n != pre[n]){
            n = pre[n];
        }
        int root = n;
        n = temp;
        while (n != pre[n]){
            temp = pre[n];
            pre[n] = root;
            n = temp;
        }
        return root;
    }
}
