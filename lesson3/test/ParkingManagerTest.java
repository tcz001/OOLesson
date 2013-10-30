import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParkingManagerTest {
    @Test
    public void should_be_able_to_parking_car() throws Exception {
        ParkingManager parkingManager = new ParkingManager();
        Car car = new Car("myCar");
        parkingManager.parkingLots.add(new ParkingLot(2));
        parkingManager.parkingLots.add(new ParkingLot(2));
        assertThat(parkingManager.park(car), is(true));
    }

    @Test
    public void should_be_able_to_pickUp_car() throws Exception {
        ParkingManager parkingManager = new ParkingManager();
        Car car = new Car("myCar");
        parkingManager.parkingLots.add(new ParkingLot(2));
        parkingManager.parkingLots.add(new ParkingLot(2));


    }

}
