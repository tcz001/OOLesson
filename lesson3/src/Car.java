/**
 * User: twer
 * Date: 10/21/13
 * Time: 5:55 PM
 */
public class Car {
    private String owner;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (owner != null ? !owner.equals(car.owner) : car.owner != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return owner != null ? owner.hashCode() : 0;
    }

    public Car(String Owner) {
        owner = Owner;
    }
}
