package org.creditcard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileFormatTest {

    @Test
    void createCreditCardRecords() {
        List<String> card_num_test = new ArrayList<>();
        card_num_test.add("59012345678901234567890");
        card_num_test.add(null);
        card_num_test.add("4123456789123");


        List<CreditCard> cards_test = new ArrayList<>();
        CreditCard card = new InvalidCC();
        card.setCardNumber("59012345678901234567890");
        card.setCardType("Invalid: more than 19 digits");
        cards_test.add(card);

        card = new InvalidCC();
        card.setCardNumber(null);
        card.setCardType("Invalid: empty/null card number");
        cards_test.add(card);

        card = new VisaCC();
        card.setCardNumber("4123456789123");
        card.setCardType("Visa");
        cards_test.add(card);


        FileFormat file= new JSONFileFormat("input_test.json", "output_test.json");
        file.cardRecords = card_num_test;

        file.createCreditCardRecords();

        for(int i =0;i< cards_test.size();i++){
            assertEquals(cards_test.get(i).getCardNumber(), file.cards.get(i).getCardNumber());
            assertEquals(cards_test.get(i).getCardType(), file.cards.get(i).getCardType());
            assertEquals((cards_test.get(i)).getClass(), file.cards.get(i).getClass());
        }

    }
}