import java.util.*;

/**
 * @author: Xie
 * @Description: TODO
 * @Contact: qq307954865
 * @Date: 2021/1/12 10:39
 */
public class 项目管理1203 {
    public static void main(String[] args){
        int n = 8;
        int m = 2;
        int[] group = {-1,-1,1,0,0,1,0,-1};
        List<List<Integer>> beforItems = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        beforItems.add(list);

        list = new ArrayList<>();
        list.add(6);
        beforItems.add(list);

        list = new ArrayList<>();
        list.add(5);
        beforItems.add(list);

        list = new ArrayList<>();
        list.add(6);
        beforItems.add(list);

        list = new ArrayList<>();
        list.add(3);
        beforItems.add(list);

        list = new ArrayList<>();
        beforItems.add(list);

        list = new ArrayList<>();
        list.add(4);
        beforItems.add(list);

        list = new ArrayList<>();
        beforItems.add(list);

        int[] result = sortItems(n, m, group, beforItems);
        for (int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
    public static int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<Integer> result = new ArrayList<>();
        int t = m;
        // 将没有组的
        for (int i = 0; i < n; i++){
            if (group[i] == -1){
                group[i] = t++;
            }
        }
        // 构建组之间的拓扑关系
        int[][] groupGrouph = new int[t][t]; // 组之间的graph节点
        int[] groupin = new int[n];
        for (int i = 0; i < n; i++){ // 遍历每个项目
            List<Integer> list = beforeItems.get(i);
            if(list.size() != 0){ // 说明存在拓扑结构
                for(int j = 0; j < list.size(); j++){
                    int item = list.get(j); // i的先序项目
                    if (group[item] != group[i]){ // 如果i的先序项目item与i不属于同一个组，则这两个组存在拓扑关系
                        if (groupGrouph[group[i]][group[item]] == 1){ // 说明出现了冲突
                            int[] temp = new int[0];
                            return temp;
                        }else {
                            groupGrouph[group[item]][group[i]] = 1;
                            groupin[group[i]]++; // 入度+1
                        }
                    }
                }
            }
        }

        // 将组进行拓扑排序,得到一个拓扑排序
        int[] node = new int[t];
//        for (int i = 0; i < ;){
//
//        }
        List<Integer> groupTop = TopSortForGroup(groupGrouph, group, groupin);
        // 构建每个组对应的项目集合
        Map<Integer, List<Integer>> groupItemSet = new HashMap<>();
        // 每个项目的先序关系
        Map<Integer, List<List<Integer>>> groupBeforItem = new HashMap<>();

        for (int i = 0; i < n; i++){
            int gn = group[i]; // 项目i由gn负责
            List<Integer> list = groupItemSet.getOrDefault(gn, new ArrayList<>());
            list.add(i);
            groupItemSet.put(gn, list);

            List<List<Integer>> lists = groupBeforItem.getOrDefault(gn, new ArrayList<>());
            lists.add(beforeItems.get(i));
            groupBeforItem.put(gn, lists);
        }

        Iterator<Integer> iterator = groupTop.iterator();
        while (iterator.hasNext()){
            int gn = iterator.next();
            int num = groupItemSet.size();
            List<Integer> tempList = TopSortForItem(groupBeforItem.get(gn), groupItemSet.get(gn));
            if (tempList.size() != num){ // 说明无法完成拓扑排序
                int[] temp = new int[0];
                return temp;
            }
            result.addAll(tempList);
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
    public static List<Integer> TopSortForGroup(int[][] graph, int[] node, int[] in){
        int n = node.length;
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++){
            if (in[node[i]] ==  0){
                queue.offer(node[i]);
            }
        }
        while (!queue.isEmpty()){
            int num = queue.poll();
            result.add(num);
            for (int i = 0; i < n; i++){
                if (graph[num][i] == 1){
                    graph[num][i] = 0;
                    in[i]--;
                    if (in[i] == 0){
                        queue.offer(i);
                    }
                }
            }
        }
        return result;
    }

    public static List<Integer> TopSortForItem(List<List<Integer>> beforeItems, List<Integer> node){
        int n = node.size();
        int[] in = new int[n];
        List<Integer> result = new ArrayList<>();
        int[][] graph = new int[n][n]; // 构建项目间的拓扑顺序
        Queue<Integer> queue = new LinkedList<>(); // 记录入度为0的节点
        // 遍历beforeItems构建拓扑
        for (int i = 0; i < n; i++){
            List<Integer> list = beforeItems.get(i);
            in[i] = list.size();
            if (in[i] == 0){
                queue.offer(i); // i点入度为0
            }else {
                for (int j = 0; j < list.size(); j++){
                    int num = list.get(j); // 先序点
                    if (!node.contains(num)){
                        continue;
                    }
                    if (graph[i][num] == 1){ // 出现冲突
                        return result;
                    }
                    graph[num][i] = 1;
                }
            }
        }
        while (!queue.isEmpty()){
            int num = queue.poll();
            result.add(num);
            for (int i = 0; i < n; i++){
                if (graph[num][i] == 1){
                    graph[num][i] = 0;
                    in[i]--;
                    if (in[i] == 0){
                        queue.offer(i);
                    }
                }
            }
        }
        return result;
    }
}














