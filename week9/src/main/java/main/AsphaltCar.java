/**
 * This is extension of Rallycar class. It has an attribute (downforce), and 
 * there is a constructor that calls the parent class and assigns downforce.
 * It has a getter and a calculating method.
*/

package main;

public class AsphaltCar extends RallyCar {

    private double downforce;
    
    public AsphaltCar(String make, String model, int horsepower, double downforce){
        super(make, model, horsepower);
        this.downforce = downforce;
    }

    public double getDownforce(){
        return downforce;
    }

    public double calculatePerformance(){
        return this.getHorsepower() * 1.2 + downforce * 3.33;
    }
}
