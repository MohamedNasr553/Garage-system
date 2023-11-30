import java.time.LocalTime;

public class FirstServed implements ParkIn {
    public boolean ParkInConfig(int slotsNumber, Slot arr[], Vehicle obj, LocalTime arrival[]) {
        boolean flag = false;
        for (int i = 1; i <= slotsNumber; i++) {
            if ((arr[i].IsEmpty()) && (obj.GetVehicleWidth() <= arr[i].GetSlotWidth()) && (obj.GetVehicleDepth() <= arr[i].GetSlotDepth())) {
                flag = true;
                arr[i].SlotActivity(true);
                System.out.println("Your Slot ID is: " + i);
                System.out.print("Arrival Time: ");
                System.out.println(java.time.LocalTime.now());
                arrival[i] = java.time.LocalTime.now();
                break;
            }
        }
        if (!flag) {
            throw new ArithmeticException("No Available Slot");
        }
        return true;
    }
}