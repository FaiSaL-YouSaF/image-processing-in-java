package com.faisalyousaf777.imageprocessing.commons;

public class Common {

    public static final String PNG_FORMAT = "png";
    public static final int MAX_BYTE_VALUE = 0xFF;
    public static final int EIGHT_BITS = 8;
    public static final int SIXTEEN_BITS = 16;
    public static final int TWENTY_FOUR_BITS = 24;

    public static int extractAlphaFromPixel(int pixel) {
        return (pixel >> TWENTY_FOUR_BITS) & MAX_BYTE_VALUE;
    }
    public static int extractRedFromPixel(int pixel) {
        return (pixel >> SIXTEEN_BITS) & MAX_BYTE_VALUE;
    }
    public static int extractGreenFromPixel(int pixel) {
        return (pixel >> EIGHT_BITS) & MAX_BYTE_VALUE;
    }
    public static int extractBlueFromPixel(int pixel) {
        return pixel & MAX_BYTE_VALUE;
    }
    public static int packRGB(int red, int green, int blue) {
        return (red << SIXTEEN_BITS) | (green << EIGHT_BITS) | blue;
    }
    public static int packARGB(int alpha, int red, int green, int blue) {
        return (alpha << TWENTY_FOUR_BITS) | (red << SIXTEEN_BITS) | (green << EIGHT_BITS) | blue;
    }

    public static int inverseColor(int color) {
        return MAX_BYTE_VALUE - color;
    }
    public static int clampToValidColorRange(int color) {
        return Math.min(255, Math.max(0, color));
    }

}
