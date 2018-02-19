import java.util.*;
/**
 * Created by liuyisi on 2018/2/17.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            candidates.add(nums[i]);
        }
        helper(candidates, 0, ans);
        return ans;
    }

    private void helper (List<Integer> nums, int index, List<List<Integer>> ans) {
        if (index == nums.size()) {
            List<Integer> list = new ArrayList<Integer>(nums);
            ans.add(list);
        }
        for (int i = index; i < nums.size(); i++) {
            Collections.swap(nums, index, i);
            helper(nums, index + 1, ans);
            Collections.swap(nums, index, i);
        }

    }
}
