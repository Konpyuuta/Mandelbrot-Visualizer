package org.example.mandelbrotview;

/**
 *
 * @author Maurice Amon
 */

public class MandelbrotArray {

    private Integer[][] mandelbrotArray = new Integer[1200][700];

    private Object[] mandelbrotLocks = new Object[700];

    private static MandelbrotArray instance;


    public static MandelbrotArray getInstance() {
        if (instance == null) {
            instance = new MandelbrotArray();
        }
        return instance;
    }

    private MandelbrotArray() {
            for (int j = 0; j < 700; j++) {
                mandelbrotLocks[j] = new Object();
            }

    }

    public void setPixelValue(int x, int y, int value) {
        // We apply the lock to the row ...
        // As all threads are working on different rows it's not really necessary, the reason why I implemented it
        // is for safety reasons
        synchronized (mandelbrotLocks[y]) {
            mandelbrotArray[x][y] = value;
        }
    }

    public Integer[][] getMandelbrotArray() {
        return mandelbrotArray;
    }


}
