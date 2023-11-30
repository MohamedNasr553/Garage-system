import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("Choose From The Menu the option you want.");
        System.out.println("(1) Activate Park in Method.");
        System.out.println("(2) Display Available Parking Slot.");
        System.out.println("(3) Activate Park out Method.");
        System.out.println("(4) Calculate Total Vehicles Used The Garage In That Point");
        System.out.println("(5) Calculate Total Income In That Point ");
        System.out.println("(6) Exit.");
    }
    public static void main(String[] args) {
        int vehicles_cnt = 0;
        int income_cnt = 0;
        boolean activity = false;
        Scanner num = new Scanner(System.in);
        System.out.print(" Enter number of slots of the garage: ");
        int NumberOfSlots = num.nextInt();
        LocalTime timeList[] = new LocalTime[NumberOfSlots + 1];
        Slot slots[] = new Slot[NumberOfSlots + 1];
        for (int i = 1; i <= NumberOfSlots; i++) {
            Scanner wid = new Scanner(System.in);
            System.out.print("Enter the width of the slot of number " + i + " : ");
            double width = wid.nextDouble();

            Scanner dep = new Scanner(System.in);
            System.out.print("Enter the depth of the slot of number " + i + " : ");
            double Depth = dep.nextDouble();

            Slot obj = new Slot(i, width, Depth, activity);
            slots[i] = obj;
        }
        ParkIn first = new FirstServed();
        ParkIn best = new FirstServed();
        Display display = new Display();
        ParkOut out_ = new ParkOut();
        CalculateFees fees_ = new CalculateFees();
        TotalVehicles t_v = new TotalVehicles();
        TotalIncome t_i = new TotalIncome();

        menu();
        Scanner scanner = new Scanner(System.in);
        int choice2 = scanner.nextInt();
        while (choice2 != 6) {
            if (choice2 == 1) {
                Scanner MN = new Scanner(System.in);
                System.out.print("Enter the Model Name of the vehicle: ");
                String ModelName = MN.nextLine();

                Scanner MY = new Scanner(System.in);
                System.out.print("Enter the Model Year of the vehicle: ");
                int ModelYear = MY.nextInt();

                Scanner IDNum = new Scanner(System.in);
                System.out.print("Enter the identification number of the vehicle: ");
                int IdentificationNumber = IDNum.nextInt();

                Scanner Vwid = new Scanner(System.in);
                System.out.print("Enter the width of the vehicle: ");
                double VehicleWidth = Vwid.nextDouble();

                Scanner Vdep = new Scanner(System.in);
                System.out.print("Enter the depth of the vehicle: ");
                double VehicleDepth = Vdep.nextDouble();

                Vehicle v1 = new Vehicle(ModelName, ModelYear, IdentificationNumber, VehicleWidth, VehicleDepth);
                System.out.println("Choose The number of the Method of Parking.");
                System.out.println("(1) First come first served slots");
                System.out.println("(2) Best-fit approach the vehicle");
                Scanner conf = new Scanner(System.in);
                int config_choice = conf.nextInt();
                if (config_choice == 1) {
                    boolean v_check = first.ParkInConfig(NumberOfSlots, slots, v1, timeList);
                    if (v_check) {
                        vehicles_cnt++;
                    }
                } else {
                    boolean v2_check = best.ParkInConfig(NumberOfSlots, slots, v1, timeList);
                    if (v2_check) {
                        vehicles_cnt++;
                    }
                }
            } else if (choice2 == 2) {
                display.DisplayAvailableSlots(NumberOfSlots, slots);
            } else if (choice2 == 3) {
                System.out.println("please enter the ID of the slot you want to get car out of it");
                Scanner cc = new Scanner(System.in);
                int ID_out = cc.nextInt();
                if (slots[ID_out].IsEmpty()) {
                    throw new ArithmeticException("The Slot Is Already Empty (NO CAR PARKED HERE!)");
                } else {
                    LocalTime T1 = out_.ParkOut();
                    slots[ID_out].SlotActivity(false);
                    income_cnt += fees_.FeesCalc(timeList[ID_out], T1);
                }
            } else if (choice2 == 4) {
                t_v.VehiclesCalc(vehicles_cnt);

            } else if (choice2 == 5) {
                t_i.IncomeCalc(income_cnt);
            }
            menu();
            choice2 = scanner.nextInt();
        }
        System.out.println("You Quited the Program.");
    }
}