import java.util.ArrayList;
import java.util.List;

public class CompositeParker implements ParkAble {
    List<ParkAble> parkAbles = new ArrayList<ParkAble>();
    ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
    ParkingChooser parkingChooser = new SmartChooser();

    @Override
    public ParkAble choose() {
        for (ParkAble parkAble : parkAbles) {
            if (parkAble.choose() != null) {
                return parkAble.choose();
            } else if (parkAble.isAvailable()) return parkAble;
        }
        return null;
    }

    @Override
    public boolean park(Car car) {
        ParkAble parkAble = choose();
        if (parkAble != null) {
            return parkAble.park(car);
        } else {
            return parkingChooser.choose(parkingLots).park(car);
        }
    }

    @Override
    public Car unPark(Car car) {
        Car returnCar = null;
        for (ParkingLot currentParkingLots : parkingLots) {
            returnCar = currentParkingLots.unPark(car);
            if (returnCar != null) break;
        }
        for (ParkAble parker : parkAbles) {
            returnCar = parker.unPark(car);
            if (returnCar != null) break;
        }
        return returnCar;
    }

    @Override
    public boolean isAvailable() {
        for (ParkingLot currentParkingLots : parkingLots) {
            if (currentParkingLots.isAvailable()) {
                return true;
            }
        }
        return false;
    }
}
