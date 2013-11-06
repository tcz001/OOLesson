import java.util.ArrayList;

/**
 * User: twer
 * Date: 10/21/13
 * Time: 6:13 PM
 */
public class Parker extends CompositeParker implements ParkAble{

    public Parker() {
        parkingLots = new ArrayList<ParkingLot>();
        parkingChooser = new SmartChooser();
    }

    public Parker(ArrayList<ParkingLot> parkingLots, ParkingChooser parkingChooser) {
        this.parkingLots = parkingLots;
        this.parkingChooser = parkingChooser;
    }

}
