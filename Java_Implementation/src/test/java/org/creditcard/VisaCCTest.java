package org.creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisaCCTest {

    @Test
    void validateCardTrue() {

        CreditCard visaCC = new VisaCC();

        assertTrue(visaCC.validateCard("4123456789123999"));
        assertTrue(visaCC.validateCard("4123456789123"));

    }
    @Test
    void validateCardFalse() {

        CreditCard nonvisaCC = new VisaCC();

        assertFalse(nonvisaCC.validateCard("412345678912399"));
        assertFalse(nonvisaCC.validateCard("412345678912399 "));
        assertFalse(nonvisaCC.validateCard("34785634190126"));
        assertFalse(nonvisaCC.validateCard("41234567&9123999"));
        assertFalse(nonvisaCC.validateCard("412345678912 "));
        assertFalse(nonvisaCC.validateCard("412345678912"));
        assertFalse(nonvisaCC.validateCard(null));

    }

}