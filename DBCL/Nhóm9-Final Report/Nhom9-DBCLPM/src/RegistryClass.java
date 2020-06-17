
public class RegistryClass {

    public RegistryClass() {

    }

    public void DangKi(String a, String b, String c, String d, String e, String f, String g) {
        MyConnection myconnection = new MyConnection();
        myconnection.connect();
        myconnection.insert(new User(a, b, c, d, e, f, g));
    }
}
