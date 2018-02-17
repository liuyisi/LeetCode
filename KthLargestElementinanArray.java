/**
 * Created by liuyisi on 2018/2/17.
 */
public class KthLargestElementinanArray {
    /**
        3, 2, 1, 5, 6, 4  k = 3

     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos + 1 == k) {
                return nums[pos];
            }else if (pos + 1 < k) {
                left = pos + 1;
            }else {
                right = pos - 1;
            }
        }

    }

    private int partition (int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            if (nums[i] >= pivot) {
                i++;
            }else if(nums[j] < pivot) {
                j--;
            }else {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        swap(nums, left, j);
        return j;
    }

    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
