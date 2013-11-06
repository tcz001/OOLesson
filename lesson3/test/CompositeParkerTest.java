import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CompositeParkerTest {

    private CompositeParker parkingManager;
    private Car car;
    private Parker parker;
    private CompositeParker bigBoss;

    @Before
    public void setUp() throws Exception {
        parkingManager = new CompositeParker();
        bigBoss = new CompositeParker();
        car = new Car("myCar");
        parker = new Parker();
        parker.parkingLots.add(new ParkingLot(1));
        parker.parkingLots.add(new ParkingLot(2));
        parkingManager.parkers.add(parker);
    }

    @Test
    public void should_be_able_to_parking_car() throws Exception {
        parkingManager.parkingLots.add(new ParkingLot(2));
        parkingManager.parkingLots.add(new ParkingLot(2));
        assertThat(parkingManager.parkingChooser.choose(parkingManager.parkingLots).park(car), is(true));
    }

    @Test
    public void should_be_able_to_pickUp_car() throws Exception {
        parkingManager.parkingLots.add(new ParkingLot(2));
        parkingManager.parkingLots.add(new ParkingLot(2));
        assertThat(parkingManager.park(car), is(true));
        assertThat(parkingManager.unPark(car), is(car));
    }

    @Test
    public void should_give_car_to_parking_boy() throws Exception {
        Parker parker2  = new Parker();
        parker.parkingLots.add(new ParkingLot(1));
        parker.parkingLots.add(new ParkingLot(2));
        parkingManager.parkers.add(parker);
        parkingManager.parkers.add(parker2);
        parkingManager.park(car);

        assertThat(parker.unPark(car), is(car));
    }

    @Test
    public void should_pickUp_car() throws Exception {
        parkingManager.parkers.add(parker);

        assertThat(parkingManager.park(car), is(true));
        assertThat(parkingManager.unPark(car), is(car));
        assertThat(parkingManager.unPark(car), is((Car)null));
    }

    @Test
    public void super_should_pickUp_car() throws Exception {
        parkingManager.parkers.add(parker);
        bigBoss.parkers.add(parkingManager);

        assertThat(bigBoss.park(car), is(true));
        assertThat(bigBoss.unPark(car), is(car));

        assertThat(bigBoss.park(car), is(true));
        assertThat(parkingManager.unPark(car), is(car));

        assertThat(bigBoss.park(car), is(true));
        assertThat(parker.unPark(car), is(car));
    }
}