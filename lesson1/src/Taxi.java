public class Taxi {
    public double charge(double distance) {
        if (distance <= 2.0) {
            return 6.0;
        } else if (distance <= 8) {
            return this.charge(2.0) + (distance - 2.0) * 0.8;
        } else {
            return this.charge(8) + (distance - 8) * 1.2;
        }
    }

    public double charge(double distance, double time) {
        return charge(distance) + time * 0.25;
    }

    public long chargeRound(double distance, double time) {
        return Math.round(charge(distance, time));
    }
}
