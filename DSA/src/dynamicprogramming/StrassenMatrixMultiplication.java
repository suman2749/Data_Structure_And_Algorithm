package dynamicprogramming;

public class StrassenMatrixMultiplication {
    public static int[][] strassen(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            int newSize = n / 2;
            int[][] a11 = new int[newSize][newSize];
            int[][] a12 = new int[newSize][newSize];
            int[][] a21 = new int[newSize][newSize];
            int[][] a22 = new int[newSize][newSize];
            int[][] b11 = new int[newSize][newSize];
            int[][] b12 = new int[newSize][newSize];
            int[][] b21 = new int[newSize][newSize];
            int[][] b22 = new int[newSize][newSize];

            // Split matrices into quadrants
            for (int i = 0; i < newSize; i++) {
                for (int j = 0; j < newSize; j++) {
                    a11[i][j] = A[i][j];
                    a12[i][j] = A[i][j + newSize];
                    a21[i][j] = A[i + newSize][j];
                    a22[i][j] = A[i + newSize][j + newSize];

                    b11[i][j] = B[i][j];
                    b12[i][j] = B[i][j + newSize];
                    b21[i][j] = B[i + newSize][j];
                    b22[i][j] = B[i + newSize][j + newSize];
                }
            }

            // 7 products
            int[][] M1 = strassen(add(a11, a22), add(b11, b22));
            int[][] M2 = strassen(add(a21, a22), b11);
            int[][] M3 = strassen(a11, subtract(b12, b22));
            int[][] M4 = strassen(a22, subtract(b21, b11));
            int[][] M5 = strassen(add(a11, a12), b22);
            int[][] M6 = strassen(subtract(a21, a11), add(b11, b12));
            int[][] M7 = strassen(subtract(a12, a22), add(b21, b22));

            // C quadrants
            int[][] c11 = add(subtract(add(M1, M4), M5), M7);
            int[][] c12 = add(M3, M5);
            int[][] c21 = add(M2, M4);
            int[][] c22 = add(subtract(add(M1, M3), M2), M6);

            // Combine results
            for (int i = 0; i < newSize; i++) {
                for (int j = 0; j < newSize; j++) {
                    C[i][j] = c11[i][j];
                    C[i][j + newSize] = c12[i][j];
                    C[i + newSize][j] = c21[i][j];
                    C[i + newSize][j + newSize] = c22[i][j];
                }
            }
        }
        return C;
    }

    private static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }

    private static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};
        int[][] C = strassen(A, B);

        System.out.println("Result:");
        for (int[] row : C) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}
