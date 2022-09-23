
import java.util.ArrayList;
import java.util.List;

public class Except {


    public static void outof() {
        int[] list = new int[5];
        System.out.println(list[5]);
    }

    public static void concurr() {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(45);
        a.add(15);
        for (int i : a) {
            a.add(1);
        }

    }

    public static void nullpointer() {
        ArrayList<Integer> a = null;
        a.size();
    }


}