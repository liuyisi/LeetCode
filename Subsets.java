import java.util.*;
/**
 * Created by liuyisi on 2018/2/17.
 */
public class Subsets {
    public List<List<Integer>> Subsets (int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        List<Integer> prefix = new ArrayList<>();
        helper(nums, 0, ans, prefix);
        return ans;
    }

    private void helper(int[] nums, int index, List<List<Integer>> ans, List<Integer> prefix) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>(prefix);
            ans.add(list);
            return;
        }
        //case1: add
        prefix.add(nums[index]);
        helper(nums, index + 1, ans, prefix);
        prefix.remove(prefix.size() - 1);

        //case2: not add
        helper(nums, index + 1, ans, prefix);
    }
}
