import java.util.Iterator;
import java.util.List;

/**
 * User: twer
 * Date: 10/30/13
 * Time: 9:40 AM
 */
public class MasterChooser implements ParkingChooser {
    @Override
    public ParkAble choose(List<ParkAble> parkingLots) {
        Iterator<ParkAble> parkingLotIterator = parkingLots.iterator();
        ParkingLot choice = (ParkingLot) parkingLotIterator.next();
        while (parkingLotIterator.hasNext()){
            ParkingLot lot = (ParkingLot) parkingLotIterator.next();
            if (lot.getAvailable()!=0 && lot.getUsage() < choice.getUsage())
                choice = lot;
        }
        return choice;
    }
}
