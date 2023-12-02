package org.creditcard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VisaCC extends CreditCard{

    @Override
    public boolean validateCard(String card_num) {
        //First digit is a 4. Length is either 13 or 16 digits.

        if(card_num!=null) {
            Pattern card_pattern = Pattern.compile("^4(([0-9]{12})|([0-9]{15}))$");
            Matcher ip_pattern = card_pattern.matcher(card_num);
            if (ip_pattern.find()) {
                setCardNumber(card_num);
                setCardType("Visa");
                return true;
            }
        }
        return false;
    }

}
