package dynamic;
class Solution3 {
    public static void main(String args[]){
        waysToStep(61);
    }
    public static int waysToStep(int n) {

        if (n == 0){
            return 1;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (n == 3){
            return 4;
        }
        long[] f = new long[n + 1];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        f[3] = 4;
        for (int i =4; i < n + 1; i++){
            f[i] = f[i - 1] + f[i - 2] + f[i - 3];
        }
        System.out.println(f[n]);
        int result = (int)f[n] % 1000000007;
        return 0;
    }
}