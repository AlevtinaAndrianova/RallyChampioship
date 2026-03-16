/**
 * This public stativ class's point is to provide utilities for the Championship, like
 * like calculating average scores and finding most succeessful countries. Also, returns 
 * total races.
 */

package main;

import java.util.List;

public class ChampionshipStatistics {
    
    public static double calculateAveragePointsPerDriver(List<Driver>drivers){
        int totalChampionshipPoints = 0;
        for (Driver driver_loop : drivers) {
            totalChampionshipPoints += driver_loop.getPoints();
        }
        return totalChampionshipPoints/drivers.size();
    }

    public static String findMostSuccessfulCountry(List<Driver>drivers){
        int bestCountryPoints = 0;
        String bestCountry = null;
        for (Driver driverOuter : drivers){
            int points = 0;
            for (Driver driverInner : drivers) {
                if(driverInner.getCountry() == driverOuter.getCountry()){
                    points += driverInner.getPoints();
                }
                if (points > bestCountryPoints) {
                    bestCountryPoints = points;
                    bestCountry = driverOuter.getCountry();
                }
            }
        }
        return bestCountry;
    }

    public static int getTotalRacesHeld(){
        return ChampionshipManager.getTotalRaces();
    }
}
