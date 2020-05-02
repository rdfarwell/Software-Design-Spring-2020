/**
 * Class that handles adding the zero pad and the canny edge detector
 * @author Dean Farwell
 */
public class ImageProcessor {

    /**
     * Method that adds a "pad" of zeros around the image array.
     * @param inputImage Integer matrix that represents the brightness values of each pixel.
     * @return The input image matrix with two extra rows and columns in which the outer ones are all zeros.
     */
    public static int[][] addZeroPad(int[][] inputImage) {
        int[][] newImageArray = new int[inputImage.length+2][inputImage[0].length+2]; // add two rows and columns for the zeros

        // adds the zeros to the edges and copies the input image into the middle of the new matrix
        for (int h = 0; h < inputImage.length + 2; h++) {
            for (int w = 0; w < inputImage[0].length + 2; w++) {
                if (w == 0 || h == 0 || w == inputImage[0].length + 1 || h == inputImage.length + 1) {
                    newImageArray[h][w] = 0;
                }
                else {
                    newImageArray[h][w] = inputImage[h-1][w-1];
                }
            }
        }

        return newImageArray;
    }

    /**
     * Method that uses a pre-determined algorithm (filter) to detect the edges of an image.
     * @param imageToProcess Integer matrix that represents the brightness values of each pixel.
     * @return An integer matrix representing the edge detected image in which the brighter the pixel, the more likely there was an edge.
     */
    public static int[][] cannyEdgeDetector(int[][] imageToProcess) {
        int[][] edgeDetectedImage = new int[imageToProcess.length][imageToProcess[0].length];

        for (int h = 0; h < imageToProcess.length; h++) {
            for (int w = 0; w < imageToProcess[0].length; w++) {
                if (h != 0 && h != imageToProcess.length - 1 && w != 0 && w != imageToProcess[0].length - 1) { // checks for edges to prevent out of bounds issues
                    int gX = 0, gY = 0;
                    gX = imageToProcess[h-1][w-1] + imageToProcess[h][w-1] + imageToProcess[h+1][w-1] - imageToProcess[h-1][w+1] - imageToProcess[h][w+1] - imageToProcess[h+1][w+1];
                    gY = imageToProcess[h-1][w-1] + imageToProcess[h-1][w] + imageToProcess[h-1][w+1] - imageToProcess[h+1][w-1] - imageToProcess[h+1][w] - imageToProcess[h+1][w+1];
                    double g = Math.sqrt(gX * gX + gY * gY); // magnitude of the edge detection filter on the pixel
                    int edge = (int) (g/3); // converts to brightness on the 0 - 255 scale
                    edgeDetectedImage[h][w] = edge;
                }
                else {
                    edgeDetectedImage[h][w] = 0;
                }
            }
        }
        return edgeDetectedImage;
    }
}