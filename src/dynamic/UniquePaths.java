package dynamic;

public class UniquePaths {
    public static void main(String[] args){
        System.out.println(uniquePaths(2, 3));
    }
    public static int uniquePaths(int m, int n){
        int[][] f = new int[m][n];
//        f[0][0] = 0;
//        f[1][0] = 1;
//        f[0][1] = 1;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0){
                    f[i][j] = 1;
                }else {
                    f[i][j] = f[i-1][j] + f[i][j - 1];
                }
            }
        }
        return f[m-1][n-1];
    }
}
