import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flight {
    private String flightId;
    private String from;
    private String to;
    private double price;

    public Flight(String flightId, String from, String to, double price) {
        this.flightId = flightId;
        this.from = from;
        this.to = to;
        this.price = price;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getPrice() {
        return price;
    }
}

class FlightDatabase {
    private List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<Flight> getFlightsForCity(String city) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getFrom().equals(city) || flight.getTo().equals(city)) {
                result.add(flight);
            }
        }
        return result;
    }

    public List<Flight> getFlightsFromCity(String city) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getFrom().equals(city)) {
                result.add(flight);
            }
        }
        return result;
    }

    public List<Flight> getFlightsBetweenCities(String city1, String city2) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if ((flight.getFrom().equals(city1) && flight.getTo().equals(city2)) ||
                (flight.getFrom().equals(city2) && flight.getTo().equals(city1))) {
                result.add(flight);
            }
        }
        return result;
    }
}

public class SOFENGAss {
    public static void main(String[] args) {
        FlightDatabase database = new FlightDatabase();
        database.addFlight(new Flight("AI161E90", "BLR", "BOM", 5600));
        database.addFlight(new Flight("BR161F91", "BOM", "BBI", 6750));
        database.addFlight(new Flight("AI161F99", "BBI", "BLR", 8210));
        database.addFlight(new Flight("VS171E20", "JLR", "BBI", 5500));
        database.addFlight(new Flight("AS171G30", "HYD", "JLR", 4400));
        database.addFlight(new Flight("AI131F49", "HYD", "BOM", 3499));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Priyansh Dixit");
        System.out.println("What do you want:");
        System.out.println("1. Flights for a particular City");
        System.out.println("2. Flights From a city");
        System.out.println("3. Flights between two given cities");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter a city: ");
            String city = scanner.next();
            List<Flight> flightsForCity = database.getFlightsForCity(city);
            printFlights(flightsForCity);
        } else if (choice == 2) {
            System.out.print("Enter a city: ");
            String city = scanner.next();
            List<Flight> flightsFromCity = database.getFlightsFromCity(city);
            printFlights(flightsFromCity);
        } else if (choice == 3) {
            System.out.print("Enter the first city: ");
            String city1 = scanner.next();
            System.out.print("Enter the second city: ");
            String city2 = scanner.next();
            List<Flight> flightsBetweenCities = database.getFlightsBetweenCities(city1, city2);
            printFlights(flightsBetweenCities);
        } else {
            System.out.println("Invalid choice");
        }
    }

    public static void printFlights(List<Flight> flights) {
        if (flights.isEmpty()) {
            System.out.println("No flights found.");
        } else {
            System.out.println("Flight ID\tFrom\tTo\tPrice");
            for (Flight flight : flights) {
                System.out.println(
                    flight.getFlightId() + "\t" + flight.getFrom() + "\t" + flight.getTo() + "\t" + flight.getPrice()
                );
            }
        }
    }
}
