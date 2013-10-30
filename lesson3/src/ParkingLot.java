import java.util.HashSet;

/**
 * User: twer
 * Date: 10/21/13
 * Time: 5:31 PM
 */
public class ParkingLot {
    int maximum;
    HashSet<Car> cars;

    public ParkingLot(int i) throws Exception {
        if (i > 0) {
            maximum = i;
            cars= new HashSet<Car>();
        } else {
            throw new LowerBoundException("Maximum number should not be negative. " + i + " is negative");
        }
    }

    public boolean checkIn(Car car) {
        if (isFull()) return false;
        else {
            cars.add(car);
            return true;
        }
    }

    public Boolean checkOut(Car car) {
        return cars.remove(car);
    }

    boolean isFull() {
        return getAvailable()==0;
    }

    int getAvailable(){
        return maximum-cars.size();
    }

    double getUsage(){
        return (double) cars.size()/ (double) maximum;
    }

    class LowerBoundException extends Exception {
        LowerBoundException(String message) {
            super(message);
        }
    }
}
