package gmibank.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {


    // MMMM dd, yyy  --> February 17, 2019
    public static String todaysDate(){
    String today = new SimpleDateFormat("MMMM dd, yyy").format(new Date());
    return today;
    }

    // MM-dd-yy     --> 02-17-19
    public static String todaysDate2(){
        String today = new SimpleDateFormat("MM-dd-yy").format(new Date());
        return today;
    }

    // dd-MM-yy    --> 17-02-19
    public static String todaysDate3(){
        String today = new SimpleDateFormat("dd-MM-yy").format(new Date());
        return today;
    }

    // yyyy-MM-dd hh:mm:ss   --> 2019-02-17 03:45:11
    public static String todaysDate4(){
        String today = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        return today;
    }
    
    // dd-MM-yy-HH-mm   --> 17-02-19-03-45 (24 Hour format)
    public static String todaysDate5(){
        String today = new SimpleDateFormat("dd-MM-yy-HH-mm").format(new Date());
        return today;
    }
    
    // MM-dd-yy-HH-mm   --> 02-17-19-03-45 (24 Hour format)
    public static String todaysDate6(){
        String today = new SimpleDateFormat("MM-dd-yy-HH-mm").format(new Date());
        return today;
    }
    
    // MMdd00yyyyhhmm   --> 02170020190345
    public static String todaysDate7(){
        String today = new SimpleDateFormat("MMdd00yyyyhhmm").format(new Date());
        return today;
    }
    
}






