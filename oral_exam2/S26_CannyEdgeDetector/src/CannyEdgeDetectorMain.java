public class CannyEdgeDetectorMain {
    public static void main(String[] args) throws Exception {
        int[][] inputImage, newArray;

        inputImage = BitmapConverter.bitmapConverter();
        newArray = ImageProcessor.addZeroPad(inputImage);



    }
}
