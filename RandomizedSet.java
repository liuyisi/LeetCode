import java.util.*;
/**
 * Created by liuyisi on 2018/2/22.
 */
public class RandomizedSet {
    /**
     * 设计题，哈希表下连着一个list，list便于random access，主要考察了基本数据结构API的使用，其中remove操作Corner case需要仔细考虑清楚
     */

    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))   return false;
        else {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))  return false;
        else {
            int index = map.get(val);
            if (list.size() == 1 || index == list.size() - 1) {
                map.remove(val);
                list.remove(list.size() - 1);
            }else {
                int lastVal = list.get(list.size() - 1);
                map.put(lastVal, index);
                map.remove(val);
                list.remove(list.size() - 1);
                list.set(index, lastVal);
            }
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
