import java.util.Arrays;

/**
 * Make sure that the equal method consider
 * two QR codes as identical if they have been flipped
 * by 0,1,2 or 3 quarter rotations
 * <p>
 * For instance the two following matrices should be
 * considered equals if you flip your head by 180 degrees
 * <p>
 * boolean [][] t0 = new boolean[][] {
 * {false,true,false,false},
 * {false,false,true,true},
 * {true,false,false,true},
 * {true,true,false,true}
 * };
 * <p>
 * // t2 is a version of t2 with two quarter rotations
 * boolean [][] t2 = new boolean[][] {
 * {true,false,true,true},
 * {true,false,false,true},
 * {true,true,false,false},
 * {false,false,true,false}
 * };
 */
public class QRcode {

    protected boolean[][] data;

    /**
     * Create a QR code object
     *
     * @param data is a n x n square matrix
     */
    public QRcode(boolean[][] data) {
        this.data = data;
    }

    /**
     * Return true if the other matrix is identical up to
     * 0, 1, 2 or 3 number of rotations
     *
     * @param o the other matrix to compare to
     * @return
     */
    @Override
    public boolean equals(Object o) {
        // TODO
        QRcode toVerify = (QRcode) o;
        int n = 0;
        boolean isnotequal = false;

        boolean[][] sizer = new boolean[this.data.length][this.data[0].length];
        QRcode newQrCode = new QRcode(sizer);
        if (this.data.length == toVerify.data.length && this.data[0].length == toVerify.data[0].length) {
            // verif exact
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data.length; j++) {
                    if (this.data[i][j] != toVerify.data[i][j]) {
                        isnotequal = true;
                    }
                }
            }
            if (!isnotequal) {
                return true;
            } else {
                isnotequal = false;
            }
            // verif rotation
            while (n != 3) {
                for (int i = 0; i < this.data.length; i++) {
                    for (int j = 0; j < this.data.length; j++) {
                        newQrCode.data[j][(this.data.length - 1) - i] = this.data[i][j];
                    }
                }
                for (int i = 0; i < this.data.length; i++) {
                    for (int j = 0; j < this.data.length; j++) {
                        if (newQrCode.data[i][j] != toVerify.data[i][j]) {
                            isnotequal = true;
                        }
                    }
                }
                if (isnotequal) {
                    this.data = newQrCode.data;
                    n++;
                    isnotequal = false;
                } else {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;

    }
}