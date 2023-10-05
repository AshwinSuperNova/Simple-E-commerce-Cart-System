import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Customer extends MartManagementSystem {
 
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
                int[] purchasedList = new int[maxItemLimit];

                if (index_no_item <= maxItemLimit) {
                    try {
                        System.out.println("Enter item no: (e.g., for product 1 enter 0, and so on)");
                        for (int i = 0; i < index_no_item; i++) {
                            purchasedList[i] = itemPurchase.nextInt();
                        }
                        totalItemInCart = index_no_item;
                        System.out.println("-----------------------------------");
                        System.out.println("Below items are placed in the cart:");
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
            }else if (customerIn == 2) {
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
                    System.out.println("Choose: \n\t1: Add more items\n\t2: Remove items\n\t3: Continue\n\t4: Exit");
                    System.out.print("Enter: ");
                    Scanner cr = new Scanner(System.in);
                    int num = cr.nextInt();
                    if (num == 1) {
                        //customer adds products to cart
                        System.out.println("Enter item index to add: ");
                        Scanner addItemIndex = new Scanner(System.in);
                        int addItemIdx = addItemIndex.nextInt();
                        if (addItemIdx >= 0 && addItemIdx < list.product.size()) {
                            itemInCart.add(list.product.get(addItemIdx));
                            priceAfterPurchase.add(list.productPrices.get(addItemIdx));
                            Product selectedProduct = list.productObjects.get(addItemIdx);
                            cart.addToCart(selectedProduct, 1); // Assuming quantity is always 1 for each product
                            System.out.println("Item added to the cart.");
                        } else {
                            System.out.println("Invalid item index.");
                        }
                        cart.displayCart();
                 System.out.println("Choose:\n\t1: Continue \n\t2: Exit");
                System.out.print("Enter: ");
                Scanner ch1 = new Scanner(System.in);
                int num1 = ch1.nextInt();
                if (num == 1) {
                    customer();
                } else if (num == 2) {
                    return;
                } else {
                    return;
                }
                    } else if (num == 2) {
                        // Remove items from cart
                        System.out.println("Enter item index to remove: ");
                        Scanner removeItemIndex = new Scanner(System.in);
                        int removeItemIdx = removeItemIndex.nextInt();
                        if (removeItemIdx >= 0 && removeItemIdx < itemInCart.size()) {
                            String removedItem = itemInCart.remove(removeItemIdx);
                            priceAfterPurchase.remove(removeItemIdx);
                            totalItemInCart--;
                            cart.removeFromCart(removedItem);
                            System.out.println("Item removed from the cart.");
                        } else {
                            System.out.println("Invalid item index.");
                        }
                        cart.displayCart();
                System.out.println("Choose:\n\t1: Continue \n\t2: Exit");
                System.out.print("Enter: ");
                Scanner ch4 = new Scanner(System.in);
                int num3 = ch4.nextInt();
                if (num == 1) {
                    customer();
                } else if (num == 2) {
                    return;
                } else {
                    return;
                }
                    } else if (num == 3) {
                        customer();
                    } else if (num == 4) {
                        return;
                    } else {
                        return;
                    }
                }
        
            else if (customerIn == 3) {
               
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
      for (int d : super.priceAfterPurchase) {
          sum += d;
      }
      System.out.println("Total Bill: $ " + sum);
      System.out.println("_______________________");
      System.out.println(".**** THANK YOU *****\n");

      File file = new File("customerrecords.txt");
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
      int num2 = csName.nextInt();
      if (num2 == 1) {
          customer();
      } else if (num2 == 2) {
          return;
      }else if (num2 == 99) {
        return; 
    } else {
          System.out.println("Entered incorrect choice.");
      }
  
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
            

            }else if ( customerIn== 99) {
              return; //calling record method which shows the customer details
          } else {
                System.out.println("Please enter correct choice!!");
            }
        

        }
    }


