public class Matrix {

    /**
     * Create a matrix from a String.
     *
     * The string if formatted as follow:
     *  - Each row of the matrix is separated by a newline
     *    character \n
     *  - Each element of the rows are separated by a space
     *
     *  @param s The input String
     *  @return The matrix represented by the String
     */
    public static int[][] buildFrom(String s) {
        String[] stringSplit = s.split("\n");
        int[][] M = new int[stringSplit.length][stringSplit[0].split(" ").length];
        for (int i = 0; i < stringSplit.length; i++){
            String[] data = stringSplit[i].split(" ");
            int[] line = new int[data.length];
            for (int j = 0; j < data.length; j++){
                line[j] = Integer.parseInt(data[j]);
            }
            M[i] = line;
        }
        return M;
    }

    /**
     * Compute the sum of the element in a matrix
     *
     * @param matrix The input matrix
     * @return The sum of the element in matrix
     */
    public static int sum(int[][] matrix) {
        int sum = 0;
        for (int[] i : matrix ){
            for (int j : i){
                sum = sum + j;
            }
        }
        return sum;
    }

    /**
     * Compute the transpose of a matrix
     *
     * @param matrix The input matrix
     * @return A new matrix that is the transpose of matrix
     */
    public static int[][] transpose(int[][] matrix) {
        int[][] T = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.println(matrix[i][j]);
                T[j][i] = matrix[i][j];
            }
        }
        return T;
    }

    /**
     * Compute the product of two matrix
     *
     * @param matrix1 A n x m matrix
     * @param matrix2 A m x k matrix
     * @return The n x k matrix product of matrix1 and matrix2
     */
    public static int[][] product(int[][] matrix1, int[][] matrix2) {
        int[][] M = new int[matrix1.length][matrix2[0].length];
        for (int n = 0; n < matrix1.length; n++){
            for (int m = 0; m < matrix1[n].length; m++){
                for (int k = 0; k < matrix2[m].length; k++){
                    M[n][k] += matrix1[n][m]*matrix2[m][k] ;
                }
            }
        }
        return M;
    }
}
