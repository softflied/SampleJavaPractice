import java.util.ArrayList;

public class InventoryMenu extends Operation {


    public InventoryMenu(ArrayList<String> productNameList, ArrayList<Integer> productIDList, ArrayList<Integer> productAmountList, ArrayList<Integer> productPurchaseList, ArrayList<Integer> productSellingList) {
       super(productNameList,productIDList,productAmountList,productPurchaseList,productSellingList);
    }




    @Override
    public void addProduct()
    {


        printAll();
        System.out.print("Which product do you want to add: ");
        String name = scan.next();

        if(!productNameList.contains(name))
        {

            productName=name;
            System.out.print("Type the ID of the product you want to add: ");
            productId=scan.nextInt();
            System.out.print("Type the Quantity of the product you want to add: ");
            productAmount=scan.nextInt();
            System.out.print("Type the purchase Price of the product you want to add: ");
            purchasePrice= scan.nextInt();;
            System.out.print("Type the selling Price of the product you want to add: ");
            sellingPrice = scan.nextInt();



            storeProduct();
            System.out.println("The product has been successfully added");

            String str = "add,"+productId+","+productAmount+","+ getDate()+","+getHours();
            write.writeTransactions(str);



        }
        else
        {
            System.out.println("The product already exists, please try again!!");
        }


    }

    @Override
    public void remove()
    {
        System.out.print("please write the Id of the product you want to delete: ");
        int Id = scan.nextInt();

        int index =productIDList.indexOf(Id);

        productNameList.remove(index);
        productIDList.remove(index);
        productAmountList.remove(index);
        productPurchaseList.remove(index);
        productSellingList.remove(index);

        System.out.println("The product has been successfully removed");

        String str = "remove,"+productIDList.get(index)+","+ productAmountList.get(index)+"," + getDate()+","+getHours();
        write.writeTransactions(str);


    }

    @Override
    public void update()
    {
        System.out.print("Please enter the Id of the product you want to update:");
        int Id = scan.nextInt();
        int index = productIDList.indexOf(Id);



        System.out.println("please enter the new quantity of the product you want to update: ");
        productAmount = scan.nextInt();
        productAmountList.set(index,productAmount);


        System.out.println("The product has been successfully updated");

        String str = "update,"+productIDList.get(index)+","+productAmount+","+ getDate()+","+getHours();
        write.writeTransactions(str);

    }

    @Override
    public void printAll()
    {

        if(!productNameList.isEmpty())
        {
            for(int i=0;i<productNameList.size();i++)
            {
                System.out.print("[");
                System.out.print(productNameList.get(i));
                System.out.print("]");
                System.out.print("\n");
            }

        }
        else
        {
            System.out.println("There is no item, please add any item..");
        }


    }
}
