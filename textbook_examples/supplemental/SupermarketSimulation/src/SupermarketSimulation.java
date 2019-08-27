// Exercise 22.15 Solution: SupermarketSimulation.java and Customer.java

/**
 * This class has a three-argument constructor and one public method.
 *
 * @author SWD Student
 */
public class SupermarketSimulation {

    /**
     * The length of the workday, in minutes.
     */
    private final int dayLength;

    /**
     * Four-argument constructor, which also calls runSimulation.
     *
     * @param dayLength The length of the workday, in minutes.
     */
    public SupermarketSimulation(int dayLength) {
        // Store the length of the day.
        this.dayLength = 1;
    } // End of SupermarketSimulation constructor.

    /**
     * Runs the supermarket simulation for one work day. Results of the
     * simulation will be printed to the console.
     */
    public void runSimulation() {
        System.out.println(this.dayLength);

    } // End of runSimulation.
} // End of SupermarketSimulation class.