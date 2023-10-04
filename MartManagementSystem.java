import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

class Product {
    private String name;
    private double price;
    private boolean available;

    public Product(String name, double price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }
}

class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}

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

public class MartManagementSystem {
    private String customerName;
    private String address;
    private int maxItemLimit = 5;
    private int totalItemInCart;
    private ArrayList<String> itemInCart = new ArrayList<>();
    private ArrayList<Integer> priceAfterPurchase = new ArrayList<>();
    private ProductList list = new ProductList();
    private Map<String, String> registeredCustomers = new HashMap<>(); // Stores registered customers' usernames and passwords
    private ShoppingCart cart = new ShoppingCart(); // Shopping cart for customers

    public MartManagementSystem() {
    }

    public MartManagementSystem(int max) {
        this.maxItemLimit = max;
    }

    interface MartI {
        void admin();

        int stock();

        void customer();

        void cart();

        void bill();

        void customerRecord();
    }

    class MMSystem extends MartManagementSystem implements MartI {

        @Override
        public void customer() {
            System.out.println("======= Mart Management System =======\n");
            System.out.println("View as a customer\n");
            System.out.println("\tChoose Option: \n\t1: Purchase\n\t2: Go to Cart\n\t3: Bill\n\t99: Back");
            System.out.println("================ Mart Management System =================\n");
            System.out.print("Enter: ");
            Scanner customerInput = new Scanner(System.in);
            int customerIn = customerInput.nextInt();

            if (customerIn == 1) {
                System.out.println("**** Shop now: ");
                System.out.println("Items available");
                System.out.println("----------------------------------");

                System.out.println("Item no\t\tItem\t\t\tPrice\n");
                for (int i = 0; i < list.product.size(); i++) {
                    System.out.println(i + "\t\t" + list.product.get(i) + "\t\t\t$" + list.productPrices.get(i));
                }
                System.out.println("=========== Purchase start ============");
                Scanner itemPurchase = new Scanner(System.in);
                System.out.println("Number of items you want: ");
                int index_no_item = itemPurchase.nextInt();
                int[] purchasedList = new int[5];

                if (index_no_item <= maxItemLimit) {
                    try {
                        System.out.println("Enter item no: (e.g., for product 1 enter 0, and so on)");
                        for (int i = 0; i < index_no_item; i++) {
                            purchasedList[i] = itemPurchase.nextInt();
                        }
                        totalItemInCart = index_no_item;
                        System.out.println("-----------------------------------");
                        System.out.println("Below items placed in the cart:");
                        System.out.println("Items in Cart: " + index_no_item);
                        System.out.println("-----------------------------------");
                        for (int i = 0; i < index_no_item; i++) {
                            System.out.println(purchasedList[i] + ": " + list.product.get(purchasedList[i]) + "\t\t$" + list.productPrices.get(purchasedList[i]));
                            itemInCart.add(i, list.product.get(purchasedList[i]));
                            priceAfterPurchase.add(list.productPrices.get(purchasedList[i]));

                            Product selectedProduct = list.productObjects.get(purchasedList[i]);
                            cart.addToCart(selectedProduct, 1); // Assuming quantity is always 1 for each product
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("--------------------------------------");
                    }
                } else {
                    System.out.println("You can't purchase more than 5 items.");
                }
                System.out.println("Choose:\n\t1: Continue \n\t2: Exit");
                System.out.print("Enter: ");
                Scanner ch = new Scanner(System.in);
                int num = ch.nextInt();
                if (num == 1) {
                    customer();
                } else if (num == 2) {
                    return;
                } else {
                    return;
                }
            } else if (customerIn == 2) {
                System.out.println("********* Your Cart *********");
                System.out.println("-------------------------------");
                cart.displayCart();
                System.out.println("--------------------------------");
                System.out.println("Item Quantity: " + itemInCart.size());
                double sum = 0;
                for (int d : priceAfterPurchase) {
                    sum += d;
                }
                System.out.println("Total Cost: $ " + sum);
                System.out.println("-------------------------------");
                System.out.println("Choose: \n\t1: Manage cart \n\t2: Continue\n\t3: Exit");
                System.out.print("Enter: ");
                Scanner cr = new Scanner(System.in);
                int num = cr.nextInt();
                if (num == 1) {
                    System.out.println("Actions: \n1: Add more items\n2: Remove items");
                    Scanner cartManageInputActionNumber = new Scanner(System.in);
                    int cm = cartManageInputActionNumber.nextInt();
                    if (cm == 1) {
                        System.out.println("Enter item index: ");
                        Scanner add = new Scanner(System.in);
                        int cmm = add.nextInt();
                        for (int i = 0; i < totalItemInCart; i++) {
                            itemInCart.set(i, list.product.get(cmm));
                            priceAfterPurchase.add(list.productPrices.get(cmm));
                        }
                        cart.displayCart();
                    } else if (cm == 2) {
                        // Remove items from cart
                        System.out.println("Enter item index to remove: ");
                        Scanner removeIndex = new Scanner(System.in);
                        int removeIdx = removeIndex.nextInt();
                        if (removeIdx >= 0 && removeIdx < totalItemInCart) {
                            itemInCart.remove(removeIdx);
                            priceAfterPurchase.remove(removeIdx);
                            totalItemInCart--;
                            System.out.println("Item removed from the cart.");
                        } else {
                            System.out.println("Invalid item index.");
                        }
                        cart.displayCart();
                    } else {
                        return;
                    }
                } else if (num == 2) {
                    customer();
                } else if (num == 3) {
                    return;
                } else {
                    return;
                }
            } else if (customerIn == 3) {
                bill();
                System.out.println("Choose: \n\t1: Continue\n\t2: Exit");
                System.out.print("Enter: ");
                Scanner sc = new Scanner(System.in);
                int num = sc.nextInt();
                if (num == 1) {
                    customer();
                } else if (num == 2) {
                    return;
                } else {
                    return;
                }
            } else if (customerIn == 99) {
                main(null);
            } else {
                System.out.println("Please enter correct choice!!");
            }
        }

        private void cart() {
            System.out.println("No \tItems\t\tPrice");
            System.out.println("-----------------------------\n");
            for (int i = 0; i < totalItemInCart; i++) {
                System.out.println(i + "\t" + itemInCart.get(i) + "\t\t$ " + priceAfterPurchase.get(i));
            }
        }

        private void bill() {
            Scanner csName = new Scanner(System.in);
            System.out.print("Name: ");
            customerName = csName.nextLine();
            System.out.print("Address: ");
            address = csName.nextLine();
            System.out.println("********** YOUR BILL **************");
            System.out.println("----------------------------");
            System.out.println("Customer name: " + customerName);
            System.out.println("Customer address: " + address);
            LocalDate date = LocalDate.now();
            System.out.println("Date: " + date);
            LocalTime time = LocalTime.now();
            System.out.println("Time: " + time);
            System.out.println("_________________________");
            cart.displayCart();
            System.out.println("\n-----------------------");
            System.out.println("Total Item: " + itemInCart.size());
            double sum = 0;
            for (int d : priceAfterPurchase) {
                sum += d;
            }
            System.out.println("Total Bill: $ " + sum);
            System.out.println("_______________________");
            System.out.println(".**** THANK YOU *****\n");

            File file = new File("newFile.txt");
            try {
                FileWriter output = new FileWriter(file);
                output.write("------------------------------------\n");
                output.write("Customer name: " + customerName + "\n");
                output.write("Customer address: " + address + "\n");
                output.write("Date & time: " + date + "  " + time + "\n");
                output.write("Quantity: " + itemInCart.size() + "\n");
                output.write("List of purchased items: " + itemInCart + "\n");
                output.write("Total purchase amount: $" + sum + "\n");
                output.write("----------------------------------------\n");
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Choose: \n\t1: Continue \n\t2: Exit");
            System.out.print("Enter: ");
            int num = csName.nextInt();
            if (num == 1) {
                customer();
            } else if (num == 2) {
                return;
            } else {
                System.out.println("Entered incorrect choice.");
            }
        }

        private void customerRecord() {
            char[] array = new char[1000];
            try {
                FileReader input = new FileReader("newFile.txt");
                input.read(array);
                System.out.println("Customer Details: ");
                if (input != null) {
                    System.out.println(array);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class ProductList {
        ArrayList<String> product = new ArrayList<>();
        ArrayList<Integer> productPrices = new ArrayList<>();
        ArrayList<Product> productObjects = new ArrayList<>(); // Stores Product objects

        public ProductList() {
            addProduct("Laptop", 1000, true);
            addProduct("Headphones", 50, true);
        }

        public void addProduct(String name, int price, boolean available) {
            product.add(name);
            productPrices.add(price);
            productObjects.add(new Product(name, price, available));
        }
    }


    public static void main(String[] args) {
        MartManagementSystem mmSystem = new MartManagementSystem();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1: Admin");
            System.out.println("2: Customer Registration");
            System.out.println("3: Customer Login");
            System.out.println("4: Exit");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                  
                    System.out.println("Admin functionality is not implemented yet.");
                    break;
                case 2:
                   
                    System.out.println("***** Customer Registration *****");
                    mmSystem.registerCustomer();
                    break;
                case 3:
                   
                    System.out.println("***** Customer Login *****");
                    mmSystem.customerLogin();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Method to register a new customer
    private void registerCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        registeredCustomers.put(username, password);
        System.out.println("Registration successful!");
    }

    private void customerLogin() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (registeredCustomers.containsKey(username) && registeredCustomers.get(username).equals(password)) {
            MMSystem mmSystem = new MartManagementSystem().new MMSystem();
            mmSystem.customer();
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
