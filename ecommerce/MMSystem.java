 
 import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
 public class MMSystem extends MartManagementSystem {

        
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
                    
                  mmSystem.AdminLogin();
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

       

      

        
    }
