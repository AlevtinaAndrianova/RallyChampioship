/**
 * This is an interface for RallyRaceResult. 
 */

package main;

import java.util.List;

public interface RaceResult {
    
    public void recordResult(Driver driver, int position, int points);
        
    public int getDriverPoints(Driver driver);

    public List<Driver> getResults();
}
