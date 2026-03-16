/**
 * This is an abstract class for other car types. It has getters and abstract method, which is not implemented.
 * It has 3 attributes (make, model, horsepower).
 */

package main;

abstract class RallyCar {
    private String make;
    private String model;
    private int horsepower;
    
    public RallyCar(String make, String model, int horsepower){
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public int getHorsepower(){
        return horsepower;
    }

    abstract double calculatePerformance();
}
