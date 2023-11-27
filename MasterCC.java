import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MasterCC extends CreditCard{
    @Override
    public boolean validateCard(String card_num) {
        //First digit is a 5, second digit is in range 1 through 5 inclusive. Only valid length of number is 16 digits.

        if(card_num!=null) {
            Pattern card_pattern = Pattern.compile("^5[1-5][0-9]{14}$");
            Matcher ip_pattern = card_pattern.matcher(card_num);
            if (ip_pattern.find()) {
                setCardNumber(card_num);
                setCardType("MasterCard");
                return true;
            }
        }
        return false;
    }

}
