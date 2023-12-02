package org.creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmExCCTest {

    @Test
    void validateCardTrue() {

        CreditCard amex = new AmExCC();

        assertTrue(amex.validateCard("347856341908126"));
        assertTrue(amex.validateCard("374856341908126"));

    }
    @Test
    void validateCardFalse() {

        CreditCard nonamex = new AmExCC();

        assertFalse(nonamex.validateCard("6011111100007756"));
        assertFalse(nonamex.validateCard("347856341908126 "));
        assertFalse(nonamex.validateCard("34785634190126 "));
        assertFalse(nonamex.validateCard("3747856341908126"));
        assertFalse(nonamex.validateCard(null));

    }

}