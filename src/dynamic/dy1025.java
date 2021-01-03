package dynamic;

public class dy1025 {
    public static void main(String[] args){
        divisorGame(3);
    }
    public static boolean divisorGame(int N) {
        boolean result = false;
        int flag = 0;
        while (N > 1){
            for (int i = 1; i < N; i++){
                if (N % i == 0 && flag % 2 == 0){
                    N = N - i;
                    result = true;
                    flag++;
                    break;
                }else if (N % i == 0){
                    N = N - i;
                    result = false;
                    flag++;
                    break;
                }
            }
        }
        return result;
    }
}
