public class Display {
    void DisplayAvailableSlots(int slotsNumber, Slot[] arr) {
        for (int i = 1; i <= slotsNumber; i++) {
            if (!arr[i].GetActivity()) {
                System.out.println("The Available Slot ID is: " + i);
            }
        }
    }
}
