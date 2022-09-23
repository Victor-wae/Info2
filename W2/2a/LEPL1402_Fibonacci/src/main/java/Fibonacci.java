public class Fibonacci {


    public static int fiboRecursive(int index){
        if (index > 1){
            return fiboRecursive(index-1)+fiboRecursive(index-2);
        }
        else
            return 1;
    }


    public static int fiboIterative(int index){
        if(index <= 1) {
            return index;
        }
        int fib = 1;
        int prevFib = 1;
        for(int i=2; i<index; i++) {
            int temp = fib;
            fib+= prevFib;
            prevFib = temp;
        }
        return fib;
    }

}
