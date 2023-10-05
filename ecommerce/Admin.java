import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Admin extends MartManagementSystem {

    private int stock() {
      System.out.println("****** Full Stock details ************");
      System.out.println("Total Products: " + list.product.size());
      int sum = 0;
      for (int d : list.productPrices) {
          sum += d;
      }
      System.out.println("Total Mart Cost: $ " + sum);
      System.out.println("_____________________________________________________");
      System.out.println("Item no\t\tItem\t\t\tPrice\n");
      for (int i = 0; i < list.product.size(); i++) {
          System.out.println(i + "\t\t" + list.product.get(i) + "\t\t\t$" + list.productPrices.get(i));
      }
      System.out.println("-------------------------------------------");
      return sum;
  }
   public void admin() {
            System.out.println("======= Mart Management System =======\n");
            System.out.println("View as an Admin\n");
            System.out.println("\tChoose Option: \n\t1: Add Item(s)\n\t2: Update Existing Item\n\t3: Remove Item\n\t4: View Stock\n\t5: Customer Record\n\t99: Exit");
            Scanner inputAdmin = new Scanner(System.in);
            System.out.print("Enter: ");
            int adminInput = inputAdmin.nextInt();

            if (adminInput == 1) {
                // items are added by admin
                System.out.println("Product name & price");
                Scanner newPro = new Scanner(System.in);
                System.out.print("Name: ");
                String newName = newPro.nextLine();
                list.product.add(newName);
                System.out.print("Price: ");
                int newPrice = newPro.nextInt();
                list.productPrices.add(newPrice);
                System.out.println("Item added successfully");
                admin();
            } else if (adminInput == 2) {
                // items are updated here by admin
                Scanner change = new Scanner(System.in);
                System.out.print("Index no: ");
                int index = change.nextInt();
                System.out.print("Product name: ");
                String name = change.next();
                System.out.print("Price: ");
                int price = change.nextInt();
                list.product.set(index, name);
                list.productPrices.set(index, price);
                System.out.println("*** Item updated successfully ***");
                admin();
            } else if (adminInput == 3) {
                // items are removed by admin
                Scanner remove = new Scanner(System.in);
                System.out.print("Item index no: ");
                int removeItem = remove.nextInt();
                list.product.remove(removeItem);
                list.productPrices.remove(removeItem);
                System.out.println("Item removed successfully");
                admin();
            } else if (adminInput == 4) {
                // stocks are viewed by admin
                stock();
                System.out.println("Choose:\n\t1: Continue \n\t2: Exit");
                System.out.print("Enter: ");
                Scanner cr = new Scanner(System.in);
                int num = cr.nextInt();
                if (num == 1) {
                    admin();
                } else if (num == 2) {
                    return;
                } else {
                    return;
                }
            } else if (adminInput == 5) {
                customerRecord(); 
                //admin calls customer record method to know  which shows the customer details
            }else if (adminInput == 99) {
                return; 
            } else {
                System.out.println("Please enter the correct choice!!");
                admin();
            }
        }
}
