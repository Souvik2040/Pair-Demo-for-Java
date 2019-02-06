package pairsuperclassdemo;

import java.util.Scanner;
import java.text.DecimalFormat;
import javafx.util.Pair;
import javax.swing.JOptionPane;

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
        
        String message, input;
        int num, turn = 1;
        
        message = displayInfo();
        JOptionPane.showMessageDialog(null, message);
        
        message = displayMenuCar(turn);
        input = JOptionPane.showInputDialog(message);
        num = Integer.parseInt(input);
        Cars carRc1 = chooseCar(num);
        message = displayMenuBoat(turn);
        input = JOptionPane.showInputDialog(message);
        num = Integer.parseInt(input);
        Boats boatRc1 = chooseBoat(num);
        Pair<Cars, Boats> racer1 = new Pair<>(carRc1, boatRc1);
        
        turn++;
        
        message = displayMenuCar(turn);
        input = JOptionPane.showInputDialog(message);
        num = Integer.parseInt(input);
        Cars carRc2 = chooseCar(num);
        message = displayMenuBoat(turn);
        input = JOptionPane.showInputDialog(message);
        num = Integer.parseInt(input);
        Boats boatRc2 = chooseBoat(num);
        Pair<Cars, Boats> racer2 = new Pair<>(carRc2, boatRc2);
        
        compare(racer1, racer2);
        
    }

    /* /////////////////// METHODS /////////////////// */
    
    public static String displayInfo() {
        String message = ("You will now simulate a two-legged race between "
                + "two racers." + "\nThe first leg of the race will be a "
                + "quarter mile drag race between cars of the racers' choice."
                + "\nThe second leg of the race will be a 20 mile long water "
                + "drag race between boats of the racers' choice." + "\nFor the"
                + " second leg, top speed is limited to 20mph for safety.");
        return message;
    }
    
    public static String displayMenuCar(int num) {
        String message;
        message = ("Choose a car for Racer " + num + "."
                + "\n1. BMW M5." 
                + "\n2. Lamborghini Aventador."
                + "\n3. Dodge Demon."
                + "\nPress the number corresponding to the chosen car.");
        return message;
    }
    
    public static String displayMenuBoat(int num) {
        String message;
        message = ("Choose a boat for Racer " + num + "."
                + "\n1. Go-Fast by Mercury." 
                + "\n2. Speedtail by Hull Racing."
                + "\n3. Swashbuckler by AMG."
                + "\nPress the number corresponding to the chosen boat.");
        return message;
    }
    
    public static Cars chooseCar(int num) {
        if (num == 1) return car1;
        else if (num == 2) return car2;
        else if (num == 3) return car3;
        else {
            String message;
            message = ("You made an invalid choice."
                    + "\nThe M5 is chosen by default.");
            JOptionPane.showMessageDialog(null, message);
            return car1;
        }
    }
    
    public static Boats chooseBoat(int num) {
        if (num == 1) return boat1;
        else if (num == 2) return boat2;
        else if (num == 3) return boat3;
        else {
            String message;
            message = ("You made an invalid choice."
                    + "\nThe Go-Fast is chosen by default.");
            JOptionPane.showMessageDialog(null, message);
            return boat1;
        }
    }
    
    public static String displayCar(Cars car, int num) {
        String message;
        message = ("Racer " + num + " chose the '" + car.getName() 
                + "' built by " + car.getMaker() + "." + "\nIt has a "
                + "top speed of " + car.getTopSpeed() + " mph and is rated at " 
                + car.getHP() + " horsepowers."
                + "\nIt has a range of " + car.getRange() + " miles."
                + "\nRacer " + num + "'s car finished the race in "
                + df.format(car.getTime()) + " seconds." + "\nIt finished"
                + " with a speed of " + df.format(car.getSpeed())
                + " mph.");
        return message;
    }
    
    public static String displayBoat(Boats boat, int num) {
        String message;
        message = ("Racer " + num + " chose the '" + boat.getName() 
                + "' built by " + boat.getMaker() + "." + "\nIt has a "
                + "top speed of " + boat.getTopSpeed() 
                + " mph and is made of " + boat.getMaterial() + "."
                + "\nRacer " + num + "'s boat finished the race in "
                + df.format(boat.getTime()) + " seconds." + "\nIt finished"
                + " with a speed of " + df.format(boat.getSpeed())
                + " mph.");
        return message;
    }
    
    public static void compare(Pair<Cars, Boats> rc1, Pair<Cars, Boats> rc2) {
        String message, msg;
        
        msg = displayCar(rc1.getKey(), 1)
            + "\n\n" + displayCar(rc2.getKey(), 2)
            + "\n\n" + displayBoat(rc1.getValue(), 1)
            + "\n\n" + displayBoat(rc2.getValue(), 2);

        JOptionPane.showMessageDialog(null, msg);
        
        double trc1 = rc1.getKey().getTime() + rc1.getValue().getTime();
        double trc2 = rc2.getKey().getTime() + rc2.getValue().getTime();
        
        message = "Racer 1 took a total of " + df.format(trc1) + " seconds."
            + "\n\nRacer 2 took a total of " + df.format(trc2) + " seconds.";
        
        JOptionPane.showMessageDialog(null, message);
        
        if (trc1 < trc2) message = ("\nRacer 1 is the winner!");
        else if (trc1 > trc2) message = ("\nRacer 2 is the winner!");
        else message = ("\nThe race was a tie!");
        
        JOptionPane.showMessageDialog(null, message);
    }
}