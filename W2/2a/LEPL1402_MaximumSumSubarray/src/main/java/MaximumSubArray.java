public class MaximumSubArray {


    /**
     * Find the contiguous subarray with the maximal sum
     *
     * @param a a non-empty array
     * @return A triplet (sum, start, end) with sum the sum of the subarray and `start` and `end` the
     *         start and end of the subarray
     *
     * For example for the array [-2,1,-3,4,-1,2,1,-5,4] your method should return [6, 3, 6]
     */
    public static int[] maxSubArray(int[] a){
        // TODO: students
        int[] max = {Integer.MIN_VALUE,0,0};
        int sum = 0;
        int j = 0;
        for (int i = 0;i < a.length;i++){
            sum += a[i];
            if (sum > max[0]){
                max[0] = sum;
                max[1] = j;
                max[2] = i;
            }
            if (sum < 0){
                sum = 0;
                j = i + 1;/*si je met i++, cela ajoute 1 aussi à i**/
            }
        }return max;
    }
}
