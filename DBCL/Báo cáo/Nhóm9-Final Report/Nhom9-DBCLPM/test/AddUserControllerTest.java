/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class AddUserControllerTest {

    private static AddUserController instance;

    public AddUserControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        instance = new AddUserController();
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

    /**
     * Test of getTienLuong method, of class AddUserController.
     */
    @Test
    public void testGetTienLuong() {
        System.out.println("getTienLuong");
        String s = "10,000,000";
        double expResult = 10000000;
        double result = instance.getTienLuong(s);
        assertEquals(expResult, result, 0.0);

    }

    @Test
    public void testGetTienLuong1() {
        System.out.println("getTienLuong1");
        String s = "";
        double expResult = 0;
        double result = instance.getTienLuong(s);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getTroCap method, of class AddUserController.
     */
    @Test
    public void testGetTroCap() {
        System.out.println("getTroCap");
        String s = "2,000,000";
        double expResult = 2000000;
        double result = instance.getTroCap(s);
        assertEquals(expResult, result, 0.0);

    }

    @Test
    public void testGetTroCap1() {
        System.out.println("getTroCap1");
        String s = "";
        double expResult = 0;
        double result = instance.getTroCap(s);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getTongTroCap method, of class AddUserController.
     */
    @Test
    public void testGetTongTroCap() {
        System.out.println("getTongTroCap");
        double a = 1;
        double b = 2;
        double c = 1;
        double d = 1;
        double e = 1;
        double f = 1;
        double g = 1;
        double h = 1;
        double expResult = 9;
        double result = instance.getTongTroCap(a, b, c, d, e, f, g, h);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getTienLuongChange method, of class AddUserController.
     */
    @Test
    public void testGetTienLuongChange() {
        System.out.println("getTienLuongChange");
        int i = 1;
        boolean a = true;
        boolean b = false;
        double c = 4000000;
        double expResult = 4729400;
        double result = instance.getTienLuongChange(i, a, b, c);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetTienLuongChange1() {
        System.out.println("getTienLuongChange1");
        int i = 1;
        boolean a = false;
        boolean b = true;
        double c = 4000000;
        double expResult = 4641000;
        double result = instance.getTienLuongChange(i, a, b, c);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetTienLuongChange2() {
        System.out.println("getTienLuongChange2");
        int i = 1;
        boolean a = true;
        boolean b = true;
        double c = 4000000;
        double expResult = 4950400;
        double result = instance.getTienLuongChange(i, a, b, c);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetTienLuongChange3() {
        System.out.println("getTienLuongChange3");
        int i = 1;
        boolean a = true;
        boolean b = false;
        double c = 30000000;
        double expResult = 29800000;
        double result = instance.getTienLuongChange(i, a, b, c);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetTienLuongChange4() {
        System.out.println("getTienLuongChange4");
        int i = 2;
        boolean a = true;
        boolean b = false;
        double c = 4000000;
        double expResult = 4194400;
        double result = instance.getTienLuongChange(i, a, b, c);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetTienLuongChange5() {
        System.out.println("getTienLuongChange5");
        int i = 2;
        boolean a = false;
        boolean b = true;
        double c = 4000000;
        double expResult = 4116000;
        double result = instance.getTienLuongChange(i, a, b, c);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetTienLuongChange6() {
        System.out.println("getTienLuongChange6");
        int i = 2;
        boolean a = true;
        boolean b = true;
        double c = 4000000;
        double expResult = 4390400;
        double result = instance.getTienLuongChange(i, a, b, c);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetTienLuongChange7() {
        System.out.println("getTienLuongChange7");
        int i = 2;
        boolean a = true;
        boolean b = false;
        double c = 30000000;
        double expResult = 29800000;
        double result = instance.getTienLuongChange(i, a, b, c);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetTienLuongChange8() {
        System.out.println("getTienLuongChange8");
        int i = 3;
        boolean a = true;
        boolean b = false;
        double c = 3000000;
        double expResult = 3670100;
        double result = instance.getTienLuongChange(i, a, b, c);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetTienLuongChange9() {
        System.out.println("getTienLuongChange9");
        int i = 3;
        boolean a = false;
        boolean b = true;
        double c = 3000000;
        double expResult = 3601500;
        double result = instance.getTienLuongChange(i, a, b, c);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetTienLuongChange10() {
        System.out.println("getTienLuongChange10");
        int i = 3;
        boolean a = true;
        boolean b = true;
        double c = 3000000;
        double expResult = 3841600;
        double result = instance.getTienLuongChange(i, a, b, c);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetTienLuongChange11() {
        System.out.println("getTienLuongChange11");
        int i = 3;
        boolean a = true;
        boolean b = false;
        double c = 30000000;
        double expResult = 29800000;
        double result = instance.getTienLuongChange(i, a, b, c);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetTienLuongChange12() {
        System.out.println("getTienLuongChange12");
        int i = 4;
        boolean a = true;
        boolean b = false;
        double c = 3000000;
        double expResult = 3284900;
        double result = instance.getTienLuongChange(i, a, b, c);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetTienLuongChange13() {
        System.out.println("getTienLuongChange13");
        int i = 4;
        boolean a = false;
        boolean b = true;
        double c = 3000000;
        double expResult = 3223500;
        double result = instance.getTienLuongChange(i, a, b, c);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetTienLuongChange14() {
        System.out.println("getTienLuongChange14");
        int i = 4;
        boolean a = true;
        boolean b = true;
        double c = 3000000;
        double expResult = 3438400;
        double result = instance.getTienLuongChange(i, a, b, c);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetTienLuongChange15() {
        System.out.println("getTienLuongChange15");
        int i = 4;
        boolean a = true;
        boolean b = false;
        double c = 30000000;
        double expResult = 29800000;
        double result = instance.getTienLuongChange(i, a, b, c);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getDaoTao method, of class AddUserController.
     */
    @Test
    public void testGetDaoTao() {
        System.out.println("getDaoTao");
        boolean a = true;
        String expResult = "yes";
        String result = instance.getDaoTao(a);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDaoTao1() {
        System.out.println("getDaoTao1");
        boolean a = false;
        String expResult = "no";
        String result = instance.getDaoTao(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNangNhoc method, of class AddUserController.
     */
    @Test
    public void testGetNangNhoc() {
        System.out.println("getNangNhoc");
        boolean a = true;
        String expResult = "yes";
        String result = instance.getNangNhoc(a);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNangNhoc1() {
        System.out.println("getNangNhoc1");
        boolean a = false;
        String expResult = "no";
        String result = instance.getNangNhoc(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHinhThucBH method, of class AddUserController.
     */
    @Test
    public void testGetHinhThucBH() {
        System.out.println("getHinhThucBH");
        int i = 0;
        String expResult = "bat buoc";
        String result = instance.getHinhThucBH(i);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetHinhThucBH1() {
        System.out.println("getHinhThucBH1");
        int i = 1;
        String expResult = "tu nguyen";
        String result = instance.getHinhThucBH(i);
        assertEquals(expResult, result);

    }

//    /**
//     * Test of UpdateInfo method, of class AddUserController.
//     */
//    @Test
//    public void testUpdateInfo() {
//        System.out.println("UpdateInfo");
//        String s = "";
//        String s1 = "";
//        int i = 0;
//        double a = 0.0;
//        double b = 0.0;
//        String s2 = "";
//        String s3 = "";
//        String s4 = "";
//        AddUserController instance = new AddUserController();
//        instance.UpdateInfo(s, s1, i, a, b, s2, s3, s4);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
