public class ImageProcessor {
    public static int[][] addZeroPad(int[][] inputImage) {
        int[][] newImageArray = new int[inputImage.length+2][inputImage[0].length+2];

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

    public static int[][] cannyEdgeDetector(int[][] imageToProcess) {
        int[][] edgeDetectedImage = new int[imageToProcess.length][imageToProcess[0].length];

        for (int h = 0; h < imageToProcess.length; h++) {
            for (int w = 0; w < imageToProcess[0].length; w++) {
                if (h != 0 && h != imageToProcess.length - 1 && w != 0 && w != imageToProcess[0].length - 1) {
                    int gX = 0, gY = 0;
                    gX = imageToProcess[h-1][w-1] + imageToProcess[h][w-1] + imageToProcess[h+1][w-1] - imageToProcess[h-1][w+1] - imageToProcess[h][w+1] - imageToProcess[h+1][w+1];
                    gY = imageToProcess[h-1][w-1] + imageToProcess[h-1][w] + imageToProcess[h-1][w+1] - imageToProcess[h+1][w-1] - imageToProcess[h+1][w] - imageToProcess[h+1][w+1];
                    double g = Math.sqrt(gX * gX + gY * gY);
                    int edge = (int) (g/3);
                    //int edge = gX / 3;
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
