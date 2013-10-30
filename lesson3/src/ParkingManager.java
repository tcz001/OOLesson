import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends Parker{
    public List<Parker> parkers = new ArrayList<Parker>();

    public Parker choose() {
        if (parkers.size()==0)return null;
        return parkers.get(0);
    }

    @Override
    public boolean park(Car car) {
        Parker parker = choose();
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
