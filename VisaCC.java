public class VisaCC extends CreditCard{

    @Override
    public boolean validateCard(String card_num) {
        //First digit is a 4. Length is either 13 or 16 digits.

        if(card_num!=null && (card_num.length() == 13 || card_num.length() == 16)){
            if (card_num.charAt(0) == '4') {
                setCardNumber(card_num);
                setCardType("Visa");
                return true;
            }
        }
        return false;
    }

}
