package Graph;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class DFSGraphTravelByStack{
    int vn; // 定点数
    private int[][] edges; // 边集合
    private boolean[] visited; // 访问集合
    private int[][] graph; // 邻接矩阵
    private String[] vertices; //顶点名集合
    public DFSGraphTravelByStack(int vn, int[][] edges, String[] vertices){
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
    // 借助栈的深度优先遍历
    public void dfsTravelByStack(){
        Stack<Integer> stack = new Stack<>();
        for (int v = 0; v < vn; v++){
            if (!visited[v]){
                visited[v] = true;
                visit(v);
                stack.push(v);
            }
            while (!stack.isEmpty()){
                int temp = stack.pop();
                for (int j = 0; j < vn; j++){
                    if (graph[temp][j] == 1 && !visited[j]){
                        visit(j);
                        visited[j] = true;
                        stack.push(j);
                        break;
                    }
                }
            }
        }
    }
    public void visit(int v){
        System.out.print(vertices[v] + " ");
    }
}
class DFSGraphTravel{
    int vn; // 定点数
    private int[][] edges; // 边集合
    private boolean[] visited; // 访问集合
    private int[][] graph; // 邻接矩阵
    private String[] vertices; //顶点名集合

    // 初始化图
    public DFSGraphTravel(int vn, int[][] edges, String[] vertices){
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
        visit(v);
        visited[v] = true;
        for (int j = 0; j < vn; j++){
            if (graph[v][j] == 1 && !visited[j]){
                visit(j);
                visited[j] = true;
                // 从该节点继续往下遍历，直到无法继续遍历
                dfsTravel(j);
            }
        }

    }
    public void visit(int v){
        System.out.print(vertices[v] + " ");
    }
}
class BFSGraphTravelByQueue{
    int vn; // 定点数
    private int[][] edges; // 边集合
    private boolean[] visited; // 访问集合
    private int[][] graph; // 邻接矩阵
    private String[] vertices; //顶点名集合
    public BFSGraphTravelByQueue(int vn, int[][] edges, String[] vertices){
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
    public void bfsTravelByQueue(int v){
        if (visited[v]){
            return;
        }
        visit(v);
        visited[v] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        while (!queue.isEmpty()){
            int temp = queue.poll();
            for (int j = 0; j < vn; j++){
                if (graph[temp][j] == 1 && !visited[j]){
                    visit(j);
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
    }
    public void visit(int v){
        System.out.print(vertices[v] + " ");
    }
}


public class Travel {
    public static void main(String[] args){

        int vn = 6; // 图的顶点数
        int[][] edges = {{2, 3}, {1, 5}, {1, 4}, {3, 1}, {3, 2}, {4, 5}, {2, 4}, {0, 3}};
        String[] vertices = {"0", "1", "2", "3", "4", "5"};

        DFSGraphTravel dfsGraphTravel = new DFSGraphTravel(vn, edges, vertices);
        System.out.println("递归法深度优先遍历");
        for (int i = 0; i < vn; i++){
            dfsGraphTravel.dfsTravel(i);
        }
        System.out.println("\n栈：深度优先遍历");
        DFSGraphTravelByStack dfsGraphTravelByStack = new DFSGraphTravelByStack(vn, edges, vertices);
        dfsGraphTravelByStack.dfsTravelByStack();
        System.out.println("\n队列：广度优先遍历");
        BFSGraphTravelByQueue bfsGraphTravelByQueue = new BFSGraphTravelByQueue(vn, edges, vertices);
        for (int i = 0; i < vn; i++){
            bfsGraphTravelByQueue.bfsTravelByQueue(i);
        }
    }
}

