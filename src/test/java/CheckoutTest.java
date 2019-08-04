import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutTest {

    private Checkout checkout;
    private String[] shoppingList;

    @Before
    public void reset(){
        checkout = new Checkout();
        shoppingList = new String[]{};
    }

    @Test
    public void shouldReturnCorrectCostOfApple() {
        shoppingList = new String[]{"apple"};

        assertProductEquals(0.60, checkout.calculateTotalCostOfFruit(shoppingList));
    }

    @Test
    public void shouldReturnCorrectCostWithDifferentFruit() {
        shoppingList = new String[]{"orange", "apple", "orange"};

        assertProductEquals(1.10, checkout.calculateTotalCostOfFruit(shoppingList));
    }

    @Test
    public void shouldReturnCorrectCostOfOrange() {
        shoppingList = new String[]{"Orange", "orange"};

        assertProductEquals(0.50, checkout.calculateTotalCostOfFruit(shoppingList));
    }

    @Test(expected = ProductUnavailableException.class)
    public void shouldThrowExceptionWhenProductIsNotAvailable() {
        shoppingList = new String[] {"Apple", "Peach"};
        checkout.calculateTotalCostOfFruit(shoppingList);
    }

    @Test
    public void shouldReceiveSecondAppleFreeForEachOnePurchased() {
        shoppingList = new String[]{"Apple", "Apple", "Apple", "Apple"};

        assertProductEquals(1.20, checkout.calculateTotalCostOfFruit(shoppingList));
    }

    @Test
    public void shouldReceiveThirdOrangeFree() {
        shoppingList = new String[] {"Orange", "Orange", "orange"};

        assertProductEquals(0.50, checkout.calculateTotalCostOfFruit(shoppingList));
    }

    private void assertProductEquals(double expectedPrice, double actualPrice) {
        assertEquals("Incorrect total price", expectedPrice, actualPrice, 0.004);
    }
}
