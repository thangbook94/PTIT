package nhom7.thh.meomeonote;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {

        System.out.println(new Date().toString());
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        String strDate = dateFormat.format(date);
        System.out.println("Converted String: " + strDate);
        System.out.println("Converted String: " + strDate.substring(9));
    }
}