public class Valley {

    /**
     * Compute the deepest valley and highest mountain
     *
     * @param slopes A non-empty array of slope
     * @return An array of two element. The first is the
     * depth of the deepest valley and the second
     * the height of the highest mountain
     */
    public static int[] valley(int[] slopes) {
        int[] data = new int[2];
        int[] data2 = new int[2];
        int[] output = new int[2];

        for (int i = 0; i < slopes.length - 1; i++) {
            if (slopes[i] > 0) {
                data[0]++;
            } else {
                data[1]++;
            }
            if (data[1] > 0 && data[1] <= data2[1] && data[1] > output[1]) {
                output[1] = data[1];
            }
            if (data[0] > 0 && data[0] <= data2[0] && data[0] > output[0]) {
                output[0] = data[0];
            }
            if (slopes[i] > slopes[i + 1]) {
                data2[1] = data[0];
                data[0] = 0;
                data[1] = 0;
            } else if (slopes[i] < slopes[i + 1]) {
                data2[0] = data[1];
                data[0] = 0;
                data[1] = 0;
            }
        }
        if (slopes[slopes.length - 1] > 0 && data[0] + slopes[slopes.length - 1] > output[1]) {
            output[0] = data[0] + slopes[slopes.length - 1];
        } else if (data[1] - slopes[slopes.length - 1] > output[0]) {
            output[1] = data[1] - slopes[slopes.length - 1];
        }
        return output;
    }
}
