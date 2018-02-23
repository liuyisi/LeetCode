import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by liuyisi on 2018/2/23.
 */
public class KthSmalestinSortedMatrix {
    private class Pair {
        int x;
        int y;
        int val;
        public Pair (int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public int kthSmallest (int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dx = {1, 0};
        int[] dy = {0, 1};
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.val == o2.val) {
                    return 0;
                }
                return o1.val < o2.val ? -1 : 1;
            }
        });
        boolean[][] visited = new boolean[m][n];
        pq.offer(new Pair(0, 0, matrix[0][0]));
        for (int i = 0; i < k - 1; i++) {
            Pair cur = pq.poll();
            for (int j = 0; j < 2; j++) {
                int next_x = cur.x + dx[j];
                int next_y = cur.y + dy[j];
                if (next_x < m && next_y < n && visited[next_x][next_y] == false) {
                    pq.offer(new Pair(next_x, next_y, matrix[next_x][next_y]));
                    visited[next_x][next_y] = true;
                }
            }
        }
        return pq.peek().val;
    }
}
