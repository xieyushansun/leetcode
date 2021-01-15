package 并查集;

public class 省份数量547 {
    static int[] pre;
    public int findCircleNum(int[][] isConnected) {
        pre = new int[isConnected.length];
        int[] rank = new int[isConnected.length];
        int total = isConnected.length;
        for (int i = 0; i < pre.length; i++){
            pre[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++){
            for (int j = 0; j < i; j++){
                if(isConnected[i][j] == 1){
                    int root1 = findRoot(i);
                    int root2 = findRoot(j);
                    if (root1 != root2){
                        total--;
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
            }
        }
        return total;
    }
    public static int findRoot(int n){
        while (n != pre[n]){
            n = pre[n];
        }
        return n;
    }
}
