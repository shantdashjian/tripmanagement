package tripmanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StationTest {

    @Nested
    @DisplayName("Given there is a usual traveler")
    class UsualTravelerTest {
        private Traveler mike;

        @BeforeEach
        void setup() {
            mike = new Traveler("Mike", false);
        }

        @DisplayName("When he takes an economy trip")
        @Nested
        class EconomyTripTest {

            @Test
            @DisplayName("Then he can be added and removed")
            public void testEconomyTrip() {

                Trip economyTrip = new EconomyTrip("1");

                assertEquals(true, economyTrip.addTraveler(mike));
                assertEquals(1, economyTrip.getTravelerList().size());
                assertEquals(true, economyTrip.removeTraveler(mike));
                assertEquals(0, economyTrip.getTravelerList().size());
                assertEquals("1", economyTrip.getId());
                assertEquals("Mike", mike.getName());


            }
        }

        @Nested
        @DisplayName("When he takes a business trip")
        class BusinessTripTest {

            @Test
            @DisplayName("Then he cannot be added nor removed")
            public void testBusinessTrip() {

                Trip businessTrip = new BusinessTrip("2");

                assertEquals(false, businessTrip.addTraveler(mike));
                assertEquals(0, businessTrip.getTravelerList().size());
                assertEquals(false, businessTrip.removeTraveler(mike));
                assertEquals(0, businessTrip.getTravelerList().size());

            }
        }

        @Nested
        @DisplayName("When he takes a premium trip")
        class PremiumTripTest {

            @Test
            @DisplayName("Then he cannot be added nor removed")
            public void testPremiumTrip() {

                Trip premiumTrip = new PremiumTrip("3");

                assertEquals(false, premiumTrip.addTraveler(mike));
                assertEquals(0, premiumTrip.getTravelerList().size());
                assertEquals(false, premiumTrip.removeTraveler(mike));
                assertEquals(0, premiumTrip.getTravelerList().size());

            }
        }
    }

    @Nested
    @DisplayName("Given there is a VIP traveler")
    class VIPTravelerTest {
        private Traveler john;

        @BeforeEach
        void setup() {
            john = new Traveler("John", true);
        }

        @Nested
        @DisplayName("When he takes an economy trip")
        class EconomyTripTest {

            @Test
            @DisplayName("Then he cannot be added but not removed")
            public void testEconomyTrip() {

                Trip economyTrip = new EconomyTrip("1");

                assertEquals(true, economyTrip.addTraveler(john));
                assertEquals(1, economyTrip.getTravelerList().size());
                assertEquals(false, economyTrip.removeTraveler(john));
                assertEquals(1, economyTrip.getTravelerList().size());

            }
        }

        @Nested
        @DisplayName("When he takes a business trip")
        class BusinessTripTest {

            @Test
            @DisplayName("Then he can be added but not removed")
            public void testBusinessTrip() {

                Trip businessTrip = new BusinessTrip("2");

                assertEquals(true, businessTrip.addTraveler(john));
                assertEquals(1, businessTrip.getTravelerList().size());
                assertEquals(false, businessTrip.removeTraveler(john));
                assertEquals(1, businessTrip.getTravelerList().size());

            }
        }

        @Nested
        @DisplayName("When he takes a premium trip")
        class PremiumTripTest {

            @Test
            @DisplayName("Then he can be added and removed")
            public void testPremiumTrip() {

                Trip premiumTrip = new PremiumTrip("3");

                assertEquals(true, premiumTrip.addTraveler(john));
                assertEquals(1, premiumTrip.getTravelerList().size());
                assertEquals(true, premiumTrip.removeTraveler(john));
                assertEquals(0, premiumTrip.getTravelerList().size());

            }
        }
    }
}
