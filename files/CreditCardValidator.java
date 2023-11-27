import java.util.*;

public class CreditCardValidator {

     public static void main(String[] args) {

         Scanner myObj = new Scanner(System.in);
         System.out.println("Enter input file name: ");
         String inputFileName = myObj.nextLine();
         System.out.println("Enter output file name: ");
         String outputFileName = myObj.nextLine();

         FileFormatFactory fileFormatFactory = new FileFormatFactory();
         FileFormat fileFormat;

         fileFormat = fileFormatFactory.selectFileFormat(inputFileName,  outputFileName);

         if(fileFormat == null){
             System.out.println("Please enter valid file name and extension!");
             return;
         }
         fileFormat.validateCreditCard();

     }
}
