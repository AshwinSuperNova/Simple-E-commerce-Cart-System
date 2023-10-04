import java.util.Scanner;

public class Customer extends MartManagementSystem {
  Bill b1=new Bill();
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
                b1.bill();
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
