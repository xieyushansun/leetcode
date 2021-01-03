package dynamic;

/**
 * @author: Xie
 * @Description: TODO
 * @Contact: qq307954865
 * @Date: 2020/11/17 11:04
 */

// 有障碍的格子
public class UniquePath2 {
    public static void main(String[] args){
        int[][] obstacle = {{0,0,0},{0,1,0},{0,0,0}};
        Uniquepath2(obstacle);
    }
    public static int Uniquepath2(int[][] obstacleGrid){ // obstacle也是m行n列，有值的地方是1
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] F = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (obstacleGrid[i][j] == 1){
                    F[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0){
                    F[i][j] = 1;
                    continue;
                }
                F[i][j] = 0;
                if (i > 0){
                    F[i][j] += F[i-1][j];
                }
                if (j > 0){
                    F[i][j] += F[i][j-1];
                }
            }
        }
        return F[m-1][n-1];
    }
}
