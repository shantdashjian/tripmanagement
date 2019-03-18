package tripmanagement;

public class PremiumTrip extends Trip {
    public PremiumTrip(String id) {
        super(id);
    }

    @Override
    public boolean addTraveler(Traveler traveler) {
        if (traveler.isVip()) {
            return travelerSet.add(traveler);
        }
        return false;
    }

    @Override
    public boolean removeTraveler(Traveler traveler) {
        return travelerSet.remove(traveler);
    }
}
