public class Slot {
    private final int SlotID;
    private final double SlotWidth;
    private final double SlotDepth;
    private boolean active;

    public Slot() {
        SlotID = 0;
        SlotWidth = 0;
        SlotDepth = 0;
        active = false;
    }

    public Slot(int s_ID, double w, double d, boolean a) {
        SlotID = s_ID;
        SlotWidth = w;
        SlotDepth = d;
        active = a;
    }

    void SlotActivity(boolean a) {
        active = a;
    }

    public double GetSlotWidth() {
        return SlotWidth;
    }

    public double GetSlotDepth() {
        return SlotDepth;
    }

    public boolean GetActivity() {
        return active;
    }

    public boolean IsEmpty() {
        return !active;
    }
}