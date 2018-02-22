/**
 * Created by liuyisi on 2018/2/21.
 */
public class Rotate {
    public void rotate (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < i; j++) {
                swap(matrix,i, j, j, i);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - j - 1);
            }
        }
    }
    private void swap (int[][] matrix, int i, int j, int a, int b) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[a][b];
        matrix[a][b] = temp;
    }
}
