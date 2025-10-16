public class Cart implements HotelService {
    public void executeService(String numberOfCarts) {
        requestCart(Integer.parseInt(numberOfCarts));
    }

    private void requestCart(String numberOfCarts) {
        System.out.println("Cart service: Delivering " + numberOfCarts + " luggage cart(s)");
    }
}