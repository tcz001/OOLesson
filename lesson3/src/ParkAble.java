/**
 * User: twer
 * Date: 11/6/13
 * Time: 9:01 AM
 */
public interface ParkAble {
    boolean park(Car car);

    Car pickUp(Car car);

    boolean isAvailable();
}
