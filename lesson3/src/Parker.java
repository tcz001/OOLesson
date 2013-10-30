import java.util.ArrayList;

/**
 * User: twer
 * Date: 10/21/13
 * Time: 6:13 PM
 */
public class Parker {
    ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
    ParkingChooser parkingChooser = new SmartChooser();

    public Parker() {
        parkingLots = new ArrayList<ParkingLot>();
        parkingChooser = new SmartChooser();
    }

    public Parker(ArrayList<ParkingLot> parkingLots, ParkingChooser parkingChooser) {
        this.parkingLots = parkingLots;
        this.parkingChooser = parkingChooser;
    }

    public void park(Car car) {
        parkingChooser.choose(parkingLots).checkIn(car);
    }
}