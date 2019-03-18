package tripmanagement;

public class PremiumTrip extends Trip {
    public PremiumTrip(String id) {
        super(id);
    }

    @Override
    public boolean addTraveler(Traveler traveler) {
        if (traveler.isVip()) {
            return travelerList.add(traveler);
        }
        return false;
    }

    @Override
    public boolean removeTraveler(Traveler traveler) {
        return travelerList.remove(traveler);
    }
}
