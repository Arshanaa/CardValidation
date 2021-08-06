public class VisaCard extends CreditCard {

    VisaCard(String cardNum, int expiryMonth, int expiryYear) {
        this.cardType = "VisaCard";
        this.cardNum = cardNum;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
    }

    @Override
    boolean isValidLength() {
        return cardNum.length() == 13 || cardNum.length() == 16;
    }

    @Override
    boolean isValidPrefix() {
        float prefix = Character.getNumericValue(cardNum.charAt(0));

        return prefix == 4;
    }

    @Override
    boolean isAccountInGoodStand() {
        return true;
    }
}
