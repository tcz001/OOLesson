import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
        assertThat(parker.park(car), is(true));
    }

    @Test
    public void shouldPickUpCar() throws Exception {
        Parker parker = new Parker();
        Car car = new Car("myCar");
        parker.parkingLots.add(new ParkingLot(2));
        parker.park(car);
        assertThat(parker.unPark(car), is(car));
    }
}
