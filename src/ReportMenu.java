import java.util.ArrayList;
import java.util.Scanner;

public class ReportMenu extends Operation {

    public ReportMenu(ArrayList<String> productNameList, ArrayList<Integer> productIDList, ArrayList<Integer> productAmountList, ArrayList<Integer> productPurchaseList, ArrayList<Integer> productSellingList) {
        super(productNameList,productIDList,productAmountList,productPurchaseList,productSellingList);
    }
    ArrayList<String> transactionList = new ArrayList<>();
    ArrayList<String> operationName = new ArrayList<>();
    ArrayList<String> quantity = new ArrayList<>();
    ArrayList<String> Id = new ArrayList<>();
    ArrayList<String> timeList = new ArrayList<>();
    ArrayList<String> year = new ArrayList<>();
    Read read = new Read();
    Scanner scan = new Scanner(System.in);


    public void callRead()
    {
        read.readTransactions(transactionList,timeList,operationName,Id, quantity,year);
    }

    public void clearList()
    {
        transactionList.clear();
        timeList.clear();
        operationName.clear();
        Id.clear();
        quantity.clear();
        year.clear();
    }

    public void Option1() {

        callRead();

        System.out.print("Please add two time periods: ");
        int firstTime = scan.nextInt();
        int secondTime = scan.nextInt();


        for(int i=0;i<transactionList.size();i++)
        {
            int currentHour = Integer.parseInt(timeList.get(i).split(":")[0]);
            if(transactionList.get(i).split(",")[0].equals("sale"))
            {
                if(firstTime<=currentHour && currentHour<=secondTime)
                {
                    int id = Integer.parseInt(transactionList.get(i).split(",")[1]);
                    int index =productIDList.indexOf(id);
                    System.out.println(productNameList.get(index));
                }


            }
        }

        clearList();

    }

    public void Option2() {
        callRead();

        if (transactionList.isEmpty())
            System.out.println("There is no data");
        else
        {


            int max = 0, index = 0, amount = 0, j;
            boolean result = false;

            for (int i = 0; i < Id.size(); i++) {
                if (operationName.get(i).equals("sale")) {
                    amount = Integer.parseInt(quantity.get(i));
                    for (j = i + 1; j < Id.size(); j++) {
                        if (Id.get(i).equals(Id.get(j))) {
                            amount += Integer.parseInt(quantity.get(j));
                        }
                    }
                    if (amount > max) {
                        max = amount;
                    }
                    result = true;
                }
            }


            if (result) {

                    System.out.println("Product's name: " + productNameList.get(index));
                }

             else {
                System.out.println("No products were sold in the specified range.");
            }
        }
        clearList();
        }

    public void Option3() {

        callRead();
        if (transactionList.isEmpty()) {
            System.out.println("There is no data");
        } else {

            boolean result = false;
            int fTime;
            int sTime;
            System.out.print("Please enter the start and end Month (Jan, Feb, Mar, Apr, May, June, July, Aug, Sep, Oct, Nov, Dec): ");
            String firstTime = scan.next();
            String secondTime = scan.next();

            fTime = returnMonth(firstTime);
            sTime = returnMonth(secondTime);

            for (int i = 0; i < Id.size(); i++) {
                int month = Integer.parseInt(year.get(i).split("/")[1]);
                if (fTime >= month || month <= sTime) {
                    if (operationName.get(i).equals("sale")) {

                        int id = Integer.parseInt(transactionList.get(i).split(",")[1]);
                        int index =productIDList.indexOf(id);
                            System.out.println("***" + productNameList.get(index) + "***");
                            result = true;
                    }
                }
            }

            if (!result) {
                System.out.println("Sold product not found...");
            }
        }

        clearList();
    }

    public int returnMonth(String month) {
        int time;
        switch (month) {
            case "Jan": time = 1;
            break;
            case "Feb":  time = 2;
            break;
            case "Mar": time = 3;
            break;
            case "Apr":  time = 4;
            break;
            case "May":  time = 5;
            break;
            case "June": time = 6;
            break;
            case "July":  time = 7;
            break;
            case "Aug":  time = 8;
            break;
            case "Sep":  time = 9;
            break;
            case "Oct":  time = 10;
            break;
            case "Nov": time = 11;
            break;
            case "Dec": time = 12;
            break;
            default:  time = 0;
        }
        return time;
    }

    public void Option4() {
        callRead();

        boolean result = false;
        if (operationName.isEmpty()) {
            System.out.println("There is no data");
        } else {
            int dateTime;

            System.out.println("Please enter the day(1, 2, 3, etc)");
            dateTime = scan.nextInt();

            for (int i = 0; i < operationName.size(); i++) {
                int day = returnDay(year.get(i).split("/")[0]);
                if (day == dateTime) {
                    if (operationName.get(i).equals("sale")) {
                            result = true;
                        int id = Integer.parseInt(transactionList.get(i).split(",")[1]);
                        int index =productIDList.indexOf(id);

                            System.out.println("***" + productNameList.get(index) + "***");
                        }
                    }
                }
            }

            if (!result) {
                System.out.println("error!!");
            }
        clearList();

    }

    public int returnDay(String day) {
        int time;

        if(day.charAt(0)==0)
        {
            time = Integer.parseInt(String.valueOf(day.charAt(1)));
        }
        else
            time = Integer.parseInt(day);


        return time;
    }


}
