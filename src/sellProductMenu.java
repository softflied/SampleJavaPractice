import java.util.ArrayList;

public class sellProductMenu extends Operation {
    public sellProductMenu(ArrayList<String> productNameList, ArrayList<Integer> productIDList, ArrayList<Integer> productAmountList, ArrayList<Integer> productPurchaseList, ArrayList<Integer> productSellingList) {
        super(productNameList,productIDList,productAmountList,productPurchaseList,productSellingList);
    }

    public void sellProduct()
    {
        printAll();

        if(!productNameList.isEmpty())
        {
            System.out.print("Which product do you want to sell:");
            String name = scan.next();

            System.out.print("how many you want to sell:");
            int amount = scan.nextInt();

            int index =productNameList.indexOf(name);

            if(productAmountList.get(index)>=amount)
            {
                productAmountList.set(index,productAmountList.get(index)-amount);

                System.out.println("The product has been successfully sold");

                String str = "sale,"+productIDList.get(index)+","+amount+","+ getDate()+","+getHours();
                write.writeTransactions(str);
            }
            else
                System.out.println("Failed to sell...");



        }

    }
}
