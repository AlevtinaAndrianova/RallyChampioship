/**
 * This public class is for implementing RaceResult inteface data.
 * Also contains getters and setters.
 */

package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RallyRaceResult implements RaceResult{
    private String raceName;
    private String location;
    private Map<Driver, Integer> results = new HashMap<>();
    
    public RallyRaceResult(String raceName, String location){
        this.raceName = raceName;
        this.location = location;
    }

    public String getRaceName(){
        return raceName;
    }

    public String getLocation(){
        return location;
    }

    @Override
    public void recordResult(Driver driver, int position, int points){
        results.put(driver, position);
        driver.addPoints(points);
    }

    @Override
    public int getDriverPoints(Driver driver){
        return driver.getPoints();
    }

    @Override
    public List<Driver> getResults(){
        return new ArrayList<>(results.keySet());
    }

    public Map<Driver, Integer> getResultsMap() {
        return results;
    }
 
}

