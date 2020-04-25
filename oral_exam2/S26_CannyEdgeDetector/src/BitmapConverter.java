import sun.jvm.hotspot.utilities.BitMap;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class BitmapConverter {
    public static int[][] bitmapConverter() throws Exception{
        BufferedImage img = ImageIO.read(new File("oral_exam2/S26_CannyEdgeDetector/EASY_sample_image.bmp"));
        int height = img.getHeight();
        int width = img.getWidth();
        //System.out.println(height + " " + width + " " + img.getRGB(10,10));
        int[][] imageArray = new int[height][width];

        for (int h = 0; h < height + 2; h++) {
            for (int w = 0; w < width + 2; w++) {
//                if (w == 0 || h == 0 || w == width + 1 || h == height + 1) {
//                    imageArray[h][w] = 0;
//                }
                //else {
                    int rgb = img.getRGB(w, h); // -1
                    int red = (rgb >> 16) & 0xFF;
                    int green = (rgb >> 8) & 0xFF;
                    int blue = (rgb) & 0xFF;
                    float rgbToGray = (red * 0.2126f + green * 0.7152f + blue * 0.0722f);
                    int grayScale = Math.round(rgbToGray);
                    //System.out.println(grayScale);
                    imageArray[h][w] = grayScale;
               // }
            }
        }

        return imageArray;

    }

}
