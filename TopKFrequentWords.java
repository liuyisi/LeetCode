import java.util.*;
/**
 * Created by liuyisi on 2018/2/21.
 */
public class TopKFrequentWords {
    /**
     * Ordinary TopK problem Time: O(nlogk)
     * This problem needs to be alerted of breaking tie according to lexicographical order
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                if (o1.getValue() == o2.getValue()) {
                    return o2.getKey().compareTo(o1.getKey());
                }else {
                    return o1.getValue() - o2.getValue();
                }
            }
        });
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (pq.size() < k) {
                pq.offer(e);
            } else if (pq.size() >= k && e.getValue() > pq.peek().getValue()) {
                pq.poll();
                pq.offer(e);
            } else if (pq.size() >= k && e.getValue() == pq.peek().getValue()) {
                int compare= e.getKey().compareTo(pq.peek().getKey());
                if (compare < 0) {
                    pq.poll();
                    pq.offer(e);
                }else {
                    continue;
                }

            } else {
                continue;
            }
        }
        List<String> ans = new ArrayList<String>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;
    }
}
