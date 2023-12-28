package com.faisalyousaf777;

import com.faisalyousaf777.ImageProcessing.ImageTransform;
import com.faisalyousaf777.ImageProcessing.ReadAndWriteImages;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) {
		String sourceImageLocation = "/home/android-developer/Pictures/Wallpapers/ana_de_armas.jpg";
		String imageName = "ana_de_armas_" + LocalDate.now() + "_" + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
		String effectImageLocation = "/home/android-developer/Pictures/Wallpapers/Effected Images/" + imageName;
		int firstColor = 0xFFFFFF00;
		int secondColor = 0xFF00FF00;
		
		BufferedImage sourceImage1 = ReadAndWriteImages.loadImageFromDisk(sourceImageLocation);
		BufferedImage effectImage1 = ImageTransform.applyMirrorEffect(sourceImage1);
		ReadAndWriteImages.writeImageToDisk(effectImage1, ImageFilters.PNG_FORMAT, effectImageLocation);

	}
}