import java.util.List;

/**
 * User: twer
 * Date: 10/30/13
 * Time: 8:44 AM
 */
public interface ParkingChooser {
    ParkAble choose(List<ParkAble> parkingLots);
}
