import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
public class DateTime {

    public static boolean formatDate(String expedetionDate) throws ParseException {
        boolean a=true;
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a dd-MM-yyyy";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        Date dt_1 = objSDF.parse(objSDF.format(date));
        Date dt_2 = objSDF.parse(expedetionDate);

        System.out.println("Current Date : " + objSDF.format(dt_1));
        System.out.println("Your expedition date : " + objSDF.format(dt_2));

        if (dt_1.compareTo(dt_2) > 0) {
            //System.out.println("Date 1 occurs after Date 2");
            return false;
        }
        else if (dt_1.compareTo(dt_2) <= 0) {
            //System.out.println("Date 1 occurs before Date 2");
            return true;
        }

        return a;

    }
}
