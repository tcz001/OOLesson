import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TaxiTest {
    Taxi taxi;
    @Before
    public void setUp() throws Exception {
       taxi = new Taxi();
    }

    @Test
    public void shouldCharge6WhenLessThan2Miles(){
       assertThat(taxi.charge(2),is(6.0));
    }

    @Test
    public void shouldCharge6WhenGreaterThan2MilesAndLessThan8(){
       assertThat(taxi.charge(4),is(7.6));
       assertThat(taxi.charge(5),is(8.4));
    }

    @Test
    public void shouldChargeExtraFeeWhenGreaterThan8() throws Exception {
        assertThat(taxi.charge(9),is(12.0));
    }

    @Test
    public void shouldChargeExtraTime() throws Exception {
        assertThat(taxi.charge(9,1),is(12.25));
        assertThat(taxi.charge(9,2),is(12.5));
    }

    @Test
    public void shouldGetRoundCharge() throws Exception {
        assertThat(taxi.chargeRound(9,1),is(12L));
        assertThat(taxi.chargeRound(9,2),is(13L));
    }

}
