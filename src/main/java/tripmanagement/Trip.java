package tripmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trip {

    private String id;
    private List<Traveler> travelerList = new ArrayList<>();
    private String tripType;

    public Trip(String id, String tripType) {
        this.id = id;
        this.tripType = tripType;
    }

    public String getId() {
        return id;
    }

    public List<Traveler> getTravelerList() {
        return Collections.unmodifiableList(travelerList);
    }

    public String getTripType() {
        return tripType;
    }

    public boolean addTraveler(Traveler traveler) {
        switch (tripType) {
            case "Economy":
                return travelerList.add(traveler);
            case "Business":
                if (traveler.isVip()) {
                    return travelerList.add(traveler);
                }
                return false;
            default:
                throw new RuntimeException("Unknown type:" + tripType);
        }
    }

    public boolean removeTraveler(Traveler traveler) {
        switch (tripType) {
            case "Economy":
                if (traveler.isVip()) {
                    return travelerList.remove(traveler);
                }
                return false;
            case "Business":
                return false;
            default:
                throw new RuntimeException("Unknown type:" + tripType);
        }

    }
}
