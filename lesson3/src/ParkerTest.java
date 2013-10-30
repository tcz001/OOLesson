import org.junit.Test;

/**
 * User: twer
 * Date: 10/22/13
 * Time: 5:21 PM
 */
public class ParkerTest {
    @Test
    public void shouldParkInLeastUsedParkingLot() throws Exception {
        Parker parker = new Parker();
        Car car = new Car("myCar");
        parker.parkingLots.add(new ParkingLot(2));
        parker.park(car);
    }
}
