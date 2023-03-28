import java.util.ArrayList;

public class ProductMenu extends Operation {

    public ProductMenu(ArrayList<String> productNameList, ArrayList<Integer> productIDList, ArrayList<Integer> productAmountList, ArrayList<Integer> productPurchaseList, ArrayList<Integer> productSellingList) {
        super(productNameList,productIDList,productAmountList,productPurchaseList,productSellingList);
    }

    public void update()
    {
        System.out.print("Please enter the Id of the product you want to update: ");
        int Id = scan.nextInt();
        int index = productIDList.indexOf(Id);

        System.out.println("please enter the new name of the product you want to update: ");
        productName = scan.next();
        productNameList.set(index,productName);

        System.out.println("Please enter the new purchase price of the product you want to update: ");
        purchasePrice = scan.nextInt();
        productPurchaseList.set(index,purchasePrice);

        System.out.println("Please enter the new selling price of the product you want to update: ");
        sellingPrice = scan.nextInt();
        productSellingList.set(index,sellingPrice);

        String str = "update,"+productIDList.get(index)+","+productAmount+","+ getDate()+","+getHours();
        write.writeTransactions(str);

    }

    public void remove()
    {
        System.out.print("please write the Id of the product you want to delete:");
        int Id = scan.nextInt();

        int index =productIDList.indexOf(Id);
        String str = "remove,"+productIDList.get(index)+","+ productAmountList.get(index)+","+ getDate()+","+getHours();
        write.writeTransactions(str);


        productNameList.remove(index);
        productIDList.remove(index);
        productAmountList.remove(index);
        productPurchaseList.remove(index);
        productSellingList.remove(index);



    }

    public void addProduct()
    {
        System.out.print("Type the name of the product you want to add: ");
        productName=scan.next();
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

        String str = "buy,"+productId+","+ productAmount+","+ getDate()+","+getHours();
        write.writeTransactions(str);
    }

    public void printAll()
    {

        if(!productNameList.isEmpty())
        {

            System.out.println("------------------------------------------------------");
            for(int i=0;i<productNameList.size();i++)
            {

                System.out.print("Name: "+productNameList.get(i)+" - Id: "+productIDList.get(i)+" - Amount: "+productAmountList.get(i)+" - Purchase price: "+productPurchaseList.get(i)+" - Selling price: "+productSellingList.get(i));

                System.out.print("\n");


            }
            System.out.println("-------------------------------------------------------");


        }
        else
        {
            System.out.println("There is no item, please add any item..");
        }


    }



}
