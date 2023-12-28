package com.faisalyousaf777.ImageProcessing;

import java.awt.image.BufferedImage;

@SuppressWarnings("SuspiciousNameCombination")
public class ImageTransform {
	
	static BufferedImage effectImage;
	
	public static BufferedImage rotateClockwise(BufferedImage sourceImage) {
		int width = sourceImage.getWidth();
		int height = sourceImage.getHeight();
		
		// Swapping width and height intentionally for clockwise rotation
		effectImage = new BufferedImage(height, width, sourceImage.getType());
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				int pixel = sourceImage.getRGB(column, row);
				effectImage.setRGB(height-1-row, column, pixel);
			}
		}
		return effectImage;
	}
	
	
	public static BufferedImage rotateCounterClockwise(BufferedImage sourceImage) {
		int width = sourceImage.getWidth();
		int height = sourceImage.getHeight();
		
		// Swapping width and height intentionally for clockwise rotation
		effectImage = new BufferedImage(height, width, sourceImage.getType());
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				int pixel = sourceImage.getRGB(column, row);
				effectImage.setRGB(row, width - 1 - column, pixel);
			}
		}
		return effectImage;
	}
	
	public static BufferedImage flipVertical(BufferedImage sourceImage) {
		int width = sourceImage.getWidth();
		int height = sourceImage.getHeight();
		
		effectImage = new BufferedImage(width, height, sourceImage.getType());
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				effectImage.setRGB(column, height - 1 - row, sourceImage.getRGB(column, row));
			}
		}
		return effectImage;
	}
	
	public static BufferedImage flipHorizontal(BufferedImage sourceImage) {
		int width = sourceImage.getWidth();
		int height = sourceImage.getHeight();
		
		effectImage = new BufferedImage(width, height, sourceImage.getType());
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				effectImage.setRGB(width - 1 - column, row, sourceImage.getRGB(column, row));
			}
		}
		return effectImage;
	}
	
	public static BufferedImage applyMirrorEffect(BufferedImage sourceImage) {
		int width = sourceImage.getWidth();
		int height = sourceImage.getHeight();
		
		effectImage = new BufferedImage(width, height, sourceImage.getType());
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				effectImage.setRGB(width - 1 - column, height - 1 - row, sourceImage.getRGB(column, row));
			}
		}
		return effectImage;
	}

}
