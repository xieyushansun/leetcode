/**
 * @author: Xie
 * @Description: TODO
 * @Contact: qq307954865
 * @Date: 2020/12/20 11:44
 */
public class T5631 {
    public int maxResult(int[] nums, int k) {
        int length = nums.length;
        int[] f = new int[length];
        f[0] = nums[0];
        for (int i = 1; i < length; i++){
            f[i] = Integer.MIN_VALUE;
            for (int j = 1; j <= k; j++){
                if (i - j >= 0){
                    f[i] = Math.max(f[i], f[i-j]);
                }
            }
            f[i] += nums[i];
        }
        return f[length - 1];
    }
}
