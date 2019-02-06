package pairsuperclassdemo;

public class Boats extends Vehicles{ 

    /* /////////////////// FIELDS //////////////////// */

    private final double speedLimit = 20;
    private String material;
    
    /* /////////////////// CONSTRUCTORS ////////////// */
    
    Boats() {
        super();
        this.material = "";
    }
    
    Boats(String name, String make, int topSpeed, double rate,
            double distance, String material) {
        super(name, make, topSpeed, rate, distance);
        this.material = material;
    }
    
    /* /////////////////// METHODS /////////////////// */
    
    public String getMaterial() {
        return this.material;
    }
    
    @Override
    public double getSpeed() {
        return this.speedLimit;
    }
    
    @Override
    public double getTime() {
        double time, temp, distLeft;
        time = (this.speedLimit / this.rate);
        temp = (0.5 * rate * Math.pow(time, 2));
        distLeft = this.distance - temp;
        time += (distLeft / this.speedLimit);
        return (60 * time);
    }
}