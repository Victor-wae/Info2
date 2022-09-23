import java.util.*;
import java.util.concurrent.*;

// You are allowed to add imports here

public class FindInMatrix {
    // You are allowed to add methods or class members, but do not change the signature
    // of the existing methods and class members.

    public static class Result {
        int row;
        List<Integer> columns;
    }


    public static Result caluclatorColums(int[] line, int row, int val){
        Result r = new Result();
        List<Integer> index = new LinkedList<>();
        for (int i = 0; i < line.length ; i++){
            if (line[i] == val){
                index.add(i);
            }
        }
        r.row = row;
        r.columns = index;
        return r;
    }
    /**
     * This method finds the row that contains the most number of occurrences of a
     * certain value and returns the row index of that row and the column indexes
     * (in increasing order) where the value occurs in that row.
     * The matrix is represented by a two-dimensional array.
     *
     * Example: if the method is called with the value "3" and the following matrix
     *     (1   3  2  -4)          // <- there is a "3" in column 1
     *     (-3  4  5  -2)
     *     (3   0  3   2)          // <- there is a "3" in column 0 and column 2
     * then the result of the search is:
     *      row=2 , columns=[0,2]
     * because row 2 contains the most number of occurrences of "3" (in columns 0 and 2).
     *
     * Your solution MUST use a thread pool to accelerate the operation.
     *
     * @param matrix a rectangular matrix
     * @param value the value to find
     * @param poolSize the thread pool size
     * @return the result of the search
     *
     * You can assume that there is exactly one row in the matrix with the
     * most number of occurrences of the value.
     * Catch exceptions and ignore them.
     */
    public static Result findValue(int[][] matrix, int value, int poolSize) {
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        Future<Result>[] f = new Future[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            int row = i;
            f[i] = executor.submit(()->caluclatorColums(matrix[row],row,value));
        }
        try {
            Result finaly = f[0].get();
            for (int i = 1; i < f.length;i++){
                if (finaly.columns.size() < f[i].get().columns.size()){
                    finaly = f[i].get();
                }
            }
            executor.shutdown();
            return finaly;
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
