
public class AddUserController {

    public AddUserController() {

    }

    public double getTienLuong(String s) {
        if (s.equals("")) {
            s = "0";
        }
        s = s.trim().replaceAll(",", "");
        double t = Double.parseDouble(s);
        return t;
    }

    public double getTroCap(String s) {

        if (s.equals("")) {
            s = "0";
        }
        s = s.trim().replaceAll(",", "");
        double t = Double.parseDouble(s);
        return t;
    }

    public double getTongTroCap(double a, double b, double c, double d, double e, double f, double g, double h) {
        double tong = a + b + c + d + e + f + g + h;
        return tong;
    }

    public double getTienLuongChange(int i, boolean a, boolean b, double c) {
        double u3 = c;
        double sum = 0;
        switch (i) {
            case 1: {
                sum = 4420000;
                if (a == true && b == false) {
                    sum = sum + (sum * 7) / 100;
                } else if (a == false && b == true) {
                    sum = sum + (sum * 5) / 100;
                } else if (a == true && b == true) {
                    sum = sum + (sum * 5) / 100 + (sum * 7) / 100;
                }
                if (u3 < sum) {
                    u3 = sum;
                } else if (u3 > 29800000) {
                    u3 = 29800000;
                }
                break;
            }
            case 2: {
                sum = 3920000;
                if (a == true && b == false) {
                    sum = sum + (sum * 7) / 100;
                } else if (a == false && b == true) {
                    sum = sum + (sum * 5) / 100;
                } else if (a == true && b == true) {
                    sum = sum + (sum * 5) / 100 + (sum * 7) / 100;
                }
                if (u3 < sum) {
                    u3 = sum;
                } else if (u3 > 29800000) {
                    u3 = 29800000;
                }
                break;
            }
            case 3: {
                sum = 3430000;
                if (a == true && b == false) {
                    sum = sum + (sum * 7) / 100;
                } else if (a == false && b == true) {
                    sum = sum + (sum * 5) / 100;
                } else if (a == true && b == true) {
                    sum = sum + (sum * 5) / 100 + (sum * 7) / 100;
                }
                if (u3 < sum) {
                    u3 = sum;
                } else if (u3 > 29800000) {
                    u3 = 29800000;
                }
                break;
            }
            case 4: {
                sum = 3070000;
                if (a == true && b == false) {
                    sum = sum + (sum * 7) / 100;
                } else if (a == false && b == true) {
                    sum = sum + (sum * 5) / 100;
                } else if (a == true && b == true) {
                    sum = sum + (sum * 5) / 100 + (sum * 7) / 100;
                }
                if (u3 < sum) {
                    u3 = sum;
                } else if (u3 > 29800000) {
                    u3 = 29800000;
                }
                break;
            }
        }
        return u3;
    }

    public String getDaoTao(boolean a) {
        String u5 = "";
        if (a == true) {
            u5 = "yes";
        } else {
            u5 = "no";
        }
        return u5;
    }

    public String getNangNhoc(boolean a) {
        String u5 = "";
        if (a == true) {
            u5 = "yes";
        } else {
            u5 = "no";
        }
        return u5;
    }

    public String getHinhThucBH(int i) {
        String u7 = "";
        if (i == 0) {
            u7 = "bat buoc";
        } else {
            u7 = "tu nguyen";
        }
        return u7;
    }

    public void UpdateInfo(String s, String s1, int i, double a, double b, String s2, String s3, String s4) {
        MyConnection myconnection = new MyConnection();
        myconnection.connect();
        myconnection.update(s, new User(s, s1, i, a, b, s2, s3, s4));
    }
}
