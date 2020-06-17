/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MSI
 */
public class BHXHControllerTest {

    public BHXHControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
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

//    /**
//     * Test of getData method, of class BHXHController.
//     */
//    @Test
//    public void testGetData() {
//        System.out.println("getData");
//        String s = "";
//        BHXHController instance = new BHXHController();
//        ResultSet expResult = null;
//        ResultSet result = instance.getData(s);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of getVung method, of class BHXHController.
     */
    @Test
    public void testGetVung() {
        System.out.println("getVung");
        int s = 1;
        BHXHController instance = new BHXHController();
        String expResult = "vùng 1";
        String result = instance.getVung(s);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetVung1() {
        System.out.println("getVung1");
        int s = 2;
        BHXHController instance = new BHXHController();
        String expResult = "vùng 2";
        String result = instance.getVung(s);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetVung2() {
        System.out.println("getVung2");
        int s = 3;
        BHXHController instance = new BHXHController();
        String expResult = "vùng 3";
        String result = instance.getVung(s);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetVung3() {
        System.out.println("getVung3");
        int s = 4;
        BHXHController instance = new BHXHController();
        String expResult = "vùng 4";
        String result = instance.getVung(s);
        assertEquals(expResult, result);

    }

    /**
     * Test of getLuong method, of class BHXHController.
     */
    @Test
    public void testGetLuong() {
        System.out.println("getLuong");
        double s = 5000000;
        BHXHController instance = new BHXHController();
        String expResult = "5,000,000";
        String result = instance.getLuong(s);
        assertEquals(expResult, result);

    }

    /**
     * Test of getTroCap method, of class BHXHController.
     */
    @Test
    public void testGetTroCap() {
        System.out.println("getTroCap");
        double s = 6000000;
        BHXHController instance = new BHXHController();
        String expResult = "6,000,000";
        String result = instance.getTroCap(s);
        assertEquals(expResult, result);

    }

    /**
     * Test of getDaoTao method, of class BHXHController.
     */
    @Test
    public void testGetDaoTao() {
        System.out.println("getDaoTao");
        String s = "yes";
        BHXHController instance = new BHXHController();
        String expResult = "Có qua đào tạo";
        String result = instance.getDaoTao(s);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetDaoTao1() {
        System.out.println("getDaoTao1");
        String s = "no";
        BHXHController instance = new BHXHController();
        String expResult = "Không qua đào tạo";
        String result = instance.getDaoTao(s);
        assertEquals(expResult, result);

    }

    /**
     * Test of getNangNhoc method, of class BHXHController.
     */
    @Test
    public void testGetNangNhoc() {
        System.out.println("getNangNhoc");
        String s = "yes";
        BHXHController instance = new BHXHController();
        String expResult = "Công việc nặng nhọc, nguy hiểm";
        String result = instance.getNangNhoc(s);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetNangNhoc1() {
        System.out.println("getNangNhoc1");
        String s = "no";
        BHXHController instance = new BHXHController();
        String expResult = "Công việc không nặng nhọc, nguy hiểm";
        String result = instance.getNangNhoc(s);
        assertEquals(expResult, result);

    }

    /**
     * Test of getTienBH method, of class BHXHController.
     */
    @Test
    public void testGetTienBH() {
        System.out.println("getTienBH");
        String s = "bat buoc";
        double a = 5000000;
        double b = 1000000;
        BHXHController instance = new BHXHController();
        double expResult = 630000;
        double result = instance.getTienBH(s, a, b);
        assertEquals(expResult, result, 0.0);

    }

    @Test
    public void testGetTienBH1() {
        System.out.println("getTienBH1");
        String s = "tu nguyen";
        double a = 5000000;
        double b = 1000000;
        BHXHController instance = new BHXHController();
        double expResult = 1320000;
        double result = instance.getTienBH(s, a, b);
        assertEquals(expResult, result, 0.0);

    }

//    /**
//     * Test of UpdateMoney method, of class BHXHController.
//     */
//    @Test
//    public void testUpdateMoney() {
//        System.out.println("UpdateMoney");
//        String s = "";
//        double a = 0.0;
//        String s1 = "";
//        BHXHController instance = new BHXHController();
//        instance.UpdateMoney(s, a, s1);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
