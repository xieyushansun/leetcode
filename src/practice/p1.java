package practice;

public class p1 {
    public static void main(String[] args){
        int[] encoded = {6};
        int first = 1;
        decode(encoded, first);
    }
    public static int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 1; i < result.length; i++){
            result[i] = result[i-1] ^ encoded[i - 1];
        }
        return result;
    }
}
