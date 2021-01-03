import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Xie
 * @Description: TODO
 * @Contact: qq307954865
 * @Date: 2020/12/20 17:49
 */
class DFSGraphTravel{
    int vn; // 定点数
    private int[][] edges; // 边集合
    private boolean[] visited; // 访问集合
    private int[][] graph; // 邻接矩阵
    private int[] vertices; //顶点名集合
    public long count = 0;
    // 初始化图
    public DFSGraphTravel(int vn, int[][] edges, int[] vertices){
        this.vn = vn;

        this.visited = new boolean[vn];
        for (int i = 0; i < vn; i++){
            this.visited[i] = false;
        }

        this.vertices = vertices;

        this.edges = edges;
        graph = new int[vn][vn];
        for (int i = 0; i < edges.length; i++){
            int start = edges[i][0];
            int end = edges[i][1];
            graph[start][end] = 1;
        }
    }

    // 递归法深度优先遍历
    public void dfsTravel(int v){
        // 如果访问过就返回
        if (visited[v]){
            return;
        }
        // 否则就访问，并将访问数组置为true
//        visit(v);
        count += vertices[v];
        visited[v] = true;
        for (int j = 0; j < vn; j++){
            if (graph[v][j] == 1 && !visited[j]){
//                visit(j);
                count += vertices[v];
                visited[j] = true;
                // 从该节点继续往下遍历，直到无法继续遍历
                dfsTravel(j);
            }
        }

    }
}
public class Sl {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // n个节点
        int m = scanner.nextInt(); // m个数
        int[] weight = new int[n];
        List<int[]> edge = new ArrayList<>();
        for (int i = 0; i < n; i++){
            weight[i] = scanner.nextInt();
        }
        int[][] v = new int[n][n];
        for (int j = 0; j < n-1; j++){
            int start = scanner.nextInt() - 1;
            int end = scanner.nextInt() - 1;
            v[start][end] = 1;
            int[] temp = new int[2];
            temp[0] = start;
            temp[1] = end;
            edge.add(temp);
        }
        for (int i = 0; i < m; i++){
            int type = scanner.nextInt();
            if (type == 1){
                int e = scanner.nextInt();
                int[] t = edge.get(e-1);
                v[t[0]][t[1]] = 0;
            }else if (type == 2){
                int u = scanner.nextInt();
                int val = scanner.nextInt();
                weight[u - 1] = val;
            }else{
                int u = scanner.nextInt();
                DFSGraphTravel dfsGraphTravel = new DFSGraphTravel(n, v, weight);
                dfsGraphTravel.dfsTravel(u-1);
                System.out.println(dfsGraphTravel.count);
            }
        }
    }

}
