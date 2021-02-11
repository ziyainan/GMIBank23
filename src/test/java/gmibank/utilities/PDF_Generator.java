package gmibank.utilities;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import gmibank.pojo.Country;
import gmibank.pojo.Customer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PDF_Generator {
    public static void pdfGenerator(String header, String fileName){

        Document document = new Document();
        String pdf_path = fileName;
        String pdf_Title= header;

        List<String> headers = new ArrayList<>();
        headers.add("Applicant");
        headers.add("SSN");
        headers.add("Country");
        headers.add("State");
        headers.add("Zip code");

        try {
            PdfWriter writer= PdfWriter.getInstance(document, new FileOutputStream(pdf_path));
            document.open();
            document.add(new Paragraph(pdf_Title));

            PdfPTable pdfTable = new PdfPTable(5);
            pdfTable.setWidthPercentage(110);
            pdfTable.setSpacingBefore(12);
            pdfTable.setSpacingAfter(12);

            float[] colWidth = {2,2,2,2,2};
            pdfTable.setWidths(colWidth);

            for(int i=0; i<headers.size();i++){
                PdfPCell cellHeader = new PdfPCell(new Paragraph("              "+headers.get(i)));
                pdfTable.addCell(cellHeader);
            }
            document.add(pdfTable);
            document.close();
            writer.clearTextWrap();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void pdfGeneratorRowsAndCellsWithList(String header, List<Customer> list, String fileName){

        Document document = new Document();
        String pdf_path = fileName;
        String pdf_Title= header;
        String logoPath = "src/test/resources/test_data1/CustomerTrial.pdf";

        List<String> headers = new ArrayList<>();
        headers.add("Applicant");
        headers.add("SSN");
        headers.add("Country");
        headers.add("State");
        headers.add("Zip code");

        try {
            PdfWriter writer= PdfWriter.getInstance(document, new FileOutputStream(pdf_path));
            document.open();
            document.add(new Paragraph("             "+pdf_Title));

            PdfPTable pdfTable = new PdfPTable(5);
            pdfTable.setWidthPercentage(110);
            pdfTable.setSpacingBefore(25);
            pdfTable.setSpacingAfter(25);

            float[] colWidth = {2,2,2,2,2};
            pdfTable.setWidths(colWidth);

            for(int i=0; i<headers.size();i++){
                PdfPCell cellHeader = new PdfPCell(new Phrase(headers.get(i)));
                pdfTable.addCell(cellHeader);
            }
              pdfTable.setHeaderRows(list.size());

            for (int i = 0;i<list.size();i++){
                pdfTable.addCell(list.get(i).getFirstName());
                pdfTable.addCell(list.get(i).getSsn());
                pdfTable.addCell(list.get(i).getCountry().getName());
                pdfTable.addCell(list.get(i).getState());
                pdfTable.addCell(list.get(i).getZipCode());
            }
            document.add(pdfTable);
            //document.add(Image.getInstance(logoPath));
            document.close();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   

    public static void main(String[] args) {
       // pdfGenerator("Customer Data P3","src/test/resources/test_data1/CustomerInfoP3.pdf");
        String header = "Customer Info Project3";
        String fileName = "src/test/resources/test_data1/CustomerTrial.pdf";

        List<Customer> customerList = new ArrayList<>();
        Customer customer = new Customer();
        customer.setFirstName("Muhammed");
        customer.setSsn("233-345-3456");
        customer.setState("Virginia");
        customer.setZipCode("12444");
        
        Country country = new Country();
        country.setName("USA");
        customer.setCountry(country);

        Customer customer2 = new Customer();
        customer2.setFirstName("Ahmed");
        customer2.setSsn("233-345-3457");
        customer2.setState("North Caroline");
        customer2.setZipCode("12555");

        Country country2 = new Country();
        country2.setName("USA");
        customer2.setCountry(country2);

        customerList.add(customer);
        customerList.add(customer2);

        pdfGeneratorRowsAndCellsWithList(header,customerList,fileName);
    }
}
