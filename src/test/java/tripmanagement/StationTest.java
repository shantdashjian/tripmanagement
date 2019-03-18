package tripmanagement;

import org.junit.jupiter.api.*;

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
                assertEquals(1, economyTrip.getTravelerSet().size());
                assertEquals(true, economyTrip.removeTraveler(mike));
                assertEquals(0, economyTrip.getTravelerSet().size());
                assertEquals("1", economyTrip.getId());
                assertEquals("Mike", mike.getName());
            }

            @DisplayName("Then he can only be added once")
            @RepeatedTest(5)
            public void testEconomyTripUsualTravelerOnce(RepetitionInfo repetitionInfo) {

                Trip economyTrip = new EconomyTrip("1");

                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    economyTrip.addTraveler(mike);
                }
                assertEquals(true, economyTrip.getTravelerSet().contains(mike));
                assertEquals(1, economyTrip.getTravelerSet().size());
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
                assertEquals(0, businessTrip.getTravelerSet().size());
                assertEquals(false, businessTrip.removeTraveler(mike));
                assertEquals(0, businessTrip.getTravelerSet().size());

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
                assertEquals(0, premiumTrip.getTravelerSet().size());
                assertEquals(false, premiumTrip.removeTraveler(mike));
                assertEquals(0, premiumTrip.getTravelerSet().size());

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
                assertEquals(1, economyTrip.getTravelerSet().size());
                assertEquals(false, economyTrip.removeTraveler(john));
                assertEquals(1, economyTrip.getTravelerSet().size());

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
                assertEquals(1, businessTrip.getTravelerSet().size());
                assertEquals(false, businessTrip.removeTraveler(john));
                assertEquals(1, businessTrip.getTravelerSet().size());

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
                assertEquals(1, premiumTrip.getTravelerSet().size());
                assertEquals(true, premiumTrip.removeTraveler(john));
                assertEquals(0, premiumTrip.getTravelerSet().size());

            }
        }
    }
}
