import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Bill extends MartManagementSystem {
  Customer customer=new Customer();
  public void bill() {
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
          customer.customer();
      } else if (num == 2) {
          return;
      }else if (num == 99) {
        return; //calling record method which shows the customer details
    } else {
          System.out.println("Entered incorrect choice.");
      }
  }

}
