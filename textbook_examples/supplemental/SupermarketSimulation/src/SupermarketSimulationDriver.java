// Exercise 22.15 Solution: SupermarketSimulation.java and Customer.java

/**
 * Main driver class that tests SupermarketSimulation.java and Customer.java
 *
 * @author SWD Student
 */
public class SupermarketSimulationDriver {

    /**
     * This method will automatically be called when SupermarketSimulationDriver
     * is run.
     *
     * @param args Command line arguments.
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {

        // Create a new SupermarketSimulation that has a dayLength 720 minutes,
        // max of 4 minute service times and max of 4 minutes between customers.
        SupermarketSimulation myMarket1 = new SupermarketSimulation(360);
    }
}
