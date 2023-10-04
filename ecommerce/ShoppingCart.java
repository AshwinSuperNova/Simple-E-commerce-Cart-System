import java.util.*;
class ShoppingCart {
    private Map<String, CartItem> cartItems = new HashMap<>();

    public void addToCart(Product product, int quantity) {
        String productName = product.getName();
        if (cartItems.containsKey(productName)) {
            CartItem existingItem = cartItems.get(productName);
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            cartItems.put(productName, new CartItem(product, quantity));
        }
    }

    public void removeFromCart(String productName) {
        cartItems.remove(productName);
    }

    public double calculateTotalBill() {
        double totalBill = 0;
        for (CartItem cartItem : cartItems.values()) {
            totalBill += cartItem.getTotalPrice();
        }
        return totalBill;
    }

    public void displayCart() {
        System.out.println("Cart Items:");
        for (CartItem cartItem : cartItems.values()) {
            System.out.println("Product: " + cartItem.getProduct().getName() + ", Quantity: " + cartItem.getQuantity());
        }
    }
}


