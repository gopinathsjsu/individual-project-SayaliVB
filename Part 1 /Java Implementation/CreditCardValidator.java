package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CreditCardValidator {

    static List<CreditCard> cards = new ArrayList<>();
    static List<String> cardRecords = new ArrayList<>();
     public static void main(String[] args) {
         Scanner myObj = new Scanner(System.in);
         System.out.println("Enter input file name: ");
         String inputFileName = myObj.nextLine();
         System.out.println("Enter output file name: ");
         String outputFileName = myObj.nextLine();

         readFile(inputFileName);

         CreditCardFactory ccf= new CreditCardFactory();
         for(String record : cardRecords){
             CreditCard card = ccf.createCardInstance(record);
             cards.add(card);
         }

         writeFile(outputFileName);


     }

    public static void readFile(String filename) {

        String line;
        String delimiter = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            br.readLine();
            while((line = br.readLine()) != null){
                String values = line.split(delimiter)[0];
                cardRecords.add(values);
            }
            br.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void writeFile(String filename) {
        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter(filename);
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
