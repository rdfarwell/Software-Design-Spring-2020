import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Class that handles the IO of the image file.
 * @author Dean Farwell
 */
public class BitmapConverter {

    /**
     * Method that handles the input and reading of a .bmp image
     * @return An integer matrix that contains the brightness values of each pixel of the image
     * @throws Exception Thrown if there is an error opening the file
     */
    public static int[][] bitmapConverter() throws Exception{
        BufferedImage img = ImageIO.read(new File("oral_exam2/S26_CannyEdgeDetector_Easy/HARD_sample_coins.bmp"));
        int height = img.getHeight();
        int width = img.getWidth();
        int[][] imageArray = new int[height][width];

        // gets the color value of each pixel and converts it to the brightness value using a conversion algorithm/equation
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

    /**
     * Method that converts a given matrix of brightness values into an .bmp image
     * @param arrayToConvert Matrix that contains the brightness value of each pixel to be turned into an image
     */
    public static void arrayConverter(int[][] arrayToConvert) {
        try {
            BufferedImage newImg = new BufferedImage(arrayToConvert.length, arrayToConvert[0].length, BufferedImage.TYPE_INT_RGB);

            // converts from brightness (gray scale) to rgb and sets each image pixel as such
            for (int h = 0; h < arrayToConvert.length; h++) {
                for (int w = 0; w < arrayToConvert[0].length; w++) {
                    int grayscale = arrayToConvert[h][w];
                    int rgb = new Color(grayscale, grayscale, grayscale).getRGB();
                    newImg.setRGB(w, h, rgb);
                }
            }

            // create and write to the files
            File out = new File("oral_exam2/S26_CannyEdgeDetector_Easy/output.bmp");
            ImageIO.write(newImg, "bmp", out);
        }
        catch (Exception e) {
            System.out.println("Error writing to file");
        }
    }
}