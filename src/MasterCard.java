public class MasterCard extends CreditCard {

    MasterCard(String cardNum, int expiryMonth, int expiryYear) {
        this.cardType = "MasterCard";
        this.cardNum = cardNum;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
    }

    @Override
    boolean isValidLength() {
        return cardNum.length() == 16;
    }

    @Override
    boolean isValidPrefix() {
        int prefix = Integer.parseInt(cardNum.substring(0, 2));

        return prefix >= 51 && prefix <= 55;
    }

    @Override
    boolean isAccountInGoodStand() {
        return true;
    }
}
