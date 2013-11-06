import java.util.ArrayList;
import java.util.List;

public class CompositeParker implements ParkAble {
    public List<ParkAble> parkers = new ArrayList<ParkAble>();
    ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
    ParkingChooser parkingChooser = new SmartChooser();

    public ParkAble chooseParker() {
        if (parkers.size()==0)return null;
        for (ParkAble parker : parkers){
            if (parker.getClass() == CompositeParker.class){
                return ((CompositeParker) parker).chooseParker();
            }
            if(parker.isAvailable())return parker;
        }
        return null;
    }

    @Override
    public boolean park(Car car) {
        ParkAble parker = chooseParker();
        if(parker == null) {
            return parkingChooser.choose(parkingLots).park(car);
        }
        else {
           return parker.park(car);
        }
    }

    @Override
    public Car unPark(Car car) {
        Car returnCar;
        for (ParkAble parker : parkers){
            returnCar = parker.unPark(car);
            if(returnCar == car)
                return returnCar;
        }
        for (ParkingLot currentParkingLots : parkingLots) {
            if (currentParkingLots.cars.contains(car)) {
                currentParkingLots.cars.remove(car);
                return car;
            }
        }
        return null;
    }

    @Override
    public boolean isAvailable() {
        for (ParkingLot currentParkingLots : parkingLots) {
            if (!currentParkingLots.isFull()) {
                return true;
            }
        }
        return false;
    }
}
