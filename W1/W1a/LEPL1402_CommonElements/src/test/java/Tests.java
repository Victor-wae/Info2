import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {


    @Test
    public void basicTest() {
        int[] t1 = new int[]{1, 3, 4};
        int[] t2 = new int[]{3, 3, 4, 1};
        assertEquals(2, CommonElements.count(t1, t2));

    }
    @Test
    public void test2(){
        int[][] t1 = new int[][]{{1,2,3,4},{5,6,7,8}};
        int[][] t2 = new int[][]{{1,3,3,5},{5,5,7,7}};
        assertEquals(4, CommonElements.count(t1, t2));
    }

}


