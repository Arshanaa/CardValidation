import java.util.Date;

public abstract class CreditCard {

    String cardType;
    String cardNum;
    int expiryMonth;
    int expiryYear;

    @Override
    public String toString() {
        return ("Card type = " + cardType + ", Card number = " + cardNum + ", Expiry month = " + expiryMonth + ", Expiry year = " + expiryYear);
    }

    public boolean validateCard() {
        boolean validation = true;

        if (!isValidExpirationDate()) {
            validation = false;
            System.out.println("Invalid Expiry Date.");
        }

        if (!isValidLength()) {
            validation = false;
            System.out.println("Invalid Number Length.");
        }

        if (!isValidPrefix()) {
            validation = false;
            System.out.println("Invalid Number Prefix.");
        }

        if (!isValidCardNumber()) {
            validation = false;
            System.out.println("Invalid Valid Card Number.");
        }

        if (!isValidCheckSum()) {
            validation = false;
            System.out.println("Invalid Check Sum.");
        }

        if (!isAccountInGoodStand()) {
            validation = false;
            System.out.println("Account is not in good stand.");
        }

        if (!validation) System.out.println("This credit card is invalid.");
        else System.out.println("This credit card is valid.");

        return validation;
    }

    private boolean isValidExpirationDate() {
        Date date = new Date();

        return expiryYear < date.getYear() || expiryMonth < date.getMonth();
    }

    abstract boolean isValidLength();

    private boolean isValidCardNumber() {
        for (int i = 0; i < cardNum.length(); i++) {
            if (!Character.isDigit(cardNum.charAt(i))) return false;
        }

        return true;
    }

    abstract boolean isValidPrefix();

    private boolean isValidCheckSum() {
        boolean result = true;
        int sum = 0;
        int multiplier = 1;
        int strLen = cardNum.length();
        for (int i = 0; i < strLen; i++) {
            String digit = cardNum.substring(strLen - i - 1, strLen - i);
            int currProduct = new Integer(digit).intValue() * multiplier;
            if (currProduct >= 10)
                sum += (currProduct % 10) + 1;
            else
                sum += currProduct;
            if (multiplier == 1)
                multiplier++;
            else multiplier--;
        }
        if ((sum % 10) != 0)
            result = false;
        return result;
    }

    abstract boolean isAccountInGoodStand();

}
