import java.util.*;
class ShoppingCart {
    //using hashmap for storing key value pairs 
    private Map<String, CartItem> cartItems = new HashMap<>();
// add to cart method is used to store the product and productname and product quantity in cartitem hashmap
    public void addToCart(Product product, int quantity) {
        String productName = product.getName();
        if (cartItems.containsKey(productName)) {//productname is the key here 
            CartItem existingItem = cartItems.get(productName);
            //check whether the key is already present if already present the value gets incremented by quantity 
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            //orlese just the new productkey and its product ,value quantity 
            cartItems.put(productName, new CartItem(product, quantity));
           
        }
    }
//customer removes the product using product key 
    public void removeFromCart(String productName) {
        cartItems.remove(productName);
    }

    public double calculateTotalBill() {
        double totalBill = 0;
        //calculating the total bill by adding the values of hashmap that is productsand quantity
        for (CartItem cartItem : cartItems.values()) {
            totalBill += cartItem.getTotalPrice();
        }
        return totalBill;
    }
    //it helps in traversing the values of hash map

    public void displayCart() {
        System.out.println("Cart Items:");
        for (CartItem cartItem : cartItems.values()) {
            System.out.println("Product: " + cartItem.getProduct().getName() + ", Quantity: " + cartItem.getQuantity());
        }
    }
}


