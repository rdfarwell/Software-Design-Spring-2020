import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Producer and Consumer threads correctly manipulating a circular buffer.
 * @author In-Text Example
 */
public class CircularBufferTest {

    /**
     * Main method that shows Producer and Consumer threads correctly manipulating a circular buffer.
     * @param args String array of arguments that is required for the main method in Java
     * @throws InterruptedException Thrown if the thread has any timeout issues
     */
    public static void main(String[] args) throws InterruptedException {
        // create new thread pool with two threads
        ExecutorService executorService = Executors.newCachedThreadPool();

        // create CircularBuffer to store ints
        CircularBuffer sharedLocation = new CircularBuffer();

        // display the initial state of the CircularBuffer
        sharedLocation.displayState("Initial State");

        // execute the Producer and Consumer tasks
        executorService.execute(new Producer(sharedLocation));
        executorService.execute(new Consumer(sharedLocation));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
} // end class CircularBufferTest


/* ************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/