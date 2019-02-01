package pairdemo;

/**
 * This class creates objects that store relevant information 
 * about employees.
 */

public class Employee {
    // Variables
    private String name;
    private int idNumber;
    private String department;
    private String position;
    
    /**
     * Constructor.
     */
    
    Employee(){
        this.name = "";
        this.idNumber = 0;
        this.department = "";
        this.position = "";
    }
    
    /**
     * Overloaded constructor.
     * @param name Takes the name of the employee.
     * @param id Takes the ID number of the employee.
     * @param dep Takes the department of the employee.
     * @param pos Takes the position of the employee.
     */
    
    Employee(String name, int id, String dep, String pos){
        this.name = name;
        this.idNumber = id;
        this.department = dep;
        this.position = pos;
    }
    
    /**
     * Mutator for name.
     * @param name Takes the name of the employee.
     */
    
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Mutator for ID number.
     * @param id Takes the ID number of the employee.
     */
    
    public void setID(int id){
        this.idNumber = id;
    }
    
    /**
     * Mutator for department.
     * @param dep Takes the department of the employee.
     */
    
    public void setDepartment(String dep){
        this.department = dep;
    }
    
    /**
     * Mutator for position.
     * @param pos Takes the position of the employee.
     */
    
    public void setPosition(String pos){
        this.position = pos;
    }
    
    /**
     * Accessor for name. 
     * @return Returns the name of the employee.
     */
    
    public String getName(){
        return this.name;
    }
    
    /**
     * Accessor for ID number. 
     * @return Returns the ID number of the employee.
     */
    
    public int getID(){
        return this.idNumber;
    }
    
    /**
     * Accessor for department. 
     * @return Returns the department of the employee.
     */
    
    public String getDepartment(){
        return this.department;
    }
    
    /**
     * Accessor for position. 
     * @return Returns the position of the employee.
     */
    
    public String getPosition(){
        return this.position;
    }
}
