public class Vehicle {
    protected String ModelName;
    protected int ModelYear;
    protected int IdentificationNumber;
    protected double Width;
    protected double Depth;

    public Vehicle() {
        ModelName = "";
        ModelYear = 0;
        IdentificationNumber = 0;
        Width = 0;
        Depth = 0;
    }

    public Vehicle(String MN, int MY, int ID, double W, double D) {
        ModelName = MN;
        ModelYear = MY;
        IdentificationNumber = ID;
        Width = W;
        Depth = D;
    }

    public String GetModelName() {
        return ModelName;
    }

    public int GetModelYear() {
        return ModelYear;
    }

    public int GetIdentificationNumber() {
        return IdentificationNumber;
    }

    public double GetVehicleWidth() {
        return Width;
    }

    public double GetVehicleDepth() {
        return Depth;
    }
}