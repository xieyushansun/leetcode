package DFSandBFS;

import java.util.*;

class ListGraph{
    ArrayList<ArrayList<Integer>> graphs;
    public ListGraph(int v){
        graphs = new ArrayList<>();
        for (int i = 0; i < v; i++){
            graphs.add(new ArrayList<>());
        }
    }
    public void addEdge(int start, int end){
        graphs.get(start).add(end);
    }
    public void removeEdge(int start, int end){
        graphs.get(start).remove(end);
    }
}
class travelGraph{
    int vn;
    int[] visited;
    ListGraph listgraph;
    public travelGraph(int vn, ListGraph listGraph){
        this.vn = vn;
        this.visited = new int[vn];
        this.listgraph = listGraph;
    }
    public void travelDFS(int v){
        if (visited[v] == 1){
            return;
        }
        visited[v] = 1;
        if (v == vn - 1){
            System.out.print(v);
        }else {
            System.out.print(v + " -> ");
        }

        List<Integer> list = listgraph.graphs.get(v);
        for (int temp : list) {
            if (visited[temp] == 0) {
                if (temp == vn - 1) {
                    System.out.println(temp);
                } else {
                    System.out.print(temp + " -> ");
                }
                visited[temp] = 1;
                travelDFS(temp);
            }
        }
    }
    public void travelBFS(int v){
        if (visited[v] == 1){
            return;
        }
        visited[v] = 1;
        if (v == vn - 1){
            System.out.print(v);
        }else {
            System.out.print(v+ "->");
        }

        Queue<Integer> queue = new LinkedList();
        queue.offer(v);
        while (!queue.isEmpty()){
            List<Integer> list = listgraph.graphs.get(queue.poll());
            for (int temp : list) {
                if (visited[temp] == 0) {
                    queue.offer(temp);
                    if (temp == vn - 1) {
                        System.out.print(temp);
                    } else {
                        System.out.print(temp + "->");
                    }
                    visited[temp] = 1;
                }
            }
        }
    }
}
public class DFSandBFS {
    public static void main(String[] args){
        int vn = 8; //图有6个顶点
        ListGraph graph = new ListGraph(vn);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 5);
        graph.addEdge(4, 3);
        graph.addEdge(5, 2);
        graph.addEdge(5, 4);
        graph.addEdge(6, 7);
        travelGraph travelGraph = new travelGraph(vn, graph);

        for (int i = 1; i < vn; i++){
            travelGraph.travelBFS(i);
        }
    }

}
