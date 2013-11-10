import java.util.HashSet;

/**
 * User: twer
 * Date: 10/21/13
 * Time: 5:31 PM
 */
public class ParkingLot implements ParkAble{
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

    @Override
    public boolean park(Car car) {
        if (!isAvailable()) return false;
        else {
            cars.add(car);
            return true;
        }
    }

    @Override
    public Car unPark(Car car) {
        if (cars.remove(car))
            return car;
        else return null;
    }

    @Override
    public boolean isAvailable() {
        return getAvailable()!=0;
    }

    @Override
    public ParkAble assignTo() {
        return this;
    }

    @Override
    public String report() {
        return "ParkingLot\n";
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
