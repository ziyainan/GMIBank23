package gmibank.utilities;

import gmibank.pojos.Country;
import gmibank.pojos.Customer;
import gmibank.pojos.States;

import java.io.*;

public class WriteToTxt {
    public static void saveDataInFile(String fileName, Customer customers[])  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            for (int i = 0; i < customers.length; i++) {
                writer.append(customers[i].getSsn() + "\n");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }public static void saveDataInFileWithSsn(String fileName, Customer customer)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            writer.append(customer.getSsn());
            writer.close();
        } catch(Exception e){
        }
    }


    public static void saveDataInFileWithAllCustomerInfo(String fileName, Customer[] customers)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            for (int i=0; i<customers.length;i++){
                writer.append(customers[i].getFirstName()+" , "+customers[i].getLastName()+"\n");
                if(customers[i].getUser() != null)
                    writer.append(customers[i].getUser().getFirstName());
                if(customers[0].getCountry() != null);
             //       writer.append(customers[i].getCountry().getStates());

            }
            writer.close();
        } catch(Exception e){
        }
    }
    //    public static void readDataUsingScanner(String filePath){
//        File file = new File(filePath);
//
//        try {
//
//            Scanner sc = new Scanner(file);
//
//            while (sc.hasNextLine()) {
//                int i = sc.nextInt();
//
//            }
//            sc.close();
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
    public static void saveAllStates(String fileName, States[] states){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            for (int i=0; i<states.length;i++){
                writer.append(states[i].getName()+" , "+states[i].getId()+"\n");

            }
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveAllCountries(String fileName, Country[] countries){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            for (int i=0; i<countries.length;i++){
                writer.append(countries[i].getName()+" , "+countries[i].getId()+"\n");

            }
            writer.close();
        } catch(Exception e){
        }
    }
}

