import java.util.List;

/**
 * User: twer
 * Date: 10/30/13
 * Time: 8:47 AM
 */
public class NormalChooser implements ParkingChooser {
    @Override
    public ParkAble choose(List<ParkAble> parkingLots) {
        for (ParkAble parkingLot : parkingLots){
            if (parkingLot.isAvailable())return parkingLot;
        }
        return null;
    }
}
