/**
 * This is a public class with 4 attributes(name, country, points, car). It also has getters and setters.
 * Besides that, it adds the points. The main point is to hold the driver data.
 */

package main;

//Dependency injection
public class Driver {
    private String name;
    private String country;
    private int points;
    private RallyCar car;
    
    public Driver(String name, String country, RallyCar car){
        this.name = name;
        this.country = country;
        this.car = car;
    }

    public String getName(){
        return name;
    }

    public String getCountry(){
        return country;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public int getPoints(){
        return points;
    }

    public void setCar(RallyCar car){
        this.car = car;
    }

    public RallyCar getCar(){
        return car;
    }

    public void addPoints(int newPoints){
        points = points + newPoints;
    }
}
