package exam03;

import java.text.Collator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

//public class Cruise {
//    private Boat boat;
//    private LocalDate sailing;
//    private double basicPrice;
//
//    public Cruise(Boat boat, LocalDate  sailing, double basicPrice) {
//        this.boat = boat;
//       this.sailing=sailing;
//        this.basicPrice = basicPrice;
//
//    }
//
//    public Boat getBoat() {
//        return boat;
//    }
//
//    public LocalDate getSailing() {
//        return sailing;
//    }
//
//    public double getBasicPrice() {
//        return basicPrice;
//    }
//
//    public List<Passenger> getPassengers() {
//        return passengers;
//    }
//
//    public List<Passenger> passengers=new ArrayList<>();
//
//    public void bookPassenger(Passenger passenger) {
//        if (passengers.size() >= boat.getMaxPassengers()) {
//            throw new IllegalArgumentException();
//        }
//            passengers.add(passenger);
//
//    }
//
//public double getPriceForPassenger(Passenger passenger){
//        return passenger.getCruiseClass().getMultiplier()*basicPrice;
//}
//
//public Passenger findPassengerByName(String name){
//        for (Passenger p:passengers){
//            if(p.getName().equals(name)){
//                return p;
//            }
//        }
//        throw new IllegalArgumentException("not found");
//}
//
//public List <String> getPassengerNamesOrdered(){
//        List <String> result = new ArrayList<>();
//    for (Passenger p:passengers){
//        result.add(p.getName());
//        }
//    Collections.sort(result, Collator.getInstance(new Locale("hu", "HU")));
//    return result;
//}
//
//public double sumAllBookingsCharged(){
//        int sum=0;
//    for (Passenger p:passengers){
//        sum+=p.getCruiseClass().getMultiplier()*basicPrice;
//    }
//    return sum;
//}
//
//    public Map<CruiseClass, Integer> countPassengerByClass(){
//        Map<CruiseClass, Integer> result= new HashMap<>();
//        for (Passenger p:passengers){
//                if (!result.containsKey(p.getCruiseClass())) {
//                    result.put(p.getCruiseClass(), 1);
//                }
//                else {
//                    result.put(p.getCruiseClass(), result.get(p.getCruiseClass())+1);
//                }
//
//    }
//        return result;
//}
//}

public class Cruise {
    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;

    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void bookPassenger(Passenger passenger) {
//
//            if (passengers.size() < boat.getMaxPassengers()) {
//                passengers.add(passenger);
//            }
//        throw new IllegalArgumentException();


        if (passengers.size() >= boat.getMaxPassengers()) {
            throw new IllegalArgumentException();
        }
        passengers.add(passenger);
    }

    public double getPriceForPassenger(Passenger passenger) {
        return passenger.getCruiseClass().getMultiplier() * basicPrice;

    }

    public Passenger findPassengerByName(String name) {
        for (Passenger p : passengers) {
            if (p.getName().equals(name)) return p;
        }
        throw new IllegalArgumentException("not found");
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> result = new ArrayList<>();
        for (Passenger p : passengers) {
            result.add(p.getName());
        }
        Collections.sort(result, Collator.getInstance(new Locale("hu", "HU")));
        return result;
    }

    public double sumAllBookingsCharged() {

        double sum = 0;

        for (Passenger p : passengers) {
            sum += p.getCruiseClass().getMultiplier() * basicPrice;
        }
        return sum;

    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> result = new HashMap<>();

        for (Passenger p : passengers) {
            if (result.containsKey(p.getCruiseClass())) {
                result.put(p.getCruiseClass(), result.get(p.getCruiseClass()) + 1);
            } else {
                result.put(p.getCruiseClass(), 1);
            }
        }
        return result;
    }
}
