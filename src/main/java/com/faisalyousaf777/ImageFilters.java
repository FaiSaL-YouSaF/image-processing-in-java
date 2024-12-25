package com.faisalyousaf777;

import java.awt.image.BufferedImage;

import static com.faisalyousaf777.imageprocessing.commons.Common.*;

public class ImageFilters {
	
	static BufferedImage  effectImage;
	
	
	public static BufferedImage applyGrayScale(BufferedImage sourceImage) {
		int width = sourceImage.getWidth();
		int height = sourceImage.getHeight();
		effectImage = new BufferedImage(width, height, sourceImage.getType());
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				int pixel = sourceImage.getRGB(column, row);
				
				int alpha = extractAlphaFromPixel(pixel);
				int red = extractRedFromPixel(pixel);
				int green = extractGreenFromPixel(pixel);
				int blue = extractBlueFromPixel(pixel);
				
				red = green = blue = (red + green + blue) / 3;
				
				pixel = packARGB(alpha, red, green, blue);
				effectImage.setRGB(column, row, pixel);
			}
		}
		return effectImage;
	}
	
	public static BufferedImage applyColorInversion(BufferedImage sourceImage){
		int width = sourceImage.getWidth();
		int height = sourceImage.getHeight();
		effectImage = new BufferedImage(width, height, sourceImage.getType());
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				int pixel = sourceImage.getRGB(column, row);
				
				int alpha = extractAlphaFromPixel(pixel);
				int red = extractRedFromPixel(pixel);
				int green = extractGreenFromPixel(pixel);
				int blue = extractBlueFromPixel(pixel);
				
				red = inverseColor(red);
				green = inverseColor(green);
				blue = inverseColor(blue);
				
				pixel = packARGB(alpha,red,green,blue);
				
				effectImage.setRGB(column,row,pixel);
			}
		}
		return effectImage;
	}
	
	public static BufferedImage applySepiaTone(BufferedImage sourceImage) {
		int width = sourceImage.getWidth();
		int height = sourceImage.getHeight();
		effectImage = new BufferedImage(width, height, sourceImage.getType());
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				int pixel = sourceImage.getRGB(column, row);
				
				int red = extractRedFromPixel(pixel);
				int green = extractGreenFromPixel(pixel);
				int blue = extractBlueFromPixel(pixel);
				
				red = (int) (0.393*red + 0.769*green + 0.189*blue);
				green = (int) (0.349*red + 0.686*green + 0.168*blue);
				blue = (int) (0.272*red + 0.534*green + 0.131*blue);
				
				red = clampToValidColorRange(red);
				green = clampToValidColorRange(green);
				blue = clampToValidColorRange(blue);
				
				pixel = packRGB(red, green, blue);
				effectImage.setRGB(column, row, pixel);
			}
		}
		return effectImage;
	}
	
	public static BufferedImage modifyBrightness(BufferedImage sourceImage, int brightnessValue) {
		int width = sourceImage.getWidth();
		int height = sourceImage.getHeight();
		effectImage = new BufferedImage(width, height, sourceImage.getType());
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				int pixel = sourceImage.getRGB(column, row);
				
				int red = extractRedFromPixel(pixel);
				int green = extractGreenFromPixel(pixel);
				int blue = extractBlueFromPixel(pixel);
				
				red = red + brightnessValue;
				green = green + brightnessValue;
				blue = blue + brightnessValue;
				
				pixel = packRGB(
						clampToValidColorRange(red),
						clampToValidColorRange(green),
						clampToValidColorRange(blue)
				);
				effectImage.setRGB(column, row, pixel);
			}
		}
		return effectImage;
	}
	
}
