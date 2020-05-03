import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronizing access to a shared three-element bounded buffer. Edited to use locks and conditions
 * @author In-Text Example
 * @author Dean Farwell
 */
public class CircularBuffer implements Buffer {

    /**
     * Shared buffer
     */
    private final int[] buffer = {-1, -1, -1};

    /**
     * Count number of buffers used
     */
    private int occupiedCells = 0;

    /**
     * Index of next element to write to
     */
    private int writeIndex = 0;

    /**
     * Index of next element to read
     */
    private int readIndex = 0;

    /**
     * Lock to restrain access of the Consumer and Producer classes using locks and conditions
     */
    private final Lock accessLock = new ReentrantLock();

    /**
     * Condition to let the buffer know there is a cell free
     */
    private final Condition canWrite = accessLock.newCondition();

    /**
     * Condition to let the buffer know there is a cell to read
     */
    private final Condition canRead = accessLock.newCondition();

    /**
     * Places values into buffer.
     * @param value Value to be placed into the buffer
     * @throws InterruptedException Thrown if there is a thread issue
     */
    public void blockingPut(int value) throws InterruptedException {
        accessLock.lock(); // lock this object

        try {
            // wait until buffer has space available, then write value;
            // while no empty locations, place thread in waiting state
            while (occupiedCells == buffer.length) {
                System.out.println("Producer tries to write.");
                System.out.printf("Buffer is full. Producer waits.%n");
                canWrite.await(); // wait until a buffer cell is free
            }

            buffer[writeIndex] = value; // set new buffer value

            // update circular write index
            writeIndex = (writeIndex + 1) % buffer.length;

            ++occupiedCells; // one more buffer cell is full
            displayState("Producer writes " + value);
            canRead.signalAll(); // signal waiting threads to read from buffer
        } finally {
            accessLock.unlock();
        }
    }

    /**
     * Returns value from buffer.
     * @return Value that was contained within the buffer
     * @throws InterruptedException Thrown if there is a thread issue
     */
    public int blockingGet() throws InterruptedException {
        int readValue = 0; // value read from buffer
        accessLock.lock(); // lock this object

        try {
            // wait until buffer has data, then read value;
            // while no data to read, place thread in waiting state
            while (occupiedCells == 0) {
                System.out.println("Consumer tries to read.");
                System.out.printf("Buffer is empty. Consumer waits.%n");
                canRead.await(); // wait until a buffer cell is filled
            }

            readValue = buffer[readIndex]; // read value from buffer

            // update circular read index
            readIndex = (readIndex + 1) % buffer.length;

            --occupiedCells; // one fewer buffer cells are occupied
            displayState("Consumer reads " + readValue);
            canWrite.signalAll(); // signal threads that buffer is empty
        } finally {
            accessLock.unlock();
        }
        return readValue;
    }

    /**
     * Display current operation and buffer state.
     * @param operation Operation to be performed
     */
    public void displayState(String operation) {
        try {
            accessLock.lock();
            // output operation and number of occupied buffer cells
            System.out.printf("%s%s%d)%n%s", operation,
                    " (buffer cells occupied: ", occupiedCells, "buffer cells:  ");

            for (int value : buffer)
                System.out.printf(" %2d  ", value); // output values in buffer

            System.out.printf("%n               ");

            for (int i = 0; i < buffer.length; i++)
                System.out.print("---- ");

            System.out.printf("%n               ");

            for (int i = 0; i < buffer.length; i++) {
                if (i == writeIndex && i == readIndex)
                    System.out.print(" WR"); // both write and read index
                else if (i == writeIndex)
                    System.out.print(" W   "); // just write index
                else if (i == readIndex)
                    System.out.print("  R  "); // just read index
                else
                    System.out.print("     "); // neither index
            }

            System.out.printf("%n%n");
        } finally {
            accessLock.unlock();
        }
    }
}

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