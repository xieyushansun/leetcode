package Graph;

import java.util.*;

// 图的基本结构
class Graph{
    List<List<Integer>> graphList;
    int vn;
    public Graph(int vn){
        this.vn = vn;
        graphList = new ArrayList<>();
        for (int i = 0; i < vn; i++){
            graphList.add(new ArrayList<>());
        }
    }
    public void addEdge(int start, int end){
        graphList.get(start).add(end);
    }
}
//遍历图
class TravelGraph{
    private int vn;
    private Graph graph;
    private int[] visited;
    private List<String> wordList;
    private String findWord;
    private int currentLevel; // 当前遍历到的层
    public TravelGraph(int vn, Graph graph, List<String> words, String findWord){
        this.vn = vn;
        this.graph = graph;
        this.visited = new int[vn];
        this.findWord = findWord;
        this.currentLevel = 1;
        this.wordList = new ArrayList<>();
        for (String word: words) {
            wordList.add(word);
        }
    }
    // 深度优先遍历
    public int travelBFS(int v){
        visited = new int[vn];
        Queue<Integer> queue = new LinkedList();
        queue.offer(v);
        currentLevel = 1;
        while (!queue.isEmpty()){
            int po = queue.poll();

            List<Integer> list = graph.graphList.get(po);
            if (list.size() == 0){
                return 0;
            }
            currentLevel++;
            for (int i = 0; i < list.size(); i++){
                int temp = list.get(i);
                if (visited[temp] == 0) {
                    queue.offer(temp);
                    if (wordList.get(temp).equals(findWord)) {
                        return currentLevel;
                    }
                    visited[temp] = 1;
                }
            }
        }
        return 0; //没有找到
    }
}

class Solution {
    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};

        System.out.print(ladderLength(beginWord, endWord, Arrays.asList(wordList)) + 1);
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Graph graph = new Graph(wordList.size());
        // 构建图
        for (int i = 0; i < wordList.size(); i++){
            for (int j = i+1; j < wordList.size(); j++){
                if (checkWord(wordList.get(i), wordList.get(j))){
                    graph.addEdge(i, j);
                    graph.addEdge(j, i);
                }
            }
        }

        TravelGraph travelGraph = new TravelGraph(graph.vn, graph, wordList, endWord);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < wordList.size(); i++){
            if (beginWord.equals(wordList.get(i))){
                return 2;
            }
            if (checkWord(beginWord, wordList.get(i))){ // 遍历列表里和beginWord相似的，从相似的word开始遍历
                if(min != 0){
                    min = Math.min(travelGraph.travelBFS(i), min);
                }
            }
        }
        return min + 1;
    }
    // 判断两个单词是否是只相差一个字母
    public static boolean checkWord(String a, String b){
        int flag = 0; //代表不相同次数
        for (int i = 0; i < a.length(); i++){
            if (a.charAt(i) != b.charAt(i)){
                flag++;
                if (flag > 1){
                    return false;
                }
            }
        }
        return true;
    }
}