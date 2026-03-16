/**
 * The main program which creates all the cars and drivers, registers them with ChampionshipManager,
 * and it creates a list of RallyRaceResult to store results of each race. Then it creates 2 different races
 * and also keeps a map of the result of each driver to print later, and records the results into the lists.
 * Then it print required details, like championship standing to the user.
 */

package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class RallyChampionship {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        // Create cars
        RallyCar gravelCar = new GravelCar("Toyota", "GR Yaris", 380, 1.4);
        RallyCar asphaltCar = new AsphaltCar("Hyundai", "i20 N", 390, 1.2);

        // Create drivers
        Driver ogier = new Driver("Sébastien Ogier", "France", asphaltCar);
        Driver rovanpera = new Driver("Kalle Rovanperä", "Finland", asphaltCar);
        Driver tanak = new Driver("Ott Tänak", "Estonia", asphaltCar);
        Driver neuville = new Driver("Thierry Neuville", "Belgium", asphaltCar);

        // Register drivers
        manager.registerDriver(ogier);
        manager.registerDriver(rovanpera);
        manager.registerDriver(tanak);
        manager.registerDriver(neuville);

        // Create a list of races
        List<RallyRaceResult> races = new ArrayList<>();

        // Finland Rally
        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyväskylä");

        // Store per-race points manually
        Map<Driver, Integer> race1Points = new HashMap<>();
        race1.recordResult(ogier, 1, 25);
        race1Points.put(ogier, 25);
        race1.recordResult(tanak, 2, 18);
        race1Points.put(tanak, 18);
        race1.recordResult(rovanpera, 3, 15);
        race1Points.put(rovanpera, 15);
        race1.recordResult(neuville, 4, 12);
        race1Points.put(neuville, 12);

        races.add(race1);
        manager.addRaceResult(race1);

        // Switch to gravel cars
        ogier.setCar(gravelCar);
        tanak.setCar(gravelCar);
        rovanpera.setCar(gravelCar);
        neuville.setCar(gravelCar);

        // Monte Carlo Rally
        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");

        Map<Driver, Integer> race2Points = new java.util.HashMap<>();
        race2.recordResult(rovanpera, 1, 25);
        race2Points.put(rovanpera, 25);
        race2.recordResult(neuville, 2, 18);
        race2Points.put(neuville, 18);
        race2.recordResult(ogier, 3, 15);
        race2Points.put(ogier, 15);
        race2.recordResult(tanak, 4, 12);
        race2Points.put(tanak, 12);

        races.add(race2);
        manager.addRaceResult(race2);

        System.out.println("\n===== CHAMPIONSHIP STANDINGS =====");
        int pos = 1;
        for (Driver d : manager.getDriverStandings()) {
            System.out.println(pos++ + ". " + d.getName() + " (" + d.getCountry() + "): " + d.getPoints() + " points");
        }

        Driver leader = ChampionshipManager.getLeadingDriver();
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        System.out.println(leader.getName() + " with " + leader.getPoints() + " points");

        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipStatistics.getTotalRacesHeld());
        System.out.println("Average Points Per Driver: " + String.format("%.2f", ChampionshipStatistics.calculateAveragePointsPerDriver(manager.getDriverStandings())));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(manager.getDriverStandings()));
        System.out.println("Total Championship Points: " + ChampionshipManager.getTotalChampionshipPoints());

        System.out.println("\n===== RACE RESULTS =====");
        for (RallyRaceResult race : races) {
            System.out.println("Race: " + race.getRaceName() + " (" + race.getLocation() + ")");
            Map<Driver, Integer> racePoints;
            if (race.getRaceName().equals("Rally Finland")) {
                racePoints = race1Points;
            } else {
                racePoints = race2Points;
            }

            race.getResults().stream()
                .sorted((a, b) -> Integer.compare(racePoints.get(b), racePoints.get(a)))
                .forEach(d -> {
                    int points = racePoints.get(d);
                    int position = race.getResultsMap().get(d);
                    System.out.println(" Position " + position + ": " + d.getName() + " - " + points + " points");
                });
            System.out.println();
        }

        System.out.println("===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + String.format("%.1f", gravelCar.calculatePerformance()));
        System.out.println("Asphalt Car Performance: " + String.format("%.1f", asphaltCar.calculatePerformance()));
    }
}
 