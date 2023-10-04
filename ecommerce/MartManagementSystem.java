import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
public class MartManagementSystem  {
     String customerName;
    String address;
    int maxItemLimit = 5;
     int totalItemInCart;
     ArrayList<String> itemInCart = new ArrayList<>();
     ArrayList<Integer> priceAfterPurchase = new ArrayList<>();
     ProductList list = new ProductList();
     Map<String, String> registeredCustomers = new HashMap<>(); // Stores registered customers' usernames and passwords
   ShoppingCart cart = new ShoppingCart(); // Shopping cart for customers

    public MartManagementSystem() {
    }

    public MartManagementSystem(int max) {
        this.maxItemLimit = max;
    }

    protected void registerCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        registeredCustomers.put(username, password);
        System.out.println("Registration successful!");
    }
     


    protected void customerLogin() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (registeredCustomers.containsKey(username) && registeredCustomers.get(username).equals(password)) {
           Customer customer=new Customer();
            customer.customer();
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
