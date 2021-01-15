package 数组;

public class 数组向右移动k位189 {
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4,5,6};
        int k = 2;
        rotate2(nums, k);
    }
    // 法一
    public static void rotate1(int[] nums, int k) {
        if (nums.length == 0 || k == 0 || k == nums.length){
            return;
        }
        int ll = nums.length;
        int visit = 0; // 目前访问过的数字的数目
        for (int i = 0; visit < ll; i++){
            int index = i;
            int temp1 = nums[index]; // 前一个
            int temp2 = nums[(index + k) % ll]; // 后一个
            // 前一个赋值给后一个
            index = (index + k) % ll;
            do{
                nums[index] = temp1;
                visit++;
                temp1 = temp2;
                index = (index + k) % ll;
                temp2 = nums[index];
            }while (index != i);
            nums[index] = temp1;
            visit++;
        }
    }
    // 法二
    public static void rotate2(int[] nums, int k) {
        if (nums.length == 0 || k == 0 || k == nums.length){
            return;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low < high){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
        low = 0;
        high = k-1;
        while (low < high){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
        low = k;
        high = nums.length-1;
        while (low < high){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
        System.out.println("test");
    }
}
