import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CompositeParkerTest {

    private CompositeParker parkingManager;
    private Car car;
    private CompositeParker parker;
    private CompositeParker bigBoss;

    @Before
    public void setUp() throws Exception {
        parkingManager = new CompositeParker();
        bigBoss = new CompositeParker();
        car = new Car("myCar");
        parker = new CompositeParker();
        parker.parkAbles.add(new ParkingLot(1));
        parker.parkAbles.add(new ParkingLot(2));
        parkingManager.parkAbles.add(parker);
    }

    @Test
    public void should_be_able_to_parking_car() throws Exception {
        parkingManager.parkAbles.add(new ParkingLot(2));
        parkingManager.parkAbles.add(new ParkingLot(2));
        assertThat(parkingManager.park(car), is(true));
    }

    @Test
    public void should_be_able_to_pickUp_car() throws Exception {
        parkingManager.parkAbles.add(new ParkingLot(2));
        parkingManager.parkAbles.add(new ParkingLot(2));
        assertThat(parkingManager.park(car), is(true));
        assertThat(parkingManager.unPark(car), is(car));
    }

    @Test
    public void should_give_car_to_parking_boy() throws Exception {
        ParkAble parker2  = new CompositeParker();
        parker.parkAbles.add(new ParkingLot(1));
        parker.parkAbles.add(new ParkingLot(2));
        parkingManager.parkAbles.add(parker);
        parkingManager.parkAbles.add(parker2);
        parkingManager.park(car);

        assertThat(parker.unPark(car), is(car));
    }

    @Test
    public void should_pickUp_car() throws Exception {
        parkingManager.parkAbles.add(parker);

        assertThat(parkingManager.park(car), is(true));
        assertThat(parkingManager.unPark(car), is(car));
        assertThat(parkingManager.unPark(car), is((Car)null));
    }

    @Test
    public void super_should_pickUp_car() throws Exception {
        parkingManager.parkAbles.add(parker);
        bigBoss.parkAbles.add(parkingManager);

        assertThat(bigBoss.park(car), is(true));
        assertThat(bigBoss.unPark(car), is(car));

        assertThat(bigBoss.park(car), is(true));
        assertThat(parkingManager.unPark(car), is(car));

        assertThat(bigBoss.park(car), is(true));
        assertThat(parker.unPark(car), is(car));
    }

    @Test
    public void shouldReport() throws Exception {
        String report =
                "Parker\n"+//0
                "  Parker\n"+//1
                "    Parker\n"+//2
                "      ParkingLot\n"+
                "  Parker\n"+//3
                "    ParkingLot\n"+
                "  ParkingLot\n";

        CompositeParker parker0 = new CompositeParker();
        CompositeParker parker1 = new CompositeParker();
        CompositeParker parker2 = new CompositeParker();
        CompositeParker parker3 = new CompositeParker();
        parker0.parkAbles.add(parker1);
        parker0.parkAbles.add(parker3);
        parker1.parkAbles.add(parker2);
        parker2.parkAbles.add(new ParkingLot(10));
        parker3.parkAbles.add(new ParkingLot(10));
        parker0.parkAbles.add(new ParkingLot(10));
        System.out.println(parker0.report());
        assertThat(parker0.report(), is(report));
    }
}
