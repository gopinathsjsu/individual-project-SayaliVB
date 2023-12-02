package org.creditcard;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class XMLFileFormatTest {

    @Test
    void readFile() {

        List<String> card_num_test = new ArrayList<>();
        card_num_test.add("377856341908126");
        card_num_test.add("6011*890HJrt6789");


        //Java_Implementation/src/main/java/org/creditcard/test_files/input_test.xml
        FileFormat xmlFile= new XMLFileFormat("/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/test_files/input_test.xml",
                "/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/output_test.xml");

        xmlFile.readFile();

        assertIterableEquals(card_num_test, xmlFile.cardRecords);

        xmlFile= new XMLFileFormat("no_file.xml", "no_file.xml");
        assertEquals (0, xmlFile.cardRecords.size());


    }

    @Test
    void writeFile() {
        List<CreditCard> cards_test = new ArrayList<>();
        CreditCard card = new AmExCC();
        card.setCardNumber("377856341908126");
        card.setCardType("AmericanExpress");
        cards_test.add(card);

        card = new InvalidCC();
        card.setCardNumber("6011*890HJrt6789");
        card.setCardType("Invalid: non numeric characters");
        cards_test.add(card);

        FileFormat xmlFile= new XMLFileFormat("/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/test_files/input_test.xml",
                "/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/test_files/output_test.xml");
        xmlFile.cards = cards_test;

        xmlFile.writeFile();

        File file1 = new File("/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/test_files/output_test.xml");
        File file2 = new File("/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/test_files/output_test_sample.xml");


        try {
            assertTrue(FileUtils.contentEquals(file1, file2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}