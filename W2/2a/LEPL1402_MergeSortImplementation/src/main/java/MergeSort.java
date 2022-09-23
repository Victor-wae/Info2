public class MergeSort {

    /**
     * Pre-conditions: a[lo..mid] and a[mid+1..hi] are sorted
     * Post-conditions: aux[lo..hi] is sorted and a is left unchanged
     * <p>
     * For example, let a = [4, 5, 1, 3], lo = 0, mid = 1, hi = 3
     * We have that the portion [4, 5] and [1, 3] are sorted
     * <p>
     * The merge function take this two portions and put them in aux
     * in the correct order
     * <p>
     * At the end of the execution, we have a = [4, 5, 1, 3] and
     * aux = [1, 3, 4, 5]
     */
    public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                aux[k] = a[j];
                j++;
            } else if (j > hi) {
                aux[k] = a[i];
                i++;
            } else if (a[i] > a[j]) {
                aux[k] = a[j];
            } else {
                aux[k] = a[i];
            }
        }
    }

    /**
     * @param a   the array to sort from lo to hi
     * @param aux the auxiliary array used in the merge function
     * @param lo  the lower bound index for the sort
     * @param hi  the upper bound index for the sort
     * @return nothing. The a array is sorted from lo to hi
     * <p>
     * This function is recursive. This means that you should first call it
     * on the first half part of the array, then the other half. Once this is done,
     * you should merge the two parts together.
     * <p>
     * So if a = [1, 4, 2, 6, 3, 10], you should recursively call the method on
     * the part with [1, 4, 2] and [6, 3, 10] (! use the lo and hi index) then merge
     * these parts with the merge function.
     * <p>
     * hint: since the mergeSort function modify only from lo to hi, you can call it
     * successively on different part of the array
     */
    public static void mergeSort(int a[], int[] aux, int lo, int hi) {
        int mid = (lo + hi)/2;
        if (lo < hi){
            mergeSort(a, aux, lo, mid);
            mergeSort(a, aux, mid +1, hi);
        }
        merge(a,aux,lo,mid,hi);
    }

    /**
     * Rearranges the array in ascending order, using the natural order
     */
    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        int lo = 0;
        int hi = a.length - 1;
        sorting(a, aux, lo, hi);
    }

    private static void sorting(int[] a, int[] aux, int lo, int hi) {
        int mid = (lo + hi) / 2;
        if (lo < hi) {
            sorting(a, aux, lo, mid);
            sorting(a, aux, mid + 1, hi);
            System.out.println(aux.toString());
            merge(a, aux, lo, mid, hi);
        }

    }
}
