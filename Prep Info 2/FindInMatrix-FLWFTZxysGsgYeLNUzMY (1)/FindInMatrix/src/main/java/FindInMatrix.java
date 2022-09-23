import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

// You are allowed to add imports here

public class FindInMatrix {
    // You are allowed to add methods or class members, but do not change the signature
    // of the existing methods and class members.

    public static class Result {
        int row;
        List<Integer> columns;
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

    public static Result findValue(int[][] matrix, int value, int poolSize){
        Future<Result>[] r = new Future[matrix.length];
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        for (int i = 0; i < matrix.length; i++){
            int x = i;
            r[i] = executorService.submit(()-> calculate(matrix[x],x,value));
        }try {
            Result res = r[0].get();
            for (int i = 0; i < r.length; i++) {
                if (res.columns.size() < r[i].get().columns.size())res = r[i].get();
            }
            executorService.shutdown();
            return res;
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static Result calculate(int[] ligne, int row,int val){
        LinkedList ll = new LinkedList();
        int x = 0;
        for (int i = 0; i< ligne.length;i++){
            if (ligne[i] == val){
                x++;
                ll.add(i);
            }
        }
        Result r = new Result();
        r.columns = ll;
        r.row = row;
        return r;
    }
}
