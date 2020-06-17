
import java.sql.ResultSet;
import java.text.DecimalFormat;

public class BHXHController {

    public BHXHController() {

    }

    public ResultSet getData(String s) {
        MyConnection myconnection = new MyConnection();
        myconnection.connect();
        ResultSet r = myconnection.getDataCmt(s);
        return r;
    }

    public String getVung(int s) {
        String region = "";
        switch (s) {
            case 1: {
                region = "vùng 1";
                break;
            }
            case 2: {
                region = "vùng 2";
                break;
            }
            case 3: {
                region = "vùng 3";
                break;
            }
            case 4: {
                region = "vùng 4";
                break;
            }
        }
        return region;
    }

    public String getLuong(double s) {
        String pattern = "###,###,###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String luongS = decimalFormat.format(s);
        return luongS;
    }

    public String getTroCap(double s) {
        String pattern = "###,###,###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String subS = decimalFormat.format(s);
        return subS;
    }

    public String getDaoTao(String s) {
        String train;
        if (s.equals("yes")) {
            train = "Có qua đào tạo";
        } else {
            train = "Không qua đào tạo";
        }
        return train;
    }

    public String getNangNhoc(String s) {

        String allow;
        if (s.equals("yes")) {
            allow = "Công việc nặng nhọc, nguy hiểm";
        } else {
            allow = "Công việc không nặng nhọc, nguy hiểm";
        }
        return allow;
    }

    public double getTienBH(String s, double a, double b) {
        double dong = 0;
        if (s.equals("bat buoc")) {

            dong = ((a + b) * 10.5) / 100;
        } else {

            dong = ((a + b) * 22) / 100;
        }

        return dong;
    }

    public void UpdateMoney(String s, double a, String s1) {
        MyConnection myconnection = new MyConnection();
        myconnection.connect();
        myconnection.updateMoney(s, new User(s, a, s1));

    }
}
