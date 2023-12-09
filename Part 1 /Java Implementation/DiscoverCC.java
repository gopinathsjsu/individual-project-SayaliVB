package files;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiscoverCC extends CreditCard{
    @Override
    boolean validateCard(String card_num) {
        //First four digits are 6011. Length is 16 digits.

        if(card_num!=null) {
            Pattern card_pattern = Pattern.compile("^6011[0-9]{12}$");
            Matcher ip_pattern = card_pattern.matcher(card_num);
            if (ip_pattern.find()) {
                setCardNumber(card_num);
                setCardType("Discover");
                return true;
            }
        }
        return false;
    }
}
