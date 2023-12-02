package org.creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    @Test
    void setSuccessor() {

        CreditCard cc1 = new VisaCC();
        CreditCard cc2 = new MasterCC();

        cc1.setSuccessor(cc2);
        assertEquals(cc2, cc1.successor);

    }

    @Test
    void handleRequest() {
        CreditCard cc1 = new VisaCC();
        CreditCard cc2 = new MasterCC();

        cc1.setSuccessor(cc2);


        assertEquals(VisaCC.class, cc1.handleRequest("4123456789123999").getClass());
        assertEquals(MasterCC.class, cc1.handleRequest("5367894523129089").getClass());
        assertEquals(null, cc1.handleRequest("536 7894523129089"));

    }
}