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
public class DaftarSubGedungTest {

    public DaftarSubGedungTest() {
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
     * Test of getEntityManager method, of class DaftarSubGedung.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        DaftarSubGedung instance = new DaftarSubGedung();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubGedung method, of class DaftarSubGedung.
     */
    @Test
    public void testGetSubGedung() {
        System.out.println("getSubGedung");
        Long id = null;
        DaftarSubGedung instance = new DaftarSubGedung();
        SubGedung expResult = null;
        SubGedung result = instance.getSubGedung(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSubGedung method, of class DaftarSubGedung.
     */
    @Test
    public void testAddSubGedung() {
        System.out.println("addSubGedung");
        SubGedung subgedung = null;
        DaftarSubGedung instance = new DaftarSubGedung();
        instance.addSubGedung(subgedung);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDaftarSubGedung method, of class DaftarSubGedung.
     */
    @Test
    public void testGetDaftarSubGedung_0args() {
        System.out.println("getDaftarSubGedung");
        DaftarSubGedung instance = new DaftarSubGedung();
        List expResult = null;
        List result = instance.getDaftarSubGedung();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubGedungfromId method, of class DaftarSubGedung.
     */
    @Test
    public void testGetSubGedungfromId() {
        System.out.println("getSubGedungfromId");
        int id = 0;
        DaftarSubGedung instance = new DaftarSubGedung();
        List expResult = null;
        List result = instance.getSubGedungfromId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteSubGedung method, of class DaftarSubGedung.
     */
    @Test
    public void testDeleteSubGedung() throws Exception {
        System.out.println("deleteSubGedung");
        Long id = null;
        DaftarSubGedung instance = new DaftarSubGedung();
        instance.deleteSubGedung(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editSubGedung method, of class DaftarSubGedung.
     */
    @Test
    public void testEditSubGedung() {
        System.out.println("editSubGedung");
        SubGedung subgedung = null;
        DaftarSubGedung instance = new DaftarSubGedung();
        instance.editSubGedung(subgedung);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDaftarSubGedung method, of class DaftarSubGedung.
     */
    @Test
    public void testGetDaftarSubGedung_long() {
        System.out.println("getDaftarSubGedung");
        long id_gedung = 0L;
        DaftarSubGedung instance = new DaftarSubGedung();
        List expResult = null;
        List result = instance.getDaftarSubGedung(id_gedung);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}