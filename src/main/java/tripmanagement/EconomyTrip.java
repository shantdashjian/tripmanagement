package tripmanagement;

public class EconomyTrip extends Trip {

    public EconomyTrip(String id) {
        super(id);
    }

    @Override
    public boolean addTraveler(Traveler traveler) {
        return travelerList.add(traveler);
    }

    @Override
    public boolean removeTraveler(Traveler traveler) {
        if (!traveler.isVip()) {
            return travelerList.remove(traveler);
        }
        return false;
    }
}
