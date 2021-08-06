public class TestCardValidation {
    public static void main(String[] args) {
        CreditCard card = new VisaCard("1234123412341234", 11, 2004);

        System.out.println(card.toString());
        card.validateCard();
        System.out.println();

        card = new VisaCard("1234567890123456", 11, 2020);
        System.out.println(card.toString());
        card.validateCard();
        System.out.println();

        card = new VisaCard("4234567890123456", 11, 2020);
        System.out.println(card.toString());
        card.validateCard();
        System.out.println();

        card = new MasterCard("5448755330349315", 4, 2021);
        System.out.println(card.toString());
        card.validateCard();
        System.out.println();

        card = new DinersClubCard("30263720264678", 5, 2025);
        System.out.println(card.toString());
        card.validateCard();
        System.out.println();
    }
}
