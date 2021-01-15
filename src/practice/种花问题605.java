package practice;

public class 种花问题605 {
    public static void main(String[] args){
        int[] flowerbed = {0,0,0,0,0,1,0,0,0};
        int n = 0;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1 && flowerbed[0] == 0){
            if (n == 1){
                return true;
            }else {
                return false;
            }
        }
        for (int i = 0; i < flowerbed.length; i++){
            if (i == 0 && i + 1 < flowerbed.length && flowerbed[i + 1] == 0 && flowerbed[i] == 0){
                n--;
                flowerbed[i] = 1;
            } else if (i + 1 < flowerbed.length  && i - 1 >= 0 && flowerbed[i-1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] != 1){
                n--;
                flowerbed[i] = 1;
            }else if (i - 1 >= 0 && i == flowerbed.length - 1 && flowerbed[i-1] == 0 && flowerbed[i] != 1){
                n--;
                flowerbed[i] = 1;
            }
            if (n <= 0){
                return true;
            }
        }
        return false;
    }
}
