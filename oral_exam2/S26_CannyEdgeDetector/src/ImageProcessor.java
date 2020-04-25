public class ImageProcessor {
    public static int[][] addZeroPad(int[][] inputImage) {
        int[][] newImageArray = new int[inputImage.length+2][inputImage[0].length+2];

        for (int h = 0; h < inputImage.length + 2; h++) {
            for (int w = 0; w < inputImage[h].length + 2; w++) {
                if (w == 0 || h == 0 || w == inputImage[h].length + 1 || h == inputImage.length + 1) {
                    newImageArray[h][w] = 0;
                }
                else {
                    newImageArray[h][w] = inputImage[h-1][w-1];
                }
            }
        }

        return newImageArray;
    }
}
