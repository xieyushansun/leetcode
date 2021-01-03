package dynamic;

public class JumpGame {
    public static void main(String[] args){
        int[] a = {2, 3, 1, 1, 4};
        int[] b = {3, 2, 1, 0, 4};
        System.out.println(canJump(a));
    }
    public static boolean canJump(int[] A){
        int n = A.length; // 最终要跳到的地方
        boolean[] f = new boolean[n];
        f[0] = true;
        for (int i = 1; i < n; i++){
            f[i] = false;
            for (int j = 0; j < i; j++){
                if (f[j] && A[j] >= i - j) { // 或关系，只要f[i]之前有一个石头可以让青蛙跳过来，则f[i]就是true
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n - 1];
    }
}
