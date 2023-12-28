package com.faisalyousaf777;

import java.awt.image.BufferedImage;

public class ImageFilters {
	
	static BufferedImage  effectImage;
	
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
