public class IntroductionExercises {

    public static int variable = 0;

    public static int[] squares;

    /*
     * Function that bound variable to value
     */
    //TODO attribute(int value) method
    public static void attribute(int value) {
        value = variable;
    }

    /*
     * Function that return the addition of the two parameters
     */
    //TODO add(int a, int b) method
    public static int add(int a, int b) {
        return a + b;
    }

    /*
     * return true is a and b are equal
     */
    //TODO equalsIntegers(int a, int b) method
    public static boolean equalsIntegers(int a, int b) {
        if (a == b) return true;
        return false;

    }

    /*
     * Function that return the max between a and b
     * You must use a ternary operation
     */
    public static int max(int a, int b) {
        //TODO the body of this function in one line
        return  (a > b) ? a : b;
    }

    /*
     * Function that return the middle value.
     * If a > b > c, the function must return b.
     * If two value are equals, return -1.
     */
    //TODO middleValue(int a, int b, int c) method
    public static int middleValue(int a, int b, int c) {
        if (a == b || a == c || c == b) return -1;
        else if ((a > b && a < c) || (a < b && a > c)) return a;
        else if ((b > a && b < c) || (b < a && b > c)) return b;
        return c;
    }

    /*
     * This function must return :
     * "Good morning, sir!" if str is "Morning"
     * "Good evening, sir!" if str is "Evening"
     * "Hello, sir!" otherwise
     * Use a switch case statement
     * Your implementation must be case sensitive
     */
    //TODO greetings(String str) method
    public static String greetings(String str) {
        switch (str) {
            case ("Morning"):
                return "Good morning, sir!";
            case ("Evening"):
                return "Good evening, sir!";
            default:
                return "Hello, sir!";
        }
    }

    /*
     * This function must return a new array of length 3
     * The first element of this new array is the last element of a
     * The second element is the first element of a
     * The last element is the middle element of a
     */
    //TODO lastFirstMiddle(int[] a)
    public static int[] lastFirstMiddle(int[] a) {
        int[] b = new int[3];
        b[0] = a[a.length];
        b[1] = a[0];
        b[2] = a[a.length / 2];
        return b;
    }

    /*
     * This function must return the sum of the elements of array using a for loop
     */
    //TODO sum(int[] array) method
    public static int sum(int[] array) {
        int x = 0;
        for (int i : array) {
            x += i;
        }
        return x;
    }

    /*
     * return the maximum element of array using a while loop
     */
    //TODO maxArray(int[] array) method
    public static int maxArray(int[] array) {
        int max = array[0];
        int i = 1;
        while (i <= array.length - 1) {
            if (max < array[i]) max = array[i];
            i++;
        }
        return max;
    }


    /**
     * Assign to the variable square, the square of the
     * parameters.
     * <p>
     * Let assume that the program is invoked with the following
     * line:
     * java IntroductionExercises 0 3 4 5
     * <p>
     * The arguments of the program are 0, 3, 4 and 5.
     * After the execution of the main, the variable squares
     * should be:
     * squares = [0, 9, 16, 25]
     * <p>
     * If an exception occurs when converting an argument to
     * an integer, put 0 at the corresponding index. For example
     * <p>
     * java IntroductionExercise 0 3.1 4 5
     * <p>
     * would yield
     * <p>
     * square = [0, 0, 16, 25]
     * <p>
     * because 3.1 can not be converted to an integer
     */
    public static void main(String... args) {
        //TODO main body
        squares = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            try {
                squares[i] = Integer.parseInt(args[i]) * Integer.parseInt(args[i]);
            } catch (Exception e) {
                continue;
            }
        }
    }
}
