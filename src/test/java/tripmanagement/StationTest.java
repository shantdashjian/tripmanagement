package tripmanagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StationTest {

    @Test
    public void testUsualTravelerEconomyTrip() {

        Trip economyTrip = new EconomyTrip("1");

        Traveler mike = new Traveler("Mike", false);

        assertEquals(true, economyTrip.addTraveler(mike));
        assertEquals(1, economyTrip.getTravelerList().size());
        assertEquals(true, economyTrip.removeTraveler(mike));
        assertEquals(0, economyTrip.getTravelerList().size());
        assertEquals("1", economyTrip.getId());
        assertEquals("Mike", mike.getName());


    }
    @Test
    public void testUsualTravelerBusinessTrip() {

        Trip businessTrip = new BusinessTrip("2");

        Traveler mike = new Traveler("Mike", false);

        assertEquals(false, businessTrip.addTraveler(mike));
        assertEquals(0, businessTrip.getTravelerList().size());
        assertEquals(false, businessTrip.removeTraveler(mike));
        assertEquals(0, businessTrip.getTravelerList().size());

    }
    @Test
    public void testVIPTravelerEconomyTrip() {

        Trip economyTrip = new EconomyTrip("1");

        Traveler john = new Traveler("John", true);

        assertEquals(true, economyTrip.addTraveler(john));
        assertEquals(1, economyTrip.getTravelerList().size());
        assertEquals(false, economyTrip.removeTraveler(john));
        assertEquals(1, economyTrip.getTravelerList().size());

    }
    @Test
    public void testVIPTravelerBusinessTrip() {

        Trip businessTrip = new BusinessTrip("2");

        Traveler john = new Traveler("John", true);

        assertEquals(true, businessTrip.addTraveler(john));
        assertEquals(1, businessTrip.getTravelerList().size());
        assertEquals(false, businessTrip.removeTraveler(john));
        assertEquals(1, businessTrip.getTravelerList().size());

    }
}
