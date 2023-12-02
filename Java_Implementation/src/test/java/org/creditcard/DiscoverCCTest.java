package org.creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscoverCCTest {

    @Test
    void validateCardTrue() {

        CreditCard discoverCC = new DiscoverCC();

        assertTrue(discoverCC.validateCard("6011111100007756"));

    }
    @Test
    void validateCardFalse() {

        CreditCard nondiscoverCC = new DiscoverCC();

        assertFalse(nondiscoverCC.validateCard("601111110000775 "));
        assertFalse(nondiscoverCC.validateCard("6011*11100007756"));
        assertFalse(nondiscoverCC.validateCard("3747856341908126"));
        assertFalse(nondiscoverCC.validateCard(null));

    }

}