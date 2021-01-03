package dynamic;

/**
 * @author: Xie
 * @Description: TODO
 * @Contact: qq307954865
 * @Date: 2020/12/10 10:13
 */
public class Painting {
    public static void main(String[] args){
        int[][] costs = {
                {14,2,11},
                {11,14,5},
                {14,3,10}};
        System.out.println(PaintHouse(costs));
    }
    public static int PaintHouse(int[][] costs){
        if (costs.length == 0){
            return 0;
        }
        int N = costs.length;
        int[][] cost = new int[N][3];
        cost[0][0] = costs[0][0];
        cost[0][1] = costs[0][1];
        cost[0][2] = costs[0][2];
        for (int i = 1; i < N; i++){
            cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + costs[i][0];
            cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) + costs[i][1];
            cost[i][2] = Math.min(cost[i-1][0], cost[i-1][1]) + costs[i][2];
        }
        return Math.min(Math.min(cost[N-1][0], cost[N-1][1]), cost[N-1][2]);
    }
}
