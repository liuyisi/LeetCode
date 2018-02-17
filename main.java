/**
 * Created by liuyisi on 2017/10/19.
 */
public class main {
    public static void main (String args[]){
        KthLargestElementinanArray solution = new KthLargestElementinanArray();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int ans = solution.findKthLargest(nums, 3);
        System.out.println(ans);
    }
}