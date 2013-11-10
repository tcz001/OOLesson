import java.util.ArrayList;
import java.util.List;

public class CompositeParker implements ParkAble {
    List<ParkAble> parkAbles = new ArrayList<ParkAble>();
    ParkingChooser parkingChooser = new SmartChooser();

    @Override
    public ParkAble assignTo() {
        for (ParkAble parkAble : parkAbles) {
            if (parkAble.assignTo() != parkAble) {
                return parkAble.assignTo();
            } else if (parkAble.isAvailable()) return parkAble;
        }
        return null;
    }

    @Override
    public boolean park(Car car) {
        ParkAble parkAble = assignTo();
        if (parkAble != null) {
            return parkAble.park(car);
        } else {
            return parkingChooser.choose(parkAbles).park(car);
        }
    }

    @Override
    public Car unPark(Car car) {
        Car returnCar = null;
        for (ParkAble parker : parkAbles) {
            returnCar = parker.unPark(car);
            if (returnCar != null) break;
        }
        return returnCar;
    }

    @Override
    public boolean isAvailable() {
        for (ParkAble parkAble : parkAbles) {
            if (parkAble.isAvailable()) {
                return true;
            }
        }
        return false;
    }
}
