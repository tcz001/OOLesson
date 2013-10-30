import java.util.ArrayList;
import java.util.Iterator;

/**
 * User: twer
 * Date: 10/30/13
 * Time: 9:40 AM
 */
public class MasterChooser implements ParkingChooser {
    @Override
    public ParkingLot choose(ArrayList<ParkingLot> parkingLots) {
        Iterator<ParkingLot> parkingLotIterator = parkingLots.iterator();
        ParkingLot choice = parkingLotIterator.next();
        while (parkingLotIterator.hasNext()){
            ParkingLot lot = parkingLotIterator.next();
            if (!lot.isFull() && lot.getUsage() < choice.getUsage())
                choice = lot;
        }
        return choice;
    }
}
