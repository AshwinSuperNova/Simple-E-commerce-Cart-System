

public class CartItem {
    
    private Product product;
    private int quantity;
    //using constructor of  product is used   to store the product
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
//using getters method for getting the product (encapsulation)
    public Product getProduct() {
        return product;
    }
//using getters method for getting the product 
    public int getQuantity() {
        return quantity;
    }
//using setters method for setting the product quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
//using getters method for getting the producttotal price
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}
