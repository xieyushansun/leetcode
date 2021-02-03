/**
 * @author: Xie
 * @Description: TODO
 * @Contact: qq307954865
 * @Date: 2021/1/25 10:10
 */
public class test {
    public static void main(String[] args){
        String[] str = {"/\\", "\\/"};
        System.out.print(regionsBySlashes(str));
    }
    static int[] pre;
    static int total;
    public static int regionsBySlashes(String[] grid) {
        int N = grid.length;
        total = N * N * 4;
        pre = new int[total];
        for (int i = 0; i < pre.length; i++){
            pre[i] = i;
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                int n = (i * N + j) * 4;
                if (grid[i].charAt(j) == ' '){
                    // 单元格内合并
                    union(n, n+1);
                    union(n+1, n+2);
                    union(n+2, n + 3);

                }else if (grid[i].charAt(j) == '/') {
                    union(n, n + 1);
                    union(n + 2, n + 3);
                }else if (grid[i].charAt(j) == '\\'){
                    union(n, n + 3);
                    union(n + 1, n + 2);
                }
                // 单元格向右合并
                if (j + 1 < N){ // 如果还有右边
                    union(n + 3, n + 5);
                }
                // 单元格向下合并
                if (i + 1 < N){ // 如果还有下边
                    int down_n = ((i+1) * N + j) * 4;
                    union(n + 2, down_n);
                }
            }
        }
        return total;
    }
    public static void union(int x, int y){
        int root1 = findRoot(x);
        int root2 = findRoot(y);
        if (root1 != root2){
            pre[root1] = root2;
            total--;
        }
    }
    public static int findRoot(int n){
        int temp = n;
        while (n != pre[n]){
            n = pre[n];
        }
        int root = n;
        n = temp;
        while (pre[n] != root){
            temp = pre[n];
            pre[n] = root;
            n = temp;
        }
        return root;
    }
}
