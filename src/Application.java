import java.util.ArrayList;
import java.util.Scanner;

public class Application{

    ArrayList<String> productNameList = new ArrayList<>();
    ArrayList<Integer> productIDList = new ArrayList<>();
    ArrayList<Integer> productAmountList = new ArrayList<>();
    ArrayList<Integer> productPurchaseList = new ArrayList<>();
    ArrayList<Integer> productSellingList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    Read read = new Read();

    Operation operation = new Operation(productNameList,productIDList,productAmountList,productPurchaseList,productSellingList);
    InventoryMenu operation1 = new InventoryMenu(productNameList,productIDList,productAmountList,productPurchaseList,productSellingList);
    ProductMenu operation2 = new ProductMenu(productNameList,productIDList,productAmountList,productPurchaseList,productSellingList);
    sellProductMenu operation3 = new sellProductMenu(productNameList,productIDList,productAmountList,productPurchaseList,productSellingList);
    ReportMenu operation4 = new ReportMenu(productNameList,productIDList,productAmountList,productPurchaseList,productSellingList);



    public void mainMenu()  {

        int answer =0;
        do {

            System.out.println("\nMain menu("+operation.getDate()+" "+operation.getHours()+")");
            System.out.print("1. Sell Product\n" +
                    "2. Manage Inventory\n" +
                    "3. Manage Products\n" +
                    "4. Reports\n" +
                    "5. Exit\n");
            Scanner scan = new Scanner(System.in);
            answer = scan.nextInt();

            switch (answer){
                case 1:
                    operation3.sellProduct();
                    break;
                case 2:
                    inventoryMenu();
                    break;
                case 3:
                    productMenu();
                    break;
                case 4:
                    reportMenu();
                    break;
                case 5:
                    operation.print();
                    System.out.println("GoodBye...");
                default:
                    System.out.println("please make the right choice!!");

            }



        }while (answer!=5);
    }

    public void productMenu()
    {
        int answer =0;
        do {

            System.out.println("\nProduct Menu");
            System.out.print("1. Print all products\n" +
                    "2. Add new Product\n" +
                    "3. Remove Product\n" +
                    "4. Update Product\n" +
                    "5. Return to Main Menu\n");



            answer = scan.nextInt();

            switch (answer){
                case 1:
                    operation2.printAll();
                    break;
                case 2:
                    operation2.addProduct();
                    break;
                case 3:
                    operation2.remove();
                    break;
                case 4:
                    operation2.update();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("please make the right choice!!");

            }



        }while (answer!=5);
    }

    public void inventoryMenu()
    {
        int answer = 0;
        do {

            System.out.println("\nInventory Menu");
            System.out.print("1. Add (buy) Product\n" +
                    "2. Update Product in Inventory\n" +
                    "3. Delete Product from Inventory\n" +
                    "4. Return to Main Menu\n");
            Scanner scan = new Scanner(System.in);
            answer = scan.nextInt();

            switch (answer) {
                case 1:
                    operation1.addProduct();
                    break;
                case 2:
                    operation1.update();
                    break;
                case 3:
                    operation1.remove();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("please make the right choice!!");

            }


        } while (answer != 4);
    }

    public void reportMenu()  {
        int answer =0;
        do {

            System.out.print("\nReport Menu\n" +
                    "1. Print a list of product names that are sold between two time period\n" +
                    "2. Print the name of the Best Selling Product\n" +
                    "3. Print list of products sold on specified Month (Jan, Feb, etc.)\n" +
                    "4. Print all products sold on specified week day (Mon, Tue, Wed, etc.)\n" +
                    "5. Return to Main Menu\n");



            answer = scan.nextInt();

            switch (answer){
                case 1:
                    operation4.Option1();
                    break;
                case 2:
                    operation4.Option2();
                    break;
                case 3:
                    operation4.Option3();
                    break;
                case 4:
                    operation4.Option4();
                    break;
                default:
                    System.out.println("please make the right choice!!");

            }



        }while (answer!=5);
    }

}
