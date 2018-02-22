/**
 * Created by liuyisi on 2018/2/22.
 */
public class MoveZeros {
    /**
     * In order to maintain the original order, instead of swap, we should adopt isotropic pointers
     * @param nums
     */
    public void moveZeros (int[] nums) {
        if (nums == null || nums.length == 0)   return;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++] = nums[j++];
            }else {
                j++;
            }
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }

}
