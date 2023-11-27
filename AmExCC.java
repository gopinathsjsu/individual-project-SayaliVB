import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AmExCC extends CreditCard{
    @Override
    public boolean validateCard(String card_num) {
        //First digit is a 3 and second digit a 4 or 7. Length is 15 digits.

        if(card_num!=null) {
            Pattern card_pattern = Pattern.compile("^3[47][0-9]{13}$");
            Matcher ip_pattern = card_pattern.matcher(card_num);
            if (ip_pattern.find()) {
                setCardNumber(card_num);
                setCardType("AmericanExpress");
                return true;
            }
        }
        return false;
    }
}
