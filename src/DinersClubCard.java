public class DinersClubCard extends CreditCard {

    DinersClubCard(String cardNum, int expiryMonth, int expiryYear) {
        this.cardType = "DinersClubCard";
        this.cardNum = cardNum;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
    }

    @Override
    boolean isValidLength() {
        return cardNum.length() == 14;
    }

    @Override
    boolean isValidPrefix() {
        int prefix = Integer.parseInt(cardNum.substring(0, 2));

        return prefix == 30 || prefix == 36 || prefix == 38;
    }

    @Override
    boolean isAccountInGoodStand() {
        return true;
    }
}
