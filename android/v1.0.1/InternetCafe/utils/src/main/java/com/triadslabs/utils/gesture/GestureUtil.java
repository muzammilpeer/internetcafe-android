package com.triadslabs.utils.gesture;

/**
 * Created by MuzammilPeer on 3/13/2015.
 */
public class GestureUtil {
    public static boolean isPointWithin(int x, int y, int x1, int x2, int y1, int y2) {
        return (x <= x2 && x >= x1 && y <= y2 && y >= y1);
    }
}
