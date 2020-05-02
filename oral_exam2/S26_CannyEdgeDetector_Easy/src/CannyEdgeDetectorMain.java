/**
 * Main class of Canny Edge Detector that calls all other necessary methods to find the edges of a .bmp image
 * @author Dean Farwell
 */
public class CannyEdgeDetectorMain {

    /**
     * Main method of canny edge detector that calls all necessary methods to get the edge image from a .bmp image
     * @param args String array of arguments required by Java
     * @throws Exception Thrown if there is an issue opening or writing to the file.
     */
    public static void main(String[] args) throws Exception {
        int[][] inputImage, newArray; // stores the brightness values of each pixel of the image

        inputImage = BitmapConverter.bitmapConverter();
        newArray = ImageProcessor.addZeroPad(inputImage);
        newArray = ImageProcessor.cannyEdgeDetector(newArray);
        BitmapConverter.arrayConverter(newArray);
    }
}
