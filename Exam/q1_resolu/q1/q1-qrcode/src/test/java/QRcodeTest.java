import org.junit.Test;

import static org.junit.Assert.*;

public class QRcodeTest {
    
    @Test
    public void test1() {
        boolean [][] t0 = new boolean[][] {
                {false,true,false,false},
                {false,false,true,true},
                {true,false,false,true},
                {true,true,false,true}
        };

        // t1 is a version of t0 with one quarter clockwise rotation
        // just turn your head to reaad t0 and you will see t1
        boolean [][] t1 = new boolean[][] {
                {false,true,true,true},
                {false,true,false,false},
                {true,false,false,true},
                {false,false,true,true}
        };

        // t2 is a version of t1 with one quarter clockwise rotation
        boolean [][] t2 = new boolean[][] {
                {true,false,true,true},
                {true,false,false,true},
                {true,true,false,false},
                {false,false,true,false}
        };

        // t3 is a version of t2 with one quarter clockwise rotation
        boolean [][] t3 = new boolean[][] {
                {true,true,false,false},
                {true,false,false,true},
                {false,false,true,false},
                {true,true,true,false}
        };

        QRcode qr0 = new QRcode(t0);
        QRcode qr1 = new QRcode(t1);
        QRcode qr2 = new QRcode(t2);
        QRcode qr3 = new QRcode(t3);

        // all the rotated versions should be equal
        QRcode [] qrs = new QRcode[]{qr0,qr1,qr2,qr3};

        for (int i = 0; i < qrs.length; i++) {
            for (int j = 0; j < qrs.length; j++) {
                assertTrue(qrs[i].equals(qrs[j]));
            }
        }

        // now we modify one entry
        boolean [][] t0_modif = new boolean[][] {
                {true,true,false,false},
                {false,false,true,true},
                {true,false,false,true},
                {true,true,false,true}
        };

        // and all of them shoould be different from the modified version
        for (int j = 0; j < qrs.length; j++) {
                assertFalse(t0_modif.equals(qrs[j]));
        }
    }


}
