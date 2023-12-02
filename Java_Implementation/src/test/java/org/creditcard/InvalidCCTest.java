package org.creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvalidCCTest {

    @Test
    void validateCardNonNumeric() {
        CreditCard invalid = new InvalidCC();
        String cardtype ="Invalid: ";

        invalid.validateCard("347856341908126 ");
        assertEquals(cardtype + "non numeric characters", invalid.getCardType());

    }
    @Test
    void validateCardinvalid() {
        CreditCard invalid = new InvalidCC();
        String cardtype ="Invalid: ";

        invalid.validateCard("99347856341908126");
        assertEquals(cardtype + "not a possible card number", invalid.getCardType());

    }

    @Test
    void validateCardLength() {
        CreditCard invalid = new InvalidCC();
        String cardtype ="Invalid: ";
        invalid.validateCard("34785634190812665839");
        assertEquals(cardtype + "more than 19 digits", invalid.getCardType());
    }

    @Test
    void validateCardNull() {
        CreditCard invalid = new InvalidCC();
        String cardtype ="Invalid: ";

        invalid.validateCard(null);
        assertEquals(cardtype + "empty/null card number", invalid.getCardType());

        cardtype ="Invalid: ";
        invalid.validateCard("");
        assertEquals(cardtype + "empty/null card number", invalid.getCardType());

    }
}