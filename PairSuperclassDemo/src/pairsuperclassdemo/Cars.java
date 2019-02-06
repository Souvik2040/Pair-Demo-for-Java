package pairsuperclassdemo;

public class Cars extends Vehicles { 

    /* /////////////////// FIELDS //////////////////// */
    
    private double range, hpRating;
    
    /* /////////////////// CONSTRUCTORS ////////////// */
    
    Cars() {
        super();
        this.range = 0;
        this.hpRating = 0;
    }
    
    Cars(String name, String make, int topSpeed, double rate,
            double distance, double range, double hpRating) {
        super(name, make, topSpeed, rate, distance);
        this.range = range;
        this.hpRating = hpRating;
    }
    
    /* /////////////////// METHODS /////////////////// */
    
    public double getRange() {
        return this.range;
    }
    
    public double getHP() {
        return this.hpRating;
    }
    
    @Override
    public double getSpeed() {
        double speed, temp;
        temp = 2 * this.rate * 3600 * this.distance;
        speed = Math.sqrt(temp);
        return speed;
    }
    
    @Override 
    public double getTime() {
        double time = 60 * Math.sqrt(2 * (this.distance / this.rate));
        return time;
    }
}