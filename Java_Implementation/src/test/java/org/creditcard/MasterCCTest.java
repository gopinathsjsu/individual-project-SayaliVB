package org.creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MasterCCTest {

    @Test
    void validateCardTrue() {

        CreditCard masterCC = new MasterCC();

        assertTrue(masterCC.validateCard("5567894523129089"));
        assertTrue(masterCC.validateCard("5167894523129089"));
        assertTrue(masterCC.validateCard("5267894523129089"));
        assertTrue(masterCC.validateCard("5367894523129089"));
        assertTrue(masterCC.validateCard("5467894523129089"));

}
    @Test
    void validateCardFalse() {

        CreditCard nonmasterCC = new MasterCC();

        assertFalse(nonmasterCC.validateCard("556789452312908 "));
        assertFalse(nonmasterCC.validateCard("536789452312908"));
        assertFalse(nonmasterCC.validateCard("516789452*&29089"));
        assertFalse(nonmasterCC.validateCard("5067894523129089"));
        assertFalse(nonmasterCC.validateCard(null));

    }

}