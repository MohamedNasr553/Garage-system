import java.time.LocalTime;

public class BestFit implements ParkIn {
    public boolean ParkInConfig(int slotsNumber, Slot[] arr, Vehicle obj, LocalTime[] arrival) {
        boolean check = false;
        boolean flag2 = false;
        int ID_check = 1;
        double mini1 = 0;
        double mini2 = 0;
        for (int i = 1; i <= slotsNumber; i++) {
            mini1 = arr[i].GetSlotWidth() - obj.GetVehicleWidth();
            mini2 = arr[i].GetSlotDepth() - obj.GetVehicleDepth();
            if (mini1 >= 0 && mini2 >= 0) {
                flag2 = true;
                break;
            }
        }
        if (!flag2) {
            throw new ArithmeticException("No Available Slot");
        } else {
            for (int i = 1; i <= slotsNumber; i++) {
                if ((obj.GetVehicleWidth() <= arr[i].GetSlotWidth()) && (obj.GetVehicleDepth() <= arr[i].GetSlotDepth())) {
                    if ((mini1 >= arr[i].GetSlotWidth() - obj.GetVehicleWidth()) && (mini2 >= arr[i].GetSlotDepth() - obj.GetVehicleDepth())) {
                        check = true;
                        ID_check = i;
                    }
                }
            }
            if (check) {
                arr[ID_check].SlotActivity(true);
                System.out.println("your best fit slot id is " + ID_check);
                System.out.print("Arrival Time: ");
                System.out.println(java.time.LocalTime.now());
                arrival[ID_check] = java.time.LocalTime.now();
                return true;
            } else if ((arr[1].GetSlotWidth() >= obj.GetVehicleWidth()) && (arr[1].GetSlotDepth() >= obj.GetVehicleDepth())) {
                arr[ID_check].SlotActivity(true);
                System.out.println("your best fit slot id is " + "1");
                System.out.print("Arrival Time: ");
                System.out.println(java.time.LocalTime.now());
                arrival[ID_check] = java.time.LocalTime.now();
                return true;
            } else {
                throw new ArithmeticException("No Available Slot");
            }
        }
    }
}