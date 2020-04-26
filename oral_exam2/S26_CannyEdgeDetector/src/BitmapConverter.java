import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class BitmapConverter {
    public static int[][] bitmapConverter() throws Exception{
        BufferedImage img = ImageIO.read(new File("oral_exam2/S26_CannyEdgeDetector/SampleSquareImage.bmp"));
        int height = img.getHeight();
        int width = img.getWidth();
        //System.out.println(height + " " + width + " " + img.getRGB(10,10));
        int[][] imageArray = new int[height][width];

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                int rgb = img.getRGB(w, h);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = (rgb) & 0xFF;
                float rgbToGray = (red * 0.2126f + green * 0.7152f + blue * 0.0722f);
                int grayScale = Math.round(rgbToGray);
                imageArray[h][w] = grayScale;
            }
        }

        return imageArray;

    }

    public static void arrayConverter(int[][] arrayToConvert) {
        try {
            BufferedImage newImg = new BufferedImage(arrayToConvert.length, arrayToConvert[0].length, BufferedImage.TYPE_INT_RGB);
            for (int h = 0; h < arrayToConvert.length; h++) {
                for (int w = 0; w < arrayToConvert[0].length; w++) {
                    int grayscale = arrayToConvert[h][w];
                    int rgb = new Color(grayscale, grayscale, grayscale).getRGB();
                    newImg.setRGB(w, h, rgb);
                }
            }
            File out = new File("oral_exam2/S26_CannyEdgeDetector/output.bmp");
            ImageIO.write(newImg, "bmp", out);
        }
        catch (Exception e) {
            System.out.println("nope");
        }

    }

}
