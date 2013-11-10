import java.util.List;

/**
 * User: twer
 * Date: 11/6/13
 * Time: 9:01 AM
 */
public interface ParkAble {
    boolean park(Car car);

    Car unPark(Car car);

    boolean isAvailable();

    String report();

    List<String> print(int blank);
}
