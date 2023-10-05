

public class Product {
    private String name;
    private double price;
    private boolean available;
//using the constructor name ,price ,boolean is stored in the private variable 
//which are only accessible within the class
    public Product(String name, double price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }
//using getters method() for getname
    public String getName() {
        return name;
    }
//using getters method() for getprice 
    public double getPrice() {
        return price;
    }
//using getters method() for boolean is it availabale or not
    public boolean isAvailable() {
        return available;
    }
}
