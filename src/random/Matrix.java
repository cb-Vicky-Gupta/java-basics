package random;

public class Matrix {
    static void main() {
//        int [][] mat = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        int [][] mat = {{1,2},{2,2}};
        System.out.println(isToeplitzMatrix(mat));
    }
    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

}

