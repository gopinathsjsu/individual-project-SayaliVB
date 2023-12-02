package org.creditcard;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.io.FileUtils;

class CSVFileFormatTest {

    @Test
    void readFile() {

        List<String> card_num_test = new ArrayList<>();
        card_num_test.add("5567894523129089");
        card_num_test.add("3601112345678789");


        //Java_Implementation/src/main/java/org/creditcard/test_files/input_test.csv
        FileFormat csvFile= new CSVFileFormat("/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/test_files/input_test.csv",
                "/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/output_test.csv");

        csvFile.readFile();

        assertIterableEquals(card_num_test, csvFile.cardRecords);

        csvFile= new CSVFileFormat("no_file.csv", "no_file.csv");
        assertEquals (0, csvFile.cardRecords.size());


    }

    @Test
    void writeFile() {
        List<CreditCard> cards_test = new ArrayList<>();
        CreditCard card = new MasterCC();
        card.setCardNumber("5567894523129089");
        card.setCardType("MasterCard");
        cards_test.add(card);

        card = new InvalidCC();
        card.setCardNumber("3601112345678789");
        card.setCardType("Invalid: not a possible card number");
        cards_test.add(card);

        FileFormat csvFile= new CSVFileFormat("/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/test_files/input_test.csv",
                "/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/test_files/output_test.csv");
        csvFile.cards = cards_test;

        csvFile.writeFile();

        File file1 = new File("/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/test_files/output_test.csv");
        File file2 = new File("/Volumes/Files/Sayali/SJSU/Sem 1/202 02/Individual project/individual-project-SayaliVB/Java_Implementation/src/main/java/org/creditcard/test_files/output_test_sample.csv");


        try {
            assertTrue(FileUtils.contentEquals(file1, file2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}