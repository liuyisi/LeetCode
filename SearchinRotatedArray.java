/**
 * Created by liuyisi on 2018/2/26.
 */
public class SearchinRotatedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0, j = nums.length - 1;
        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target)    return mid;
            if (nums[i] < nums[mid]) {
                if (nums[i] <= target && target < nums[mid]) {
                    j = mid;
                } else i = mid;
            }else {
                if (nums[j] >= target && target > nums[mid]) {
                    i = mid;
                } else j = mid;
            }
        }
        if (nums[i] == target)  return i;
        if (nums[j] == target)  return j;
        return -1;
    }
}
