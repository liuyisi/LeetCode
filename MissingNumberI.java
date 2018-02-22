/**
 * Created by liuyisi on 2018/2/21.
 * This problem is simple, but is important to carry out different solutions
 */
public class MissingNumberI {
    /**
     * Bit Operation; Time: O(n) Space: O(1)
     * 1  2  3  4
     * 1     3  4
     *   (1 xor 3 xor 4) xor (1 xor 2 xor 3 xor 4)
     * = (1 xor 1) xor 2 xor (3 xor 3) xor (4 xor 4)
     * = 0 xor 2 xor 0 xor 0
     * = 2
     * @param nums
     * @return
     */
    public int missing1(int[] nums) {
        // Write your solution here
        int n = nums.length + 1;
        int xor = 0;
        //xor 0 to n
        for(int i = 1; i <= n - 1; i++){
            xor ^= i;
        }
        for(int num : nums){
            xor ^= num;
        }
        return xor;
    }

    /**
     * Use sum expected sum - true sum - O(n)
     * sum and mutify problem should consider overflow
     * @param nums
     * @return
     */
    public int missing2(int[] nums) {
        int n = nums.length;
        long targetSum = 0;
        long trueSum = 0;
        for (int i = 0; i <= n; i++) {
            targetSum += i;
        }
        for (int num : nums) {
            trueSum += num;
        }
        return (int)(targetSum - trueSum);
    }
}
