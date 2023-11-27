import java.util.regex.Pattern;

public class InvalidCC extends CreditCard{
    @Override
    boolean validateCard(String card_num) {
        String cardtype ="Invalid: ";
        setCardNumber(card_num);
        if(card_num == null || card_num.isEmpty()){
            cardtype += "empty or null card number";
            setCardType(cardtype);
            return true;
        }
        Pattern p = Pattern.compile("^[0-9]*$");
        boolean hasOnlyDigits = p.matcher(card_num).find();

        if(card_num.length()>19){
            cardtype += "more than 19 digits";
        }
        else if(hasOnlyDigits){
            cardtype += "not a possible card number";
        }
        else{
            cardtype += "non numeric characters";
        }
        setCardType(cardtype);

        return true;
    }

}
