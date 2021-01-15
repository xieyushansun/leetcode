package 位运算;

public class 比特位计数338 {
    public static void main(String[] args){
        int[] result = countBits(6);
        for (int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
    public static int[] countBits(int num) {
        int[] result = new int[num+1];
        if (num == 0){
            return result;
        }
        if (num == 1){
            result[1] = 1;
            return result;
        }
        if (num == 2){
            result[1] = 1;
            result[2] = 1;
            return result;
        }
        result[1] = 1;
        result[2] = 1;
        for (int i = 3; i <= num; i++){
            int n = i / 2;
            if (i % 2 == 1){
                result[i] = result[n] + 1;
            }else {
                result[i] = result[n];
            }
        }
        return result;
    }
}
