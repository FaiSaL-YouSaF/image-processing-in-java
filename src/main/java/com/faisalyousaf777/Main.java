package com.faisalyousaf777;

import com.faisalyousaf777.imageprocessing.ImageTransform;
import com.faisalyousaf777.imageprocessing.ReadAndWriteImage;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.faisalyousaf777.imageprocessing.commons.Common.PNG_FORMAT;

public class Main {
	public static void main(String[] args) {
		String sourceImageLocation = "/home/android-developer/Pictures/Wallpapers/ana_de_armas.jpg";
		String imageName = "ana_de_armas_" + LocalDate.now() + "_" + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
		String effectImageLocation = "/home/android-developer/Pictures/Wallpapers/Effected Images/" + imageName;
		int firstColor = 0xFFFFFF00;
		int secondColor = 0xFF00FF00;
		
		BufferedImage sourceImage1 = ReadAndWriteImage.loadImageFromDisk(sourceImageLocation);
		BufferedImage effectImage1 = ImageTransform.applyMirrorEffect(sourceImage1);
		ReadAndWriteImage.writeImageToDisk(effectImage1, PNG_FORMAT, effectImageLocation);

	}
}