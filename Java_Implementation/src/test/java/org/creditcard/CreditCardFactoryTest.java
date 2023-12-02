package org.creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardFactoryTest {

    @Test
    void createCardInstanceAmEx() {
        CreditCardFactory ccf= new CreditCardFactory();
        assertEquals(AmExCC.class, ccf.createCardInstance("347856341908126").getClass());
        assertEquals(AmExCC.class, ccf.createCardInstance("374856341908126").getClass());
    }

    @Test
    void createCardInstanceVisa() {
        CreditCardFactory ccf= new CreditCardFactory();
        assertEquals(VisaCC.class, ccf.createCardInstance("4123456789123999").getClass());
        assertEquals(VisaCC.class, ccf.createCardInstance("4123456789123").getClass());
    }

    @Test
    void createCardInstanceDiscover() {
        CreditCardFactory ccf= new CreditCardFactory();
        assertEquals(DiscoverCC.class, ccf.createCardInstance("6011111100007756").getClass());
    }
    @Test
    void createCardInstanceMaster() {
        CreditCardFactory ccf= new CreditCardFactory();
        assertEquals(MasterCC.class, ccf.createCardInstance("5567894523129089").getClass());
        assertEquals(MasterCC.class, ccf.createCardInstance("5167894523129089").getClass());
        assertEquals(MasterCC.class, ccf.createCardInstance("5267894523129089").getClass());
        assertEquals(MasterCC.class, ccf.createCardInstance("5367894523129089").getClass());
        assertEquals(MasterCC.class, ccf.createCardInstance("5467894523129089").getClass());
    }

    @Test
    void createCardInstanceInvalid() {
        CreditCardFactory ccf= new CreditCardFactory();
        assertEquals(InvalidCC.class, ccf.createCardInstance("556789452312908 ").getClass());
        assertEquals(InvalidCC.class, ccf.createCardInstance("536789452312908").getClass());
        assertEquals(InvalidCC.class, ccf.createCardInstance("516789452*&29089").getClass());
        assertEquals(InvalidCC.class, ccf.createCardInstance("5067894523129089").getClass());
        assertEquals(InvalidCC.class, ccf.createCardInstance("412345678912399").getClass());
        assertEquals(InvalidCC.class, ccf.createCardInstance("412345678912399 ").getClass());
        assertEquals(InvalidCC.class, ccf.createCardInstance("34785634190126").getClass());
        assertEquals(InvalidCC.class, ccf.createCardInstance("41234567&9123999").getClass());
        assertEquals(InvalidCC.class, ccf.createCardInstance("412345678912 ").getClass());
        assertEquals(InvalidCC.class, ccf.createCardInstance("412345678912").getClass());
        assertEquals(InvalidCC.class, ccf.createCardInstance("601111110000775 ").getClass());
        assertEquals(InvalidCC.class, ccf.createCardInstance("6011*11100007756").getClass());
        assertEquals(InvalidCC.class, ccf.createCardInstance("3747856341908126").getClass());
        assertEquals(InvalidCC.class, ccf.createCardInstance("347856341908126 ").getClass());
        assertEquals(InvalidCC.class, ccf.createCardInstance("34785634190126 ").getClass());
        assertEquals(InvalidCC.class, ccf.createCardInstance("3747856341908126").getClass());
    }

}