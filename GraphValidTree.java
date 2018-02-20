import java.util.*;
/**
 * Created by liuyisi on 2018/2/19.
 */
public class GraphValidTree {
    /**
     * DFS Time: O(edges * nodes), Space: O(n)
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        boolean is = helper(graph, set, 0, -1);
        if (is == false)    return false;
        else return set.size() == n ? true : false;
    }

    private boolean helper(List<List<Integer>> graph, Set<Integer> set, int node, int parent) {
        for (int i = 0; i < graph.get(node).size(); i++) {
            if (graph.get(node).get(i) == parent)   continue;
            if (set.contains(graph.get(node).get(i)))   return false;
            set.add(graph.get(node).get(i));
            boolean flag = helper(graph, set, graph.get(node).get(i), node);
            if (!flag) return false;
        }
        return true;
    }

    /**
     * Union Find:
     * @param n
     * @param edges
     * @return
     */

    public boolean validTree2(int n, int[][] edges) {
        if (n == 1 && edges.length == 0)    return true;
        if (n < 1 || edges == null || edges.length == 0 || edges.length != n - 1)  return false;

        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        for (int[] pair : edges) {
            int x = find(pair[0], root);
            int y = find(pair[1], root);
            if (x == y) return false;
            else {
                root[x] = y;
            }

        }
        return true;
    }

    //compressed finding attention HERE!!!
    private int find (int x, int[] root) {
        int parent = root[x];
        while (parent != root[parent]) {
            parent = root[parent];
        }
        int temp = -1;
        int fa = root[x];
        while (fa != root[fa]) {
            temp = root[fa];
            root[fa] = parent;
            fa = temp;
        }
        return parent;
    }
}
