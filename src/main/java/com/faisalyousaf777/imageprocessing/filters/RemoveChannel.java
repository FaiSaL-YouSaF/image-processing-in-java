package com.faisalyousaf777.imageprocessing.filters;

import java.awt.image.BufferedImage;

import static com.faisalyousaf777.imageprocessing.commons.Common.*;

public class RemoveChannel {

    static BufferedImage  effectImage;

    public static BufferedImage removeRedChannel(BufferedImage sourceImage) {
        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();
        effectImage = new BufferedImage(width, height, sourceImage.getType());

        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                int pixel = sourceImage.getRGB(column, row);

                int alpha = extractAlphaFromPixel(pixel);
                int green = extractGreenFromPixel(pixel);
                int blue = extractBlueFromPixel(pixel);

                int red = 0;

                pixel = packARGB(alpha, red, green, blue);
                effectImage.setRGB(column, row, pixel);
            }
        }
        return effectImage;
    }


    public static BufferedImage removeGreenChannel(BufferedImage sourceImage) {
        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();
        effectImage = new BufferedImage(width, height, sourceImage.getType());

        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                int pixel = sourceImage.getRGB(column, row);

                int alpha = extractAlphaFromPixel(pixel);
                int red = extractRedFromPixel(pixel);
                int blue = extractBlueFromPixel(pixel);

                int green = 0;

                pixel = packARGB(alpha, red, green, blue);
                effectImage.setRGB(column, row, pixel);
            }
        }
        return effectImage;
    }

    public static BufferedImage removeBlueChannel(BufferedImage sourceImage) {
        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();
        effectImage = new BufferedImage(width, height, sourceImage.getType());

        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                int pixel = sourceImage.getRGB(column, row);

                int alpha = extractAlphaFromPixel(pixel);
                int red = extractRedFromPixel(pixel);
                int green = extractGreenFromPixel(pixel);

                int blue = 0;

                pixel = packARGB(alpha, red, green, blue);
                effectImage.setRGB(column, row, pixel);
            }
        }
        return effectImage;
    }
}
