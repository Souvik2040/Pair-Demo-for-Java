package pairsuperclassdemo;

import java.util.Scanner;
import java.text.DecimalFormat;
import javafx.util.Pair;

public class PairSuperclassDemo {
    
    public static Scanner sc = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("#.##");
    
    private static Boats boat1 = new Boats("Go-Fast", "Mercury", 90, 15, 
            20, "Carbon fiber");
    private static Boats boat2 = new Boats("Speedtail", "Hull Racing", 83, 16,
            20, "Fiberglass");
    private static Boats boat3 = new Boats("Swashbuckler", "AMG", 75, 14,
            20, "Kevlar");
    
    private static Cars car1 = new Cars("M5", "BMW", 189, 17, 
            0.25, 250, 600);
    private static Cars car2 = new Cars("Aventador", "Lamborghini", 201, 18, 
            0.25, 180, 750);
    private static Cars car3 = new Cars("Demon", "Dodge", 198, 19, 
            0.25, 230, 850);

    /* /////////////////// MAIN ////////////////////// */ 

    public static void main(String[] args) {
        
        int num;
        
        displayInfo();
        
        displayMenuCar(1);
        num = sc.nextInt();
        Cars carRc1 = chooseCar(num);
        displayMenuBoat(1);
        num = sc.nextInt();
        Boats boatRc1 = chooseBoat(num);
        Pair<Cars, Boats> racer1 = new Pair<>(carRc1, boatRc1);
        
        displayMenuCar(2);
        num = sc.nextInt();
        Cars carRc2 = chooseCar(num);
        displayMenuBoat(1);
        num = sc.nextInt();
        Boats boatRc2 = chooseBoat(num);
        Pair<Cars, Boats> racer2 = new Pair<>(carRc2, boatRc2);
        
        compare(racer1, racer2);
        
    }

    /* /////////////////// METHODS /////////////////// */
    
    public static void displayInfo() {
        System.out.println("You will now simulate a two-legged race between "
                + "two racers." + "\nThe first leg of the race will be a "
                + "quarter mile drag race between cars of the racers' choice."
                + "\nThe second leg of the race will be a 20 mile long water "
                + "drag race between boats of the racers' choice." + "\nFor the"
                + " second leg, top speed is limited to 20mph for safety.");
    }
    
    public static void displayMenuCar(int num) {
        System.out.println("\nChoose a car for Racer " + num + ".");
        System.out.println("1. BMW M5." 
                + "\n2. Lamborghini Aventador."
                + "\n3. Dodge Demon.");
        System.out.println("Press the number corresponding to the chosen car.");
    }
    
    public static Cars chooseCar(int num) {
        if (num == 1) return car1;
        else if (num == 2) return car2;
        else if (num == 3) return car3;
        else {
            System.out.println("You made an invalid choice.");
            System.out.println("The M5 is chosen by default.");
            return car1;
        }
    }
    
    public static Boats chooseBoat(int num) {
        if (num == 1) return boat1;
        else if (num == 2) return boat2;
        else if (num == 3) return boat3;
        else {
            System.out.println("You made an invalid choice.");
            System.out.println("The Go-Fast is chosen by default.");
            return boat1;
        }
    }
    
    public static void displayMenuBoat(int num) {
        System.out.println("\nChoose a boat for Racer " + num + ".");
        System.out.println("1. Go-Fast by Mercury." 
                + "\n2. Speedtail by Hull Racing."
                + "\n3. Swashbuckler by AMG.");
        System.out.println("Press the number corresponding to the chosen boat.");
    }
    
    public static void displayCar(Cars car, int num) {
        System.out.println("\nRacer " + num + " chose the '" + car.getName() 
                + "' built by " + car.getMaker() + "." + "\nIt has a "
                + "top speed of " + car.getTopSpeed() + " mph and is rated at " 
                + car.getHP() + " horsepowers."
                + "\nIt has a range of " + car.getRange() + " miles.");
        System.out.println("Racer " + num + "'s car finished the race in "
                + df.format(car.getTime()) + " seconds." + "\nIt finished"
                + " with a speed of " + df.format(car.getSpeed())
                + " mph.");
    }
    
    public static void displayBoat(Boats boat, int num) {
        System.out.println("\nRacer " + num + " chose the '" + boat.getName() 
                + "' built by " + boat.getMaker() + "." + "\nIt has a "
                + "top speed of " + boat.getTopSpeed() 
                + " mph and is made of " + boat.getMaterial() + ".");
        System.out.println("Racer " + num + "'s boat finished the race in "
                + df.format(boat.getTime()) + " seconds." + "\nIt finished"
                + " with a speed of " + df.format(boat.getSpeed())
                + " mph.");
    }
    
    public static void compare(Pair<Cars, Boats> rc1, Pair<Cars, Boats> rc2) {
        double tcar1, tcar2, tboat1, tboat2;
        tcar1 = rc1.getKey().getTime();
        tcar2 = rc2.getKey().getTime();
        tboat1 = rc1.getValue().getTime();
        tboat2 = rc2.getValue().getTime();
        displayCar(rc1.getKey(), 1);
        displayCar(rc2.getKey(), 2);
        displayBoat(rc1.getValue(), 1);
        displayBoat(rc2.getValue(), 2);
        
        double trc1 = tcar1 + tboat1;
        double trc2 = tcar2 + tboat2;
        
        System.out.println("\nRacer 1 took a total of " 
                + df.format(trc1) + " seconds.");
        System.out.println("Racer 2 took a total of " 
                + df.format(trc2) + " seconds.");
        
        if (trc1 < trc2) System.out.println("\nRacer 1 is the winner!");
        else if (trc1 > trc2) System.out.println("\nRacer 2 is the winner!");
        else System.out.println("\nThe race was a tie!");
    }
}