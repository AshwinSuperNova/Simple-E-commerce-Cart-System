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
   protected  void cart() {
      System.out.println("No \tItems\t\tPrice");
      System.out.println("-----------------------------\n");
      for (int i = 0; i < totalItemInCart; i++) {
          System.out.println(i + "\t" + itemInCart.get(i) + "\t\t$ " + priceAfterPurchase.get(i));
      }
  }
  protected void customerRecord() {
    char[] array = new char[1000];
    try {
        FileReader input = new FileReader("customerrecords.txt");
        input.read(array);
        System.out.println("Customer Details: ");
        if (input != null) {
            System.out.println(array);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    protected void registerCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();
         System.out.print("conform password: ");
        String conformpassword = input.nextLine();
        if(password.equals(conformpassword)){
        registeredCustomers.put(username, password);
        System.out.println("Registration successful!");
        }
    }
      protected void AdminLogin() {
        Scanner input1 = new Scanner(System.in);
       
        System.out.print("Enter password: ");
         String adminpassword = input1.nextLine();

        if (adminpassword.equals("admin")) {
           Admin admin=new Admin();
           admin.admin();
        } else {
            System.out.println("Invalid admin  password.");
        }
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
