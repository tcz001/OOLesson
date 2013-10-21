import java.util.HashSet;

/**
 * User: twer
 * Date: 10/21/13
 * Time: 5:31 PM
 */
public class ParkingLot {
    private int maximum;
    HashSet<Car> cars;

    public ParkingLot(int i) throws Exception {
        if (i > 0) {
            maximum = i;
            cars= new HashSet<Car>();
        } else {
            throw new LowerBoundException("Maximum number should not be negative. " + i + " is negative");
        }
    }

    public boolean park(Car car) {
        if (cars.size() == maximum) return false;
        else {
            cars.add(car);
            return true;
        }
    }

    class LowerBoundException extends Exception {
        LowerBoundException(String message) {
            super(message);
        }
    }
}
