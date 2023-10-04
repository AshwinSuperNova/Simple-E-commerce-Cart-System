import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
 public class ProductList {
        ArrayList<String> product = new ArrayList<>();
        ArrayList<Integer> productPrices = new ArrayList<>();
        ArrayList<Product> productObjects = new ArrayList<>(); // Stores Product objects

        public ProductList() {
          // Initialize the list with some default products
          addProduct("Laptop", 1000, true);
          addProduct("Headphones", 50, true);
      
          // Add more products
          addProduct("Smartphone", 800, true);
          addProduct("Tablet", 400, true);
          addProduct("Smartwatch", 150, true);
          addProduct("Gaming Console", 300, true);
          addProduct("Digital Camera", 250, true);
          addProduct("Bluetooth Speaker", 60, true);
          
          // Add more products
          addProduct("Desktop Computer", 1200, true);
          addProduct("Wireless Earbuds", 80, true);
          addProduct("Fitness Tracker", 70, true);
          addProduct("VR Headset", 200, true);
          addProduct("Coffee Maker", 40, true);
          addProduct("External Hard Drive", 100, true);
          
          // Add more products
          addProduct("Smart TV", 600, true);
          addProduct("Printer", 150, true);
          addProduct("Vacuum Cleaner", 120, true);
          addProduct("Toaster", 30, true);
          addProduct("Microwave Oven", 120, true);
          
          // Add more products
          addProduct("Refrigerator", 500, true);
          addProduct("Blender", 40, true);
          addProduct("Electric Kettle", 20, true);
          addProduct("Air Purifier", 90, true);
          addProduct("Robot Vacuum Cleaner", 250, true);
          
          // Add more products
          addProduct("Gaming Laptop", 1500, true);
          addProduct("Drones", 250, true);
          addProduct("Digital Thermometer", 15, true);
          addProduct("Smart Home Hub", 100, true);
          addProduct("Desk Chair", 80, true);
      }
      

        public void addProduct(String name, int price, boolean available) {
            product.add(name);
            productPrices.add(price);
            productObjects.add(new Product(name, price, available));
        }
    }