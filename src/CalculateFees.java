import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class CalculateFees {
    public long FeesCalc(LocalTime time1, LocalTime time2) {
        // Calculating the difference in Hours
        // long seconds = ChronoUnit.SECONDS.between(time1, time2) % 60;
        long hours = ChronoUnit.HOURS.between(time1, time2);
        hours += 1;
        long fees = 5 * hours;
        System.out.println("The total fees of the selected car equal : " + fees + " EGP ");
        return fees;
    }
}