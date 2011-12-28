/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yuni
 */
public class DaftarGedungTest {

    public DaftarGedungTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getEntityManager method, of class DaftarGedung.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        DaftarGedung instance = new DaftarGedung();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addGedung method, of class DaftarGedung.
     */
    @Test
    public void testAddGedung() {
        System.out.println("addGedung");
        Gedung gedung = null;
        DaftarGedung instance = new DaftarGedung();
        instance.addGedung(gedung);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDaftarGedung method, of class DaftarGedung.
     */
    @Test
    public void testGetDaftarGedung() {
        System.out.println("getDaftarGedung");
        DaftarGedung instance = new DaftarGedung();
        List expResult = null;
        List result = instance.getDaftarGedung();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDaftarGedungPemilik method, of class DaftarGedung.
     */
    @Test
    public void testGetDaftarGedungPemilik() {
        System.out.println("getDaftarGedungPemilik");
        long idpemilik = 0L;
        DaftarGedung instance = new DaftarGedung();
        List expResult = null;
        List result = instance.getDaftarGedungPemilik(idpemilik);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGedung method, of class DaftarGedung.
     */
    @Test
    public void testGetGedung() {
        System.out.println("getGedung");
        long id = 0L;
        DaftarGedung instance = new DaftarGedung();
        Gedung expResult = null;
        Gedung result = instance.getGedung(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editGedung method, of class DaftarGedung.
     */
    @Test
    public void testEditGedung() {
        System.out.println("editGedung");
        Gedung gedung = null;
        DaftarGedung instance = new DaftarGedung();
        instance.editGedung(gedung);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteGedung method, of class DaftarGedung.
     */
    @Test
    public void testDeleteGedung() throws Exception {
        System.out.println("deleteGedung");
        Long id = null;
        DaftarGedung instance = new DaftarGedung();
        instance.deleteGedung(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}