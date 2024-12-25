package com.faisalyousaf777.imageprocessing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadAndWriteImage {
	
	public static void writeImageToDisk(BufferedImage effectImage, String formatName, String path) {
		boolean isImageWritten = false;
		try {
			isImageWritten = ImageIO.write(effectImage, formatName, new File(path));
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		String resultMessage = isImageWritten ?  "Image successfully written to disk!" : "Failed to write image to disk!";
		System.out.println(resultMessage);
	}
	
	public static BufferedImage loadImageFromDisk(String path) {
		BufferedImage sourceImage = null;
		try {
			sourceImage = ImageIO.read(new File(path));
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return sourceImage;
	}
}
