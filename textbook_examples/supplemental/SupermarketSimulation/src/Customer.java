// Exercise 22.15 Solution: SupermarketSimulation.java and Customer.java

/**
 * This class has a three-argument constructor and three public methods.
 *
 * @author SWD Student
 */
public class Customer {
    /**
     * The time this customer entered the line.
     */
    private int arrivalTime;

    /**
     * Three-argument constructor.
     *
     * @param arrivalTime The time this customer entered the line.
     */
    public Customer(int arrivalTime) {
        // Store the passed in values.
        this.arrivalTime = arrivalTime;
    }

    /**
     * Returns the time this customer entered the line.
     *
     * @return The time this customer entered the line.
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

} // End of Customer class.