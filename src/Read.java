import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;



public class Read{



    public void readTransactions(ArrayList<String> transactionsList,ArrayList<String> timeList,ArrayList<String> operationName,ArrayList<String> Id,ArrayList<String> amount,ArrayList<String> year)
    {
        try
        {
            FileReader fileReader = new FileReader("Transactions.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ;

            while ((line = bufferedReader.readLine())!=null && !line.equals(""))
            {
                transactionsList.add(line);
                operationName.add(line.split(",")[0]);
                Id.add(line.split(",")[1]);
                amount.add(line.split(",")[2]);
                year.add(line.split(",")[3]);
                timeList.add(line.split(",")[4]);

            }
        }
        catch (Exception e)
        {

        }
    }





}
