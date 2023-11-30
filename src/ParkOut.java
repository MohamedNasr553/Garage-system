import java.time.LocalTime;

public class ParkOut {
    public LocalTime ParkOut() {
        System.out.print("Departure Time: ");
        LocalTime time = LocalTime.now();
        System.out.println(time);
        return time;

    }
}