/**
 * Created by liuyisi on 2018/2/18.
 */
public class FindtheDuplicateNumber {

    //time: O(nlogn) space: O(1) Binary Search
    public int findDuplicate (int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            //nums may be unsorted
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 142. LinkedList Cycle II
     */
    public int findDuplicate2 (int[] nums) {

    }
}
