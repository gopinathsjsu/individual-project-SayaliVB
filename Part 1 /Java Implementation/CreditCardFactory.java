package files;

public class CreditCardFactory {
    public CreditCard createCardInstance(String card_num){

        CreditCard newCard = null;
        CreditCard visacc = new VisaCC();
        CreditCard mastercc = new MasterCC();
        CreditCard amexcc = new AmExCC();
        CreditCard invalidcc = new InvalidCC();

        CreditCard discovercc = new DiscoverCC();

        // Setting up the chain
        visacc.setSuccessor(mastercc);
        mastercc.setSuccessor(amexcc);
        amexcc.setSuccessor(discovercc);
        discovercc.setSuccessor(invalidcc);

        newCard = visacc.handleRequest(card_num);

        return newCard;

    }
}
