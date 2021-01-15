package 并查集;

import java.util.*;

public class 除法求值339 {
    public static void main(String[] args){

    }
    static int[] pre;
    static double[] weight;
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        List<String> node = new ArrayList<>();
        double[] result = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++){
            String str1 = equations.get(i).get(0);
            String str2 = equations.get(i).get(0);
            if (!node.contains(str1)){
                node.add(str1);
            }
            if (!node.contains(str2)){
                node.add(str2);
            }
        }
        int num = node.size();
        weight = new double[num];
        Arrays.fill(weight, 1);  // 初始每个人的首领都是自己，所以自己与首领的比值就是1
        pre = new int[num];
        for (int i = 0; i < num; i++){
            pre[i] = i;  // 每个人的首领都是自己
        }
        // 构建关系网
        for (int i = 0; i < equations.size(); i++){
            String str1 = equations.get(i).get(0);
            String str2 = equations.get(i).get(0);
            int root1 = findRoot(str1, node);
            int root2 = findRoot(str2, node);
            if (root1 != root2){
                pre[root1] = root2; // root1的首领变成root2
                weight[root1] = values[i];
            }
        }

        for (int j = 0; j < queries.size(); j++){
            String str1 = queries.get(j).get(0);
            String str2 = queries.get(j).get(0);
            // 之前的等式没有出现过该字母
            if (!node.contains(str1) || !node.contains(str2)){
                result[j] = -1;
            }else{
                int root1 = findRoot(str1, node);
                int root2 = findRoot(str2, node);
                if (root1 != root2) {// 没有在一个集合里
                    result[j] = -1.0;
                }else {
                    int index1 = node.indexOf(str1);
                    int index2 = node.indexOf(str2);
                    double re = weight[index1] / weight[index2];
                    result[j] = re;

                }

            }
        }
        return result;
    }
    public static int findRoot(String s, List<String> node){
        int temp_root = node.indexOf(s);
        int root = temp_root;
        double father = 0;
        while (pre[root] != root){
            father = pre[root];
            root = pre[root];

        }
//        // 路径压缩
//        while (root !=temp_root){ // temp_root 不是根
//            int temp = pre[temp_root]; // 记录其根
//            pre[temp_root] = root; // 令其根为root
//            temp_root = temp; // 其根继续追溯
//        }
        return root;
    }
}
