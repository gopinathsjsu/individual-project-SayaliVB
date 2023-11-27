package org.creditcard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVFileFormat extends FileFormat {
    String delimiter = ",";

    CSVFileFormat(String ipfilename, String opfilename) {
        super(ipfilename, opfilename);
    }

    @Override
    void readFile() {
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(getIpFileName()));
            br.readLine();
            while((line = br.readLine()) != null){
                String values = line.split(delimiter)[0];
                cardRecords.add(values);
            }
            br.close();
        } catch (Exception e){
            setExceptionRead(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @Override
    void writeFile() {
        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter(getOpFileName());
            csvWriter.append("cardNumber");
            csvWriter.append(",");
            csvWriter.append("cardType");
            csvWriter.append("\n");

            for (CreditCard card : cards) {
                csvWriter.append(String.join(",", card.getCardNumber(), card.getCardType()));
                csvWriter.append("\n");
            }
            csvWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
