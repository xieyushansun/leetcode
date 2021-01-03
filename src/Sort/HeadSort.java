package Sort;

import java.util.Arrays;

/**
 * @author: Xie
 * @Description: TODO
 * @Contact: qq307954865
 * @Date: 2020/12/6 16:47
 */
public class HeadSort {
    public static void main(String[] args){
        int[] arr = {14, 9, 6, 13, 21, 15, 64, 1243, 10, 16, 17, 2, 12};
//        int[] arr = {21, 17, 16, 14, 12, 10, 6, 13, 2, 9, 18};
        BuildMaxHead(arr, arr.length - 1);
        int[] newArr = insertN(arr, 18);
        HeadSort(arr);
        System.out.println("test");
    }
    public static void HeadSort(int[] arr){
        int len = arr.length - 1;
        BuildMaxHead(arr, len);
        for (int i = len; i >= 0; i--){
            System.out.println(arr[0]);
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            AdjustDown(arr, 0, i-1);
        }
    }
    public static int[] insertN(int[] arr, int insert_n){
        int[] new_arr = Arrays.copyOf(arr, arr.length + 1);
        new_arr[arr.length] = insert_n;
        AdjustUp(new_arr);
        return new_arr;
    }
    public static void BuildMaxHead(int[] arr, int len){
        for (int k = len / 2; k >= 0; k--){
            AdjustDown(arr, k, len);
        }
    }
    public static void AdjustDown(int[] arr, int k, int len){ // 调整arr的k号节点，从上往下调整
        int temp = arr[k];
        for(int i = k*2 + 1; i <= len; i = i*2 + 1){ // 2*k+1是左孩子，2*k + 2是右孩子
            if (i < len && arr[i] < arr[i+1]){ // 如果有右孩子，且右孩子比左孩子大，则取右孩子
                i++;
            }
            if (arr[i] > temp){
                arr[k] = arr[i]; // 交换过后，要继续看被交换那个节点的子节点
                k = i;
            }else {
                break; // 如果已经满足，则break
            }
        }
        arr[k] = temp;
    }
    public static void AdjustUp(int[] arr){
        int temp = arr[arr.length - 1];
        int i = arr.length - 1;
        int parent = (i-1) / 2;
        while (parent >= 0 && temp > arr[parent]){
            arr[i] = arr[parent];
            i = parent;
            parent = (i-1) / 2;
        }
        arr[i] = temp;
    }
}
