/**
 * This is a singleton ChampionshipManager, that is responsible for managing the details
 * of this specific championship, because only one instance of this class can exists.
 * It registers drivers, adds race results, gets drivers' standing, and calculates total championship 
 * points. It also show the leading driver.
 */

package main;

import java.util.List;
import java.util.ArrayList;

public class ChampionshipManager {
    
    private static ChampionshipManager instance;
    private List<Driver> drivers = new ArrayList<Driver>();
    private List<RallyRaceResult> races = new ArrayList<RallyRaceResult>();
    private static int totalDrivers = 0;
    private static int totalRaces = 0;

    private ChampionshipManager(){}

    //Singleton pattern
    public static ChampionshipManager getInstance(){
        if (instance == null){
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver){
        drivers.add(driver);
        totalDrivers++;
    }

    public void addRaceResult(RallyRaceResult result){
        races.add(result);
        totalRaces++;
    }

    public List<Driver> getDriverStandings(){
        drivers.sort((a, b) -> Integer.compare(b.getPoints(), a.getPoints()));    
        return drivers;
    }

    public static Driver getLeadingDriver(){
        Driver leader = instance.drivers.get(0);
        for (Driver driver_loop : instance.drivers){
            if(driver_loop.getPoints() > leader.getPoints()){
                leader = driver_loop;
            }
        }
        return leader;
    }

    public static int getTotalChampionshipPoints(){
        int totalChampionshipPoints = 0;
        for (Driver driver_loop : instance.drivers) {
            totalChampionshipPoints += driver_loop.getPoints();
        }
        return totalChampionshipPoints;
    }

    public static int getTotalRaces(){
        return totalRaces;
    }

    public static int getTotalDrivers(){
        return totalDrivers;
    }
}
