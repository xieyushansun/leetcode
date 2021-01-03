package dynamic;

public class Coin {
    public static void main(String[] args){
        int[] A = new int[3];
        A[0] = 2;
        A[1] = 5;
        A[2] = 7;
        int result = coinChange(A, 27);
        if (result == -1){
            System.out.println("无法凑成该面值");
        }else {
            System.out.println(result);
        }
    }
    // 你有A[0], A[1], ...种面值的硬币，总的要拼出M元, 计算拼出M需要的最少硬币数。
    // 每种面值的硬币数不限
    public static int coinChange(int[] A, int M){
        int[] f = new int[M + 1];
        f[0] = 0;
        for (int i = 1; i < f.length; i++) {
            f[i] = -1;
            for (int j = 0; j < A.length; j++){
                // f[i - A[j]] != Integer.MAX_VALUE
                // 理解: 如果f[i - A[j]] 都拼不出来，则f[i]也是拼不出来的
                if (i >= A[j] && f[i - A[j]] != -1){ // 如果f[i] 初始化成Integer.MAX_VALUE就不用做下面的判断
                    if(f[i] != -1){
                        f[i] = Math.min(f[i - A[j]] + 1, f[i]);
                    }else {
                        f[i] = f[i - A[j]] + 1;
                    }
                }
            }
        }
//        if (f[M] == Integer.MAX_VALUE){
//            f[M] = -1;
//        }
        return f[M];
    }
}
