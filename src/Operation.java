import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Operation {


    Scanner scan = new Scanner(System.in);
    public String productName;
    public int productId;
    public int productAmount;
    public int purchasePrice,sellingPrice;

    Write write = new Write();



    ArrayList<String> productNameList = new ArrayList<>();
    ArrayList<Integer> productIDList = new ArrayList<>();
    ArrayList<Integer> productAmountList = new ArrayList<>();
    ArrayList<Integer> productPurchaseList = new ArrayList<>();
    ArrayList<Integer> productSellingList = new ArrayList<>();

    public Operation(ArrayList<String> productNameList, ArrayList<Integer> productIDList, ArrayList<Integer> productAmountList, ArrayList<Integer> productPurchaseList, ArrayList<Integer> productSellingList) {
        this.productNameList = productNameList;
        this.productIDList = productIDList;
        this.productAmountList = productAmountList;
        this.productPurchaseList = productPurchaseList;
        this.productSellingList = productSellingList;
    }

    public void printAll()
    {

        if(!productNameList.isEmpty())
        {

            System.out.println("------------------------------------------------------");
            for(int i=0;i<productNameList.size();i++)
            {

                System.out.print("Name: "+productNameList.get(i)+" - ID: "+productIDList.get(i)+" - amount: "+productAmountList.get(i)+" - purchase: "+productPurchaseList.get(i)+" - selling: "+productSellingList.get(i));

                System.out.print("\n");


            }
            System.out.println("-------------------------------------------------------");


        }
        else
        {
            System.out.println("market boş. ");
        }


    }

    public String getDate()
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        return format.format(date);
    }

    public String getHours()
    {
        SimpleDateFormat format = new SimpleDateFormat("k:m:s");
        Date hour = new Date();

        return format.format(hour);
    }


    public void addProduct()
    {
    }


    public void remove()
    {

        System.out.println("error");


    }




    public void update()
    {
        System.out.println("error");
    }



    public void storeProduct()
    {

        productNameList.add(productName);
        productIDList.add(productId);
        productAmountList.add(productAmount);
        productPurchaseList.add(productAmount);
        productSellingList.add(sellingPrice);


    }








    public void print(){

        String str="";
        for (int i =0;i<productNameList.size();i++)
        {
            str= str+"Name: "+productNameList.get(i)+" Id: "+productIDList.get(i)+" Amount: "+productAmountList.get(i)+" Purchase price: "+productPurchaseList.get(i)+" Selling price: "+productSellingList.get(i);
            str=str+"\n";
        }
        write.writeProduct(str);

        String str2="";
        for (int i =0;i<productNameList.size();i++)
        {
            str2= str2+"Id: "+productIDList.get(i)+" Amount: "+productAmountList.get(i);
            str2=str2+"\n";
        }
        write.writeInventor(str2);





    }


}
