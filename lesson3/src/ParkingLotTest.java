import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: twer
 * Date: 10/21/13
 * Time: 5:31 PM
 */
public class ParkingLotTest {
    @Test
    public void testParking() throws Exception {
        ParkingLot parkingLot = new ParkingLot(5);
        assertThat(parkingLot.park(new Car("Fan")), is(true));
    }

    @Test
    public void testLowerBound() throws Exception {
        try {
            new ParkingLot(-5);
        } catch (Exception e) {
            assertThat(e.getMessage(),is("Maximum number should not be negative. -5 is negative"));
        }
    }

    @Test
    public void testUpperBound() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car("Frank"));

        assertThat(parkingLot.park(new Car("Fan")),is(false));
    }

    @Test @Ignore
    public void testGuardAutoAssignment() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        Guard guard = new Guard();
        parkingLot.park(new Car("Frank"));

        assertThat(parkingLot.park(new Car("Fan")), is(false));
    }

}
