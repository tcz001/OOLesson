/**
 * User: twer
 * Date: 11/6/13
 * Time: 9:01 AM
 */
public interface ParkAble {
    boolean park(Car car);

    Car unPark(Car car);

    boolean isAvailable();

    ParkAble assignTo();

    String report(int number);
}
