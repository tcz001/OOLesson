import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends Parker{
    public List<Parker> parkers = new ArrayList<Parker>();

    public Parker chooseParker() {
        if (parkers.size()==0)return null;
        for (Parker parker : parkers){
            if (parker.getClass() == ParkingManager.class){
                return ((ParkingManager) parker).chooseParker();
            }
            if(parker.isAvailable())return parker;
        }
        return null;
    }

    @Override
    public boolean park(Car car) {
        Parker parker = chooseParker();
        if(parker == null) {
           return super.park(car);
        }
        else {
           return parker.park(car);
        }
    }

    @Override
    public Car pickUp(Car car) {
        Car returnCar;
        for (Parker parker : parkers){
            returnCar = parker.pickUp(car);
            if(returnCar == car)
                return returnCar;
        }
        return super.pickUp(car);
    }
}
