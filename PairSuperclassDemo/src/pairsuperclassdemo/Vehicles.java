package pairsuperclassdemo;

public abstract class Vehicles {
    
    /* /////////////////// FIELDS //////////////////// */
    
    private String modelName, manufacturer;
    private int topSpeed;
    public double rate, distance;
    
    /* /////////////////// CONSTRUCTORS ////////////// */
    
    Vehicles() {
        this.modelName = "";
        this.manufacturer = "";
        this.topSpeed = 0;
        this.rate = 0;
        this.distance = 0;
    }
    
    Vehicles(String name, String make, int topSpeed, 
            double rate, double distance) {
        this.modelName = name;
        this.manufacturer = make;
        this.topSpeed = topSpeed;
        this.rate = rate;
        this.distance = distance;
    }
    
    /* /////////////////// METHODS /////////////////// */
    
    public String getName() {
        return this.modelName;
    }
    
    public String getMaker() {
        return this.manufacturer;
    }
    
    public int getTopSpeed() {
        return this.topSpeed;
    }
    
    public abstract double getSpeed();
    public abstract double getTime();
}