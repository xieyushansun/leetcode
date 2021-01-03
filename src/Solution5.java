import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Xie
 * @Description: TODO
 * @Contact: qq307954865
 * @Date: 2020/12/5 10:34
 */
class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str16 = scanner.nextLine();
        String str2 = "";
        for (int i = 0; i < str16.length(); i++){
           int temp = Integer.parseInt(String.valueOf(str16.charAt(i)), 16);
           str2 += Integer.toBinaryString(temp);
        }
        System.out.println(str2);
    }
}