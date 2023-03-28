import java.io.*;


public class Write {

    public void writeProduct(String str) {
        BufferedWriter bufferedWriter;
        try {
            FileWriter fileWriter = new FileWriter("product.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (Exception e) {

        }


    }

    public void writeInventor(String str) {
        BufferedWriter bufferedWriter;
        try {
            FileWriter fileWriter = new FileWriter("Inventory.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {

        }


    }

    BufferedWriter bufferedWriter;

    public void writeTransactions(String str) {


        try {
            BufferedReader reader = new BufferedReader(new FileReader("Transactions.txt"));


            if (reader.readLine() == null) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Transactions.txt"));
                writer.write("Operation,0,0,0/0/0,0:0:0");
                writer.newLine();
                writer.close();
            }


            FileWriter fileWriter = new FileWriter("Transactions.txt", true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
