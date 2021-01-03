package Sort;

/**
 * @author: Xie
 * @Description: TODO
 * @Contact: qq307954865
 * @Date: 2020/12/1 11:38
 */
public class MergeSort {
    public static void main(String[] args){
        int[] arr = {2, 5, 3, 6, 7, 1, 5, 2, 9};
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    static void mergeSort(int[] arr, int low, int high){
        if (low < high){
            int mid = (low + high) / 2;
            // 对左边进行归并排序
            mergeSort(arr, low, mid);
            // 对右边进行归并排序
            mergeSort(arr, mid + 1, high);
            // 合并
            merge(arr, low, mid, high);

        }
    }
    // 合并low~mid，mid+1~high
    public static void merge(int[] arr, int low, int mid, int high){
        int index = 0;
        int i = low;
        int j = mid + 1;
        int[] temp = new int[high - low + 1];
        while (i <= mid && j <= high){
            if (arr[i] <= arr[j]){
                temp[index++] = arr[i++]; // 这两句互换，可以决定正序或逆序排
            }else {
                temp[index++] = arr[j++]; // 这两句互换，可以决定正序或逆序排
            }
        }
        while (i <= mid){
            temp[index++] = arr[i++];
        }
        while (j <= high){
            temp[index++] = arr[j++];
        }
        index = 0;
        for (int k = low; k <= high; k++){
            arr[k] = temp[index++];
        }
    }
}
