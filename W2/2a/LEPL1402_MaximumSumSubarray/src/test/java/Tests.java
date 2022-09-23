import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void testOneElement(){
      int[] alone = {1};
      int[] expected = {1, 0, 0};
      assertArrayEquals(MaximumSubArray.maxSubArray(alone), expected);
    }

    @Test
    public void testExample(){
      int[] example = {-2,1,-3,4,-1,2,1,-5,4};
      int[] expected = {6, 3, 6};
      assertArrayEquals(MaximumSubArray.maxSubArray(example), expected);
    }
    @Test
    public void Neg(){
        int[] example = {-1,-1,-3,-4,-1,-2,-1,-5,-4};
        int[] expected = {-1, 0, 0};
        assertArrayEquals(MaximumSubArray.maxSubArray(example), expected);
    }
}
