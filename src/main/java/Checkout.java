public class Checkout {

    private static final String APPLE = "apple";
    private static final String ORANGE = "orange";
    private static final double applePrice = 0.60;
    private static final double orangePrice = 0.25;
    private double totalPrice;

    public double calculateTotalCostOfFruit(String[] shoppingList) {

        for (String item : shoppingList) {
            item = item.toLowerCase();

            switch (item) {
                case ORANGE:
                    processOrange();
                    break;
                case APPLE:
                    processApple();
                    break;
                default:
                    throw new ProductUnavailableException(item + " is not a valid product");
            }
        }
        return totalPrice;
    }

    private void processApple() {
        totalPrice += applePrice;
    }

    private void processOrange() {
        totalPrice += orangePrice;
    }
}
