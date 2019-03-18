package tripmanagement;

public class Station {

    public static void main(String[] args) {
        Trip economyTrip = new Trip("1", "Economy");
        Trip businessTrip = new Trip("2", "Business");

        Traveler mike = new Traveler("Mike", false);
        Traveler john = new Traveler("John", true);

        economyTrip.addTraveler(john);
        economyTrip.removeTraveler(john);
        economyTrip.addTraveler(mike);
        economyTrip.removeTraveler(mike);

        businessTrip.addTraveler(john);
        businessTrip.removeTraveler(john);
        businessTrip.addTraveler(mike);
        businessTrip.removeTraveler(mike);

        System.out.println("Economy Trip Travelers:");
        for (Traveler traveler : economyTrip.getTravelerList()) {
            System.out.println(traveler.getName());
        }

        System.out.println("Business Trip Travelers:");
        for (Traveler traveler : businessTrip.getTravelerList()) {
            System.out.println(traveler.getName());
        }


    }
}
