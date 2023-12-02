package org.creditcard;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JSONFileFormatTest {

    @Test
    void readFile() {

        List<String> card_num_test = new ArrayList<>();
        card_num_test.add("59012345678901234567890");
        card_num_test.add("4123456789123");


        //Java_Implementation/src/main/java/org/creditcard/test_files/input_test.json
        FileFormat jsonFile= new JSONFileFormat("/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/test_files/input_test.json",
                "/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/output_test.json");

        jsonFile.readFile();

        assertIterableEquals(card_num_test, jsonFile.cardRecords);

        jsonFile= new JSONFileFormat("no_file.json", "no_file.json");
        assertEquals (0, jsonFile.cardRecords.size());


    }

    @Test
    void writeFile() {
        List<CreditCard> cards_test = new ArrayList<>();
        CreditCard card = new InvalidCC();
        card.setCardNumber("59012345678901234567890");
        card.setCardType("Invalid: more than 19 digits");
        cards_test.add(card);

        card = new VisaCC();
        card.setCardNumber("4123456789123");
        card.setCardType("Visa");
        cards_test.add(card);

        FileFormat jsonFile= new JSONFileFormat("/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/test_files/input_test.json",
                "/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/test_files/output_test.json");
        jsonFile.cards = cards_test;

        jsonFile.writeFile();

        File file1 = new File("/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/test_files/output_test.json");
        File file2 = new File("/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/test_files/output_test_sample.json");


        try {
            assertTrue(FileUtils.contentEquals(file1, file2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}