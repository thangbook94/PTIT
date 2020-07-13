
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author os_thangnd
 */
public class MyConnectionTest {

    private static MyConnection myConnection;

    public MyConnectionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        myConnection = new MyConnection();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConnect() {
        MyConnection myConnection = new MyConnection();
        Assert.assertEquals(true, myConnection.connect());
    }

    @Test
    public void testInsert() {
        System.out.println("-----------------------------");
        System.out.println("Begin insert testing");
        Assert.assertEquals(true, myConnection.connect());
        User user = new User("123321123", "thangbook", "thangbook@gmail.com", "nguyen dinh thang", "20/10/1993", "yes", 0, 1, 2, "yes", "yes", "bat buoc");
        Connection con = myConnection.getConnection();
        try {
            con.setAutoCommit(false);
            //insert success
            Assert.assertEquals(true, myConnection.insert(user));
            ResultSet rs = myConnection.getData();
            rs.last();
            assertNotNull(rs);
            Assert.assertEquals(4, rs.getRow());
            rs = myConnection.getDataCmt("123321123");
            assertNotNull(rs);
            int count = 0;
            while (rs.next()) {
                ++count;
                String cmt = rs.getString("cmt");
                String pass = rs.getString("password");
                String mail = rs.getString("email");
                String fullName = rs.getString("hoten");
                String dateOfBirth = rs.getString("date");
                String status = rs.getString("status");
                int region = Integer.parseInt(rs.getString("region"));
                int salary = Integer.parseInt(rs.getString("salary"));
                int allow = Integer.parseInt(rs.getString("allowance"));
                String train = rs.getString("train");
                String warning = rs.getString("warning");
                String type = rs.getString("type");
                Assert.assertEquals("123321123", cmt);
                Assert.assertEquals("thangbook", pass);
                Assert.assertEquals("thangbook@gmail.com", mail);
                Assert.assertEquals("nguyen dinh thang", fullName);
                Assert.assertEquals("yes", status);
                Assert.assertEquals("20/10/1993", dateOfBirth);
                Assert.assertEquals(0, region);
                Assert.assertEquals(1, salary);
                Assert.assertEquals(2, allow);
                Assert.assertEquals("yes", train);
                Assert.assertEquals("yes", warning);
                Assert.assertEquals("bat buoc", type);
            }
            Assert.assertEquals(1, count);
            //insert fail
            Assert.assertEquals(false, myConnection.insert(user));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finish insert testing");
        return;
    }

    @Test
    public void testUpdate() {
        System.out.println("-----------------------------");
        System.out.println("Begin testing update");
        Assert.assertEquals(true, myConnection.connect());
        User user = new User("222222222", "thangbook", "thangbook@gmail.com", "nguyen dinh thang", "20/10/1993", "yes", 0, 1, 2, "yes", "yes", "bat buoc");
        Connection con = myConnection.getConnection();
        try {
            con.setAutoCommit(false);
            //update success
            Assert.assertEquals(true, myConnection.update("222222222", user));
            ResultSet rs = myConnection.getData();
            assertNotNull(rs);
            rs.last();
            Assert.assertEquals(3, rs.getRow());
            rs = myConnection.getDataCmt("222222222");
            assertNotNull(rs);
            int count = 0;
            while (rs.next()) {
                ++count;
                String cmt = rs.getString("cmt");
                String mail = rs.getString("email");
                String dateOfBirth = rs.getString("date");
                String status = rs.getString("status");
                int region = Integer.parseInt(rs.getString("region"));
                int salary = Integer.parseInt(rs.getString("salary"));
                int allow = Integer.parseInt(rs.getString("allowance"));
                String train = rs.getString("train");
                String warning = rs.getString("warning");
                String type = rs.getString("type");
                Assert.assertEquals("222222222", cmt);
                Assert.assertEquals("thaotd@gmail.com", mail);
                Assert.assertEquals("yes", status);
                Assert.assertEquals("22/02/1998", dateOfBirth);
                Assert.assertEquals(0, region);
                Assert.assertEquals(1, salary);
                Assert.assertEquals(2, allow);
                Assert.assertEquals("yes", train);
                Assert.assertEquals("yes", warning);
                Assert.assertEquals("bat buoc", type);
            }
            Assert.assertEquals(1, count);
            //update fail
            user.setCmt("12332123123213213");
            Assert.assertEquals(false, myConnection.update("12332123123213213", user));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finish testing update");
        return;
    }

    @Test
    public void testUpdateMoney() {
        System.out.println("-----------------------------");
        System.out.println("Begin testing update money");
        //update success
        Assert.assertEquals(true, myConnection.connect());
        User user = new User();
        user.setCmt("222222222");
        user.setStatuscal("no");
        user.setMoney(2312321);
        Connection con = myConnection.getConnection();
        try {
            con.setAutoCommit(false);
            Assert.assertEquals(true, myConnection.updateMoney("222222222", user));
            ResultSet rs = myConnection.getData();
            assertNotNull(rs);
            rs.last();
            Assert.assertEquals(3, rs.getRow());
            rs = myConnection.getDataCmt("222222222");
            assertNotNull(rs);
            int count = 0;
            while (rs.next()) {
                count++;
                String statusCal = rs.getString("statuscal");
                int money = Integer.parseInt(rs.getString("money"));
                Assert.assertEquals(2312321, money);
                Assert.assertEquals("no", statusCal);
            }
            Assert.assertEquals(1, count);
            //update fail
            user.setCmt("555555555");
            Assert.assertEquals(false, myConnection.updateMoney("555555555", user));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finish testing update money");
        return;
    }

    @Test
    public void testGetDataCmt() {
        System.out.println("-----------------------------");
        System.out.println("Begin testing get data by cmt");
        Assert.assertEquals(true, myConnection.connect());
        Connection con = myConnection.getConnection();
        try {
            con.setAutoCommit(false);
            //find an id in db
            ResultSet rs = myConnection.getDataCmt("333333333");
            assertNotNull(rs);
            int count = 0;
            while (rs.next()) {
                ++count;
                String cmt = rs.getString("cmt");
                String mail = rs.getString("email");
                String hoten = rs.getString("hoten");
                String dateOfBirth = rs.getString("date");
                String status = rs.getString("status");
                int region = Integer.parseInt(rs.getString("region"));
                int salary = Integer.parseInt(rs.getString("salary"));
                int allow = Integer.parseInt(rs.getString("allowance"));
                String train = rs.getString("train");
                String warning = rs.getString("warning");
                String type = rs.getString("type");
                String statusCal = rs.getString("statuscal");
                double money = Double.parseDouble(rs.getString("money"));
                Assert.assertEquals("333333333", cmt);
                Assert.assertEquals("thunt@gmail.com", mail);
                Assert.assertEquals("yes", status);
                Assert.assertEquals("21/12/1998", dateOfBirth);
                Assert.assertEquals(3, region);
                Assert.assertEquals(29800000, salary);
                Assert.assertEquals(188679814, allow);
                Assert.assertEquals("yes", train);
                Assert.assertEquals("no", warning);
                Assert.assertEquals("bat buoc", type);
                Assert.assertEquals("yes", statusCal);
                Assert.assertEquals(22940380, (int) money);
            }
            Assert.assertEquals(1, count);
            //find an id not in db
            rs = myConnection.getDataCmt("5555555555");
            Assert.assertNotNull(rs);
            count = 0;
            while (rs.next()) {
                count++;
            }
            Assert.assertEquals(0, count);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finish testing get data by cmt");
        return;
    }

    @Test
    public void testGetData() {
        System.out.println("-----------------------------");
        System.out.println("Begin testing get all data");
        Assert.assertEquals(true, myConnection.connect());
        Connection con = myConnection.getConnection();
        try {
            con.setAutoCommit(false);
            ResultSet rs = myConnection.getData();
            assertNotNull(rs);
            ArrayList<User> listUser = new ArrayList<>();
            while (rs.next()) {
                String cmt = rs.getString("cmt");
                String pass = rs.getString("password");
                String mail = rs.getString("email");
                String fullName = rs.getString("hoten");
                String dateOfBirth = rs.getString("date");
                String status = rs.getString("status");
                int region = Integer.parseInt(rs.getString("region"));
                int salary = Integer.parseInt(rs.getString("salary"));
                int allow = Integer.parseInt(rs.getString("allowance"));
                String train = rs.getString("train");
                String warning = rs.getString("warning");
                String type = rs.getString("type");
                String statusCal = rs.getString("statuscal");
                Double money = Double.parseDouble(rs.getString("money"));
                User u = new User(cmt, pass, mail, fullName, dateOfBirth, status, region, salary, allow, train, warning, type);
                u.setMoney(money);
                u.setStatuscal(statusCal);
                listUser.add(u);
            }
            Assert.assertEquals(3, listUser.size());
            Assert.assertEquals("111111111", listUser.get(0).getCmt());
            Assert.assertEquals("222222222", listUser.get(1).getCmt());
            Assert.assertEquals("333333333", listUser.get(2).getCmt());
            Assert.assertNotNull(listUser.get(2).getTrain());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finish testing get all data");
        return;
    }
}
