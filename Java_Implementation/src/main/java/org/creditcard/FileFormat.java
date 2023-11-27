package org.creditcard;

import java.util.ArrayList;
import java.util.List;

public abstract class FileFormat {
    private String ipFileName;
    private String opFileName;
    protected List<CreditCard> cards;
    protected List<String> cardRecords;
    private String exceptionRead;

    FileFormat(String ipfilename, String opfilename){
        ipFileName = ipfilename;
        opFileName =opfilename;
        cards = new ArrayList<>();
        cardRecords = new ArrayList<>();
    }

    public void validateCreditCard(){
        readFile();
        createCreditCardRecords();;
        if(exceptionRead ==null || exceptionRead.isEmpty() || exceptionRead.isBlank()) {
            writeFile();
            System.out.println("Data has been written to "+ getOpFileName());
        }
    }

    abstract void readFile();

    protected void createCreditCardRecords(){
        CreditCardFactory ccf= new CreditCardFactory();
        for(String record : cardRecords){
            CreditCard card = ccf.createCardInstance(record);
            cards.add(card);
        }
    }

    abstract void writeFile();

    public String getIpFileName() {
        return ipFileName;
    }

    public String getOpFileName() {
        return opFileName;
    }

    public String getExceptionRead() {
        return exceptionRead;
    }

    public void setExceptionRead(String exceptionRead) {
        this.exceptionRead = exceptionRead;
    }
}
