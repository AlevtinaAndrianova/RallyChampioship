/**
 * This is extension of Rallycar class. It has an attribute (suspensionTravel), and 
 * there is a constructor that calls the parent class and assigns suspensionTravel.
 * It has a getter and a calculating method.
*/

package main;

public class GravelCar extends RallyCar{

    private double suspensionTravel;
    
    public GravelCar(String make, String model, int horsepower, double suspensionTravel){
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;
    }

    public double getSuspensiontravel(){
        return suspensionTravel;
    }

    public double calculatePerformance(){
        return this.getHorsepower() * 1.1 + suspensionTravel * 4;
    }

}
