package com.triadslabs.internetcafe.utils;

/**
 * Created by muzammilpeer on 1/9/15.
 */
public class GestureUtils {

    public static boolean isPointWithin(int x, int y, int x1, int x2, int y1, int y2) {
        return (x <= x2 && x >= x1 && y <= y2 && y >= y1);
    }
}
