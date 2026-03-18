package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RestServiceApplicationTest {

    @Test
    void parsePortFallsBackToDefaultWhenMissingOrInvalid() {
        assertEquals(5000, RestServiceApplication.parsePort(null));
        assertEquals(5000, RestServiceApplication.parsePort("   "));
        assertEquals(5000, RestServiceApplication.parsePort("docker"));
    }

    @Test
    void parsePortFallsBackToDefaultWhenOutOfRange() {
        assertEquals(5000, RestServiceApplication.parsePort("0"));
        assertEquals(5000, RestServiceApplication.parsePort("-1"));
        assertEquals(5000, RestServiceApplication.parsePort("65536"));
    }

    @Test
    void parsePortAcceptsRangeOneToSixtyFiveThousandFiveHundredThirtyFive() {
        assertEquals(1, RestServiceApplication.parsePort("1"));
        assertEquals(8080, RestServiceApplication.parsePort("8080"));
        assertEquals(65535, RestServiceApplication.parsePort("65535"));
    }
}
