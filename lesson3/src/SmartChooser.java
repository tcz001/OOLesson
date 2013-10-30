import java.util.ArrayList;
import java.util.Iterator;

/**
 * User: twer
 * Date: 10/30/13
 * Time: 9:15 AM
 */
public class SmartChooser implements ParkingChooser {
    @Override
    public ParkingLot choose(ArrayList<ParkingLot> parkingLots) {
        Iterator<ParkingLot> parkingLotIterator = parkingLots.iterator();
        ParkingLot choice = parkingLotIterator.next();
        while (parkingLotIterator.hasNext()){
            ParkingLot lot = parkingLotIterator.next();
            if (!lot.isFull() && lot.getAvailable() > choice.getAvailable())
                choice = lot;
        }
        return choice;
    }
}
