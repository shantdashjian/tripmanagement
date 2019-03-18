package tripmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Trip {

    protected String id;
    protected List<Traveler> travelerList = new ArrayList<>();

    public Trip(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<Traveler> getTravelerList() {
        return Collections.unmodifiableList(travelerList);
    }

    public abstract boolean addTraveler(Traveler traveler);

    public abstract boolean removeTraveler(Traveler traveler);
}
