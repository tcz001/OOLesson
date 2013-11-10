import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: twer
 * Date: 10/30/13
 * Time: 8:45 AM
 */
public class ParkingChooserTest {
    ParkingChooser parkingChooser;
    List<ParkAble> parkingLots = new ArrayList<ParkAble>();
    @Test
    public void testNormalChooseer() throws Exception {
        parkingChooser = new NormalChooser();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        assertThat((ParkingLot) parkingChooser.choose(parkingLots), is(parkingLot1));
    }
    @Test
    public void testSmartChooseer() throws Exception {
        parkingChooser = new SmartChooser();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        assertThat((ParkingLot) parkingChooser.choose(parkingLots), is(parkingLot2));
    }
    @Test
    public void testMasterChooseer() throws Exception {
        parkingChooser = new MasterChooser();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingLot parkingLot3 = new ParkingLot(1);
        parkingLot1.park(new Car("testCar"));
        parkingLot2.park(new Car("testCar"));
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        assertThat((ParkingLot) parkingChooser.choose(parkingLots), is(parkingLot3));
    }
}
