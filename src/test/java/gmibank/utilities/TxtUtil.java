package gmibank.utilities;

import gmibank.pojo.Country;
import gmibank.pojo.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtUtil {


    public static List<String []> getAllLines () {
        List<String[]> list = new ArrayList<String[]>();
        String fileName = "/Users/ibrahimkalin/IdeaProjects/gmiapplication/data.txt";
        File file = new File(fileName);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            //process the line
//            System.out.println(line);
            line = line.replace("|", "");
            String[] eachLine = line.split(",");
            if (line.length() > 0)
                list.add(eachLine);

        }
        return list;
    }


    public static void saveAllCountry(String fileNname, Country[] country) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileNname, true));
            for (int i=0 ; i<country.length;i++) {
                writer.append(country[i].getName() + ",\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveCustomerId(String fileNname, List<Object> list) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileNname, true));
            for (int i=0 ; i<list.size();i++)
                writer.append(list.get(i)+",\n");

                writer.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<String> returnCustomerSSNList(String filePath) {
        List<String> all = new ArrayList<>();
        try {


            BufferedReader br = new BufferedReader(new FileReader(filePath));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println("line = " + line);

            int i = 0;
            while (line != null) {
                Customer customer = new Customer();
                customer.setSsn(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println("i = " + i++);

                all.add(customer.getSsn());
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
            return all;
    }
}
