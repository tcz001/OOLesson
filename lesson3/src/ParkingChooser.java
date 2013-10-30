import java.util.ArrayList;

/**
 * User: twer
 * Date: 10/30/13
 * Time: 8:44 AM
 */
public interface ParkingChooser {
    ParkingLot choose(ArrayList<ParkingLot> parkingLots);
}
