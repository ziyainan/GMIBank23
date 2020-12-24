package gmibank.utilities;

import gmibank.pojos;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToTxt {

    public static void saveDataInFile(String fileName, pojos.Customer customer) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append( customer.getFirstName() + " , " + customer.getLastName() + " , " + customer.getSsn()+"\n");
            writer.close();
        } catch (Exception e) {
        }
    }

    public static void saveDataInFilewithSSN(String fileName, pojos.Customer[] customers) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i=0; i<customers.length;i++)
                writer.append( customers[i].getSsn()+"\n");
            writer.close();
        } catch (Exception e) {
        }
    }


    public static void saveDataInFileWithAllCustomerInfo(String fileName, pojos.Customer[] customers) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));


            for (int i=0; i< customers.length; i++){
                writer.append(customers[i].getFirstName()+" , "+customers[i].getLastName()+"\n");
                if (customers[i].getUser()!=null)
                    writer.append(customers[i].getUser().getLastName());
                if (customers[i].getCountry()!=null)
                    writer.append(customers[i].getCountry().getName());
            }
            writer.close();
        } catch (Exception e) {
        }
    }
}
