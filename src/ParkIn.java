import java.time.LocalTime;

public interface ParkIn {
    public boolean ParkInConfig(int slotsNumber, Slot arr[], Vehicle obj, LocalTime arrival[]);
}