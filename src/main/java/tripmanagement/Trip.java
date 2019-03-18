package tripmanagement;

import java.util.*;

public abstract class Trip {

    protected String id;
    protected Set<Traveler> travelerSet = new HashSet<>();

    public Trip(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Set<Traveler> getTravelerSet() {
        return Collections.unmodifiableSet(travelerSet);
    }

    public abstract boolean addTraveler(Traveler traveler);

    public abstract boolean removeTraveler(Traveler traveler);
}
