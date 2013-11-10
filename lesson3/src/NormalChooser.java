import java.util.ArrayList;

/**
 * User: twer
 * Date: 10/30/13
 * Time: 8:47 AM
 */
public class NormalChooser implements ParkingChooser {
    @Override
    public ParkingLot choose(ArrayList<ParkingLot> parkingLots) {
        for (ParkingLot parkingLot : parkingLots){
            if (parkingLot.isAvailable())return parkingLot;
        }
        return null;
    }
}
