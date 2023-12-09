package files;

public abstract class CreditCard {
    private String cardType;
    private String cardNumber;


    public CreditCard successor;

    public void setSuccessor(CreditCard successor) {
        this.successor = successor;
    }
    public CreditCard handleRequest(String card_num) {
        if(validateCard(card_num)){
            return this;
        }
        else if(successor!=null){
            return successor.handleRequest(card_num);
        }
        return null;
    }

    abstract boolean validateCard(String card_num);
    public void setCardType(String cardType){
        this.cardType = cardType;

    }
    public String getCardType() {
        return cardType;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getCardNumber() {
        return cardNumber;
    }


}

