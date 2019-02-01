package pairdemo;

import javafx.util.Pair;

public class PairDemo2 {
    
    /* /////////////////// MAIN ////////////////////// */ 

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.setName("Jack");
        emp1.setID(12345);
        emp1.setDepartment("Accounting");
        emp1.setPosition("President");
        
        Employee emp2 = new Employee("Jill", 67890, "IT", "Chairman");
        
        String emp1Status = "Full time";
        String emp2Status = "Part time";
        
        Pair<Employee, String> pair1 = new Pair<>(emp1, emp1Status);
        Pair<Employee, String> pair2 = new Pair<>(emp2, emp2Status);
        
        displayEmployee(pair1);
        System.out.println();
        displayEmployee(pair2);
    }

    /* /////////////////// METHODS /////////////////// */
    
    public static void displayEmployee(Pair<Employee, String> pair) {
        Employee empl = pair.getKey();
        String status = pair.getValue();
        
        System.out.println("The name of the employee is " + empl.getName()
                    + ". \nEmployee ID: " + empl.getID()
                    + "\nEmployee department: " + empl.getDepartment()
                    + "\nEmployee position: " + empl.getPosition());
    }
}