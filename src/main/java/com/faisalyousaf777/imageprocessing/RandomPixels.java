package com.faisalyousaf777.imageprocessing;

import com.faisalyousaf777.ImageFilters;

import java.awt.image.BufferedImage;

import static com.faisalyousaf777.imageprocessing.commons.Common.packARGB;

public class RandomPixels {
	static BufferedImage effectImage;
	public static int randomColorValueGenerator() {
		return (int)(Math.random()*255);
	}
	public static BufferedImage randomColorValuePixels(final int width, final int height, int imageType) {
		effectImage = new BufferedImage(width, height, imageType);
		
		for (int row = 0; row < width; row++) {
			for (int column = 0; column < height; column++) {
				int alpha = randomColorValueGenerator();
				int red = randomColorValueGenerator();
				int green = randomColorValueGenerator();
				int blue = randomColorValueGenerator();
				
				int pixel = packARGB(alpha, red, green, blue);
				effectImage.setRGB(row, column, pixel);
			}
		}
		return effectImage;
	}
	
	public static BufferedImage pureBlackImage(final int width, final int height, int imageType) {
		effectImage = new BufferedImage(width, height, imageType);
		
		for (int row = 0; row < width; row++) {
			for (int column = 0; column < height; column++) {
				int blackColor = 0xFF000000;
				effectImage.setRGB(row, column, blackColor);
			}
		}
		return effectImage;
	}
	
	public static BufferedImage createHorizontalSplitColorImage(final int width, final int height, int imageType, final int leftHalfColor, final int rightHalfColor) {
		effectImage = new BufferedImage(width, height, imageType);
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				if (column <= (width/2)) {
					effectImage.setRGB(column, row, leftHalfColor);
				} else {
					effectImage.setRGB(column, row, rightHalfColor);
				}
			}
		}
		return effectImage;
	}
	
	public static BufferedImage createVerticalSplitColorImage(final int width, final int height, int imageType, final int topHalfColor, final int bottomHalfColor) {
		effectImage = new BufferedImage(width, height, imageType);
		
		for (int row = 0; row < height; row++) {
			if (row <= (height/2)) {
				for (int column = 0; column < width; column++) {
					effectImage.setRGB(column, row, topHalfColor);
				}
			} else {
				for (int column = 0; column < width; column++) {
					effectImage.setRGB(column, row, bottomHalfColor);
				}
			}
			
		}
		return effectImage;
	}
	
	public static BufferedImage createVerticalMultiSplitColorImage(final int width, final int height, int imageType, final int topHalfColor, final int bottomHalfColor) {
		effectImage = new BufferedImage(width, height, imageType);
		
		for (int row = 0; row < height; row++) {
			if (row %2 == 0) {
				for (int column = 0; column < width; column++) {
					effectImage.setRGB(column, row, topHalfColor);
				}
			} else {
				for (int column = 0; column < width; column++) {
					effectImage.setRGB(column, row, bottomHalfColor);
				}
			}
			
		}
		return effectImage;
	}
	
	public static BufferedImage createAntiDiagonalSplitColorImage(final int size, int imageType, final int firstHalfColor, final int secondHalfColor) {
		effectImage = new BufferedImage(size, size, imageType);
		
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				if (column <= row) {
					effectImage.setRGB(column, row, firstHalfColor);
				} else {
					effectImage.setRGB(column, row, secondHalfColor);
				}
			}
		}
		return effectImage;
	}
	
	public static BufferedImage createDiagonalSplitColorImage(final int size, int imageType, final int firstHalfColor, final int secondHalfColor) {
		effectImage = new BufferedImage(size, size, imageType);
		
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				if (column < (size - row)) {
					effectImage.setRGB(column, row, firstHalfColor);
				} else {
					effectImage.setRGB(column, row, secondHalfColor);
				}
			}
		}
		return effectImage;
	}
	
	public static BufferedImage createDiamondInImage(final int size, int imageType, final int bgColor, final int diamondColor) {
		effectImage = new BufferedImage(size, size, imageType);
		
		int start, mid, end;
		start = end = mid = (size/2) - 1;
		
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				
				if (column >= start && column <= end) {
					effectImage.setRGB(column, row, diamondColor);
				} else {
					effectImage.setRGB(column, row, bgColor);
				}
			}

			if (row < mid) {
				start--;
				end++;
			} else {
				start++;
				end--;
			}
		}
		return effectImage;
	}
	
	
}
